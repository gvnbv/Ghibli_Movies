package com.example.ghibli_movies.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ghibli_movies.R;

public class MovieDetails extends AppCompatActivity {

    TextView text;
    TextView text2;
    String strDescription;
    String strTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        text = findViewById(R.id.textView);
        strDescription = getIntent().getExtras().getString("Description : ");
        text.setText(strDescription);
    }
}
