package com.examples.android.homework.imdbparserex.entity;

import android.graphics.Bitmap;

/**
 * Created by Home on 19.05.2017.
 */

public class Film {
    private Bitmap icon;
    private String title;
    private String rating;
    private String year;
    private String filmId;



    public Film(){}

    public Film(Bitmap icon, String title, String year, String rating, String filmId) {
        this.icon = icon;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.filmId = filmId;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public Bitmap getImage() {
        return icon;
    }

    public void setImageUrl(Bitmap imageUrl) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "icon=" + icon +
                ", title='" + title + '\'' +
                ", rating='" + rating + '\'' +
                ", year='" + year + '\'' +
                ", filmId='" + filmId + '\'' +
                '}';
    }
}
