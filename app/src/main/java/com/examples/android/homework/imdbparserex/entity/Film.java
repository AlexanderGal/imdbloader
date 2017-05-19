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

    public Film(){}

    public Film(Bitmap icon, String title, String year, String rating) {
        this.icon = icon;
        this.title = title;
        this.year = year;
        this.rating = rating;
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
                "image ='" + icon.toString() + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
