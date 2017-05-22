package com.examples.android.homework.imdbparserex.application;

import android.app.Application;

import com.examples.android.homework.imdbparserex.storage.FilmListStorage;
import com.examples.android.homework.imdbparserex.storage.FilmListStorageProvider;

/**
 * Created by ASGalochkin on 22.05.2017.
 */

public class ImdbFilmsApplication extends Application implements FilmListStorageProvider {
    private FilmListStorage mFilmListStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        mFilmListStorage = new FilmListStorage();
    }

    @Override
    public FilmListStorage getStorage() {
        return mFilmListStorage;
    }
}
