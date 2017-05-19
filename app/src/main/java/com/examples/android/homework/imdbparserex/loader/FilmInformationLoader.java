package com.examples.android.homework.imdbparserex.loader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.FilmInformation;
import com.examples.android.homework.imdbparserex.parser.FilmInformationParser;

import java.lang.ref.WeakReference;
import java.net.URL;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformationLoader extends AsyncTaskLoader<FilmInformation> {
    private static final String TAG = "FilmInformationLoader";

    private URL filmInfoUrl;
    WeakReference<FilmInformationParser> mParserWeakReference;


    public FilmInformationLoader(Context context, URL filmInfoUrl, FilmInformationParser filmInformationParser) {
        super(context);
        this.mParserWeakReference = new WeakReference<>(filmInformationParser);
        this.filmInfoUrl = filmInfoUrl;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public FilmInformation loadInBackground() {
        FilmInformationParser filmInformationParser = mParserWeakReference.get();
        Log.d(TAG,"loadInBackground ");
        return filmInformationParser.parseInfo(filmInfoUrl);
    }
}
