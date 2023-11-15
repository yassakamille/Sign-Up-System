package com.apps.myapplication1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.myapplication1.databinding.ActivityStartBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartActivity extends AppCompatActivity {
    boolean pressTwiceToExit = false;
private @NonNull ActivityStartBinding binding;

    @Override
    public void onBackPressed() {
        if (pressTwiceToExit) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } else {
            pressTwiceToExit = true;
            Toast.makeText(this, " Press Again To Exit ", Toast.LENGTH_SHORT).show();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pressTwiceToExit = false;
                }
            }, 3000);
        }
    }
    RecyclerView recyclerView;
    AdvancedRecycleAdapter advancedRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        recyclerView = findViewById(R.id.rec);
    }

    public void updateData(ArrayList<Movie> models) {

        advancedRecycleAdapter.setData(models);
    }

    public void click(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);
        Call<MoviesModel> call = service.getMovieModel();
        call.enqueue(new Callback<MoviesModel>() {
            @Override
            public void onResponse(Call<MoviesModel> call, Response<MoviesModel> response) {
                if (response.isSuccessful()) {
                    MoviesModel moviesModel=response.body();
                    updateData(moviesModel.getMovies());
                }
            }

            @Override
            public void onFailure(Call<MoviesModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    class MyTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            String result = null;
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setConnectTimeout(5000);
                if (conn.getResponseCode() != 200) {
                    throw new IOException(conn.getResponseMessage());
                }

                BufferedReader buffrd = new BufferedReader(new InputStreamReader(
                        conn.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = buffrd.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
                buffrd.close();
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }


    }
}