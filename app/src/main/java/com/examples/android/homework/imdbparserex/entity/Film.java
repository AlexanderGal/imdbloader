package com.examples.android.homework.imdbparserex.entity;

import android.graphics.Bitmap;

/**
 * Created by Home on 19.05.2017.
 */

public class Film {
    private Bitmap mIcon;
    private String mTitle;
    private String mRating;
    private String mYear;
    private String mFilmId;


    public Film() {
    }

    public Film(Bitmap icon, String title, String year, String rating, String filmId) {
        this.mIcon = icon;
        this.mTitle = title;
        this.mYear = year;
        this.mRating = rating;
        this.mFilmId = filmId;
    }

    public String getFilmId() {
        return mFilmId;
    }

    public void setFilmId(String mFilmId) {
        this.mFilmId = mFilmId;
    }

    public Bitmap getImage() {
        return mIcon;
    }

    public void setImageUrl(Bitmap imageUrl) {
        this.mIcon = mIcon;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String mYear) {
        this.mYear = mYear;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String mRating) {
        this.mRating = mRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (mIcon != null ? !mIcon.equals(film.mIcon) : film.mIcon != null) return false;
        if (mTitle != null ? !mTitle.equals(film.mTitle) : film.mTitle != null) return false;
        if (mRating != null ? !mRating.equals(film.mRating) : film.mRating != null) return false;
        if (mYear != null ? !mYear.equals(film.mYear) : film.mYear != null) return false;
        return mFilmId != null ? mFilmId.equals(film.mFilmId) : film.mFilmId == null;

    }

    @Override
    public int hashCode() {
        int result = mIcon != null ? mIcon.hashCode() : 0;
        result = 31 * result + (mTitle != null ? mTitle.hashCode() : 0);
        result = 31 * result + (mRating != null ? mRating.hashCode() : 0);
        result = 31 * result + (mYear != null ? mYear.hashCode() : 0);
        result = 31 * result + (mFilmId != null ? mFilmId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "mIcon=" + mIcon +
                ", mTitle='" + mTitle + '\'' +
                ", mRating='" + mRating + '\'' +
                ", mYear='" + mYear + '\'' +
                ", mFilmId='" + mFilmId + '\'' +
                '}';
    }
}
