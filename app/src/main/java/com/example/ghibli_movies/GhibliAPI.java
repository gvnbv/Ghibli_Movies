package com.example.ghibli_movies;


import com.example.ghibli_movies.model.Film;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliAPI {

    @GET("films")
    Call<List<Film>> loadChanges();
}
