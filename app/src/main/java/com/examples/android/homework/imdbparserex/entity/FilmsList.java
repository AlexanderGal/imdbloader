package com.examples.android.homework.imdbparserex.entity;

import java.util.ArrayList;
import java.util.List;

public class FilmsList {
    private List<Film> list;

    public FilmsList() {
        this.list = new ArrayList<>();
    }

    public Film getFilm(int position) {
        return list.get(position);
    }

    public void addFilm(Film film) {
        list.add(film);
    }

    public void setList(List<Film> films) {
        this.list = list;
    }

    public List<Film> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "FilmsList{" +
                "list=" + list +
                '}';
    }
}
