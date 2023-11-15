package com.apps.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Observable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.apps.myapplication1.databinding.ActivityStartBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    userdao db;
    TextView register_txt;
    Button Login;
    EditText Usernme ;
    EditText Userpasswrd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
      db= UserDatabase.getInstance(this).userdao();
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayoutCompat Main = findViewById(R.id.main_layout);
        AnimationDrawable Animation = (AnimationDrawable) Main.getBackground();
        Animation.setEnterFadeDuration(2500);
        Animation.setExitFadeDuration(5000);
        Animation.start();

        Login=findViewById(R.id.lgn_btn);
        register_txt =findViewById(R.id.rgstr_txt);
        Usernme=findViewById(R.id.usr_edt_lgn);
        Userpasswrd =findViewById(R.id.pass_edt_lgn);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamelogin = Usernme.getText().toString();
                String userpasslogin = Userpasswrd.getText().toString();
                if (usernamelogin.isEmpty() || userpasslogin.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Fill The " +
                            "Form First ", Toast.LENGTH_LONG).show();
                     }
                else {

user usr = db.getuser(usernamelogin,userpasslogin);
                    if (usr == null) {
                        Toast.makeText(MainActivity.this, " Wrong Username or Password ", Toast.LENGTH_SHORT).show();

                    }

                    if (usr!=null) {
                         Toast.makeText(MainActivity.this, "Welcome! "+usernamelogin, Toast.LENGTH_SHORT).show();
                         Intent gostart = new Intent(MainActivity.this, StartActivity.class);
                              startActivity(gostart);
                    }
                }
            }
        });
        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent goregister = new Intent(MainActivity.this,RegistraitionActivity.class);
                startActivity(goregister);
            }

        });

    }
}