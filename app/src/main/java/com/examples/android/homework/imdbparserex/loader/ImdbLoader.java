package com.examples.android.homework.imdbparserex.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.storage.FilmListStorage;
import com.examples.android.homework.imdbparserex.parser.FilmParser;

import java.util.List;

/**
 * Created by Home on 19.05.2017.
 */

public class ImdbLoader extends AsyncTaskLoader<List<Film>> implements FilmListStorage.OnContentChangedListener {
    private final static String TAG = ImdbLoader.class.getCanonicalName();
    private FilmListStorage mFilmListStorage;
    private List<Film> mCachedFilms;
    private FilmParser mFilmParser;

    @Override
    protected void onStartLoading() {
        Log.e(TAG, "protected void onStartLoading ()");
        if (mCachedFilms == null || takeContentChanged()) {
            forceLoad();
        }
    }

    public ImdbLoader(Context context, FilmListStorage storage, FilmParser parser) {
        super(context);
        Log.e(TAG, "public ImdbLoader(Context context,FilmListStorage list)");
        mFilmListStorage = storage;
        mFilmListStorage.addOnContentChangeListener(this);
        mFilmParser = parser;
    }

    @Override
    public List<Film> loadInBackground() {
        Log.e(TAG, " public FilmListStorage loadInBackground()");
            mFilmParser.parse(mFilmListStorage);
        return mFilmListStorage.getFilmList();
    }

    @Override
    public void deliverResult(List<Film> data) {
        Log.e(TAG, " public void deliverResult(List<Film> data)");
        super.deliverResult(data);
        mCachedFilms = data;
    }

    @Override
    protected void onReset() {
        mFilmListStorage.removeOnContentChangeListener(this);
    }

    @Override
    public void onContentChanged(FilmListStorage sender, Film film) {
        Log.e(TAG, "public void onContentChanged(FilmListStorage sender, Film film)");
        onContentChanged();
    }
}
