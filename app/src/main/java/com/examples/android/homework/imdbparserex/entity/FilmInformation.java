package com.examples.android.homework.imdbparserex.entity;

import android.graphics.Bitmap;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformation {

    private String mTitle;
    private Bitmap mIcon;
    private String mYear;
    private String mRating;
    private String mVotes;
    private String mActors;
    private String mPlot;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public void setIcon(Bitmap mIcon) {
        this.mIcon = mIcon;
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

    public String getVotes() {
        return mVotes;
    }

    public void setVotes(String mVotes) {
        this.mVotes = mVotes;
    }

    public String getActors() {
        return mActors;
    }

    public void setActors(String mActors) {
        this.mActors = mActors;
    }

    public String getPlot() {
        return mPlot;
    }

    public void setPlot(String mPlot) {
        this.mPlot = mPlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmInformation that = (FilmInformation) o;

        if (mTitle != null ? !mTitle.equals(that.mTitle) : that.mTitle != null)
            return false;
        if (mIcon != null ? !mIcon.equals(that.mIcon) : that.mIcon != null)
            return false;
        if (mYear != null ? !mYear.equals(that.mYear) : that.mYear != null)
            return false;
        if (mRating != null ? !mRating.equals(that.mRating) : that.mRating != null)
            return false;
        if (mVotes != null ? !mVotes.equals(that.mVotes) : that.mVotes != null)
            return false;
        if (mActors != null ? !mActors.equals(that.mActors) : that.mActors != null)
            return false;
        return mPlot != null ? mPlot.equals(that.mPlot) : that.mPlot == null;

    }

    @Override
    public int hashCode() {
        int result = mTitle != null ? mTitle.hashCode() : 0;
        result = 31 * result + (mIcon != null ? mIcon.hashCode() : 0);
        result = 31 * result + (mYear != null ? mYear.hashCode() : 0);
        result = 31 * result + (mRating != null ? mRating.hashCode() : 0);
        result = 31 * result + (mVotes != null ? mVotes.hashCode() : 0);
        result = 31 * result + (mActors != null ? mActors.hashCode() : 0);
        result = 31 * result + (mPlot != null ? mPlot.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilmInformation{" +
                "mTitle='" + mTitle + '\'' +
                ", mIcon=" + mIcon +
                ", mYear='" + mYear + '\'' +
                ", mRating='" + mRating + '\'' +
                ", mVotes='" + mVotes + '\'' +
                ", mActors='" + mActors + '\'' +
                ", mPlot='" + mPlot + '\'' +
                '}';
    }
}
