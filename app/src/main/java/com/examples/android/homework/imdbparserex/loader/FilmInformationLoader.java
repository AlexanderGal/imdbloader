package com.examples.android.homework.imdbparserex.loader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.FilmInformation;
import com.examples.android.homework.imdbparserex.parser.FilmParser;

import java.net.URL;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformationLoader extends AsyncTaskLoader<FilmInformation> {
    private static final String TAG = FilmInformationLoader.class.getCanonicalName();

    private String mFilmInfoUrl;
    private FilmParser mParser;


    public FilmInformationLoader(Context context, String filmInfoUrl, FilmParser filmParser) {
        super(context);
        this.mParser = filmParser;
        this.mFilmInfoUrl = filmInfoUrl;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public FilmInformation loadInBackground() {
        Log.d(TAG, "loadInBackground ");
        return mParser.parseFilmInfo(mFilmInfoUrl);
    }
}
