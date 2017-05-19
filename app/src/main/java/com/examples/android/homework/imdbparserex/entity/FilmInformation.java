package com.examples.android.homework.imdbparserex.entity;

import android.graphics.Bitmap;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformation {

    private String movieTitle;
    private Bitmap movieIcon;
    private String movieYear;
    private String movieRating;
    private String movieVotes;
    private String movieActors;
    private String moviePlot;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Bitmap getMovieIcon() {
        return movieIcon;
    }

    public void setMovieIcon(Bitmap movieIcon) {
        this.movieIcon = movieIcon;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieVotes() {
        return movieVotes;
    }

    public void setMovieVotes(String movieVotes) {
        this.movieVotes = movieVotes;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getMoviePlot() {
        return moviePlot;
    }

    public void setMoviePlot(String moviePlot) {
        this.moviePlot = moviePlot;
    }
}
