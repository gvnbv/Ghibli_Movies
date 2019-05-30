package com.example.ghibli_movies.controller;

import com.example.ghibli_movies.GhibliAPI;
import com.example.ghibli_movies.model.Film;
import com.example.ghibli_movies.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller{

    static final String BASE_URL = "https://ghibliapi.herokuapp.com/";

    private MainActivity mainActivity;

    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GhibliAPI ghibliAPI = retrofit.create(GhibliAPI.class);

        Call<List<Film>> call = ghibliAPI.loadChanges();
        call.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if(response.isSuccessful()) {
                    List<Film> filmList = response.body();
                    mainActivity.displayListFilm(filmList);
                } else {
                    System.out.println(response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}