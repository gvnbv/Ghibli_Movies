package com.example.ghibli_movies.model;

public class Film {
    String title;
    String director;
    String description;
    int release_date;

    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }
    public int getRelease_date(){
        return release_date;
    }

    public String getDescription(){
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
