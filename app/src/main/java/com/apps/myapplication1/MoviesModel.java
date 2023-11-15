package com.apps.myapplication1;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



    public class MoviesModel {

        ArrayList<Movie>results;
        @SerializedName("total_pages")
        String totalPages;
        @SerializedName("total_results")
        int  resultsNumber;
        public ArrayList<Movie> getMovies() {
            return results;
        }


        public ArrayList<Movie> getResults() {
            return results;
        }

        public String getTotalPages() {
            return totalPages;
        }

        public int getResultsNumber() {
            return resultsNumber;
        }
    }

