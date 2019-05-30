package com.example.ghibli_movies.view;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ghibli_movies.R;
import com.example.ghibli_movies.controller.Controller;
import com.example.ghibli_movies.model.Film;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    //Declaration des variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        Controller controller = new Controller(this);
        controller.start();
    }

    public void displayListFilm(List<Film> filmList) {
        //Instanciantion de recyclerview
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(filmList);
        recyclerView.setAdapter(mAdapter);
    }
}