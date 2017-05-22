package com.examples.android.homework.imdbparserex.storage;

import com.examples.android.homework.imdbparserex.entity.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmListStorage {
    private final List<Film> mFilmList;
    private final List<OnContentChangedListener> mListnersList;

    public FilmListStorage() {
        this.mFilmList = new ArrayList<>();
        this.mListnersList = new ArrayList<>();
    }

    public Film getFilm(int position) {
        return mFilmList.get(position);
    }

    public void addFilm(Film film) {
        mFilmList.add(film);
        for (OnContentChangedListener listener : mListnersList) {
            listener.onContentChanged(this, film);
        }
    }

    public void setFilmList(List<Film> newList){
        mFilmList.clear();
        mFilmList.addAll(newList);
    }

    public void fillList(Film film) {
        mFilmList.add(film);
    }

    public List<Film> getFilmList() {
        return new ArrayList<>(mFilmList);
    }

    public void addOnContentChangeListener(OnContentChangedListener listener) {
        mListnersList.add(listener);
    }

    public void removeOnContentChangeListener(OnContentChangedListener listener) {
        mListnersList.remove(listener);
    }

    @Override
    public String toString() {
        return "FilmListStorage{" +
                "mFilmList=" + mFilmList +
                '}';
    }

    public interface OnContentChangedListener {
        void onContentChanged(FilmListStorage sender, Film film);
    }
}
