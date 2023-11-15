package com.apps.myapplication1;
import retrofit2.Call;
import retrofit2.http.GET;



public interface  MovieService {
    @GET("top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af")
    Call<MoviesModel> getMovieModel();
}

