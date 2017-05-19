package com.examples.android.homework.imdbparserex.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.entity.FilmsList;
import com.examples.android.homework.imdbparserex.parser.FilmParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by Home on 19.05.2017.
 */

public class ImdbLoader extends AsyncTaskLoader<FilmsList> {
    private final String TAG = this.getClass().getCanonicalName();
    WeakReference<FilmsList> listWeakReference;
    WeakReference<FilmParser> parserWeakReference;


    public ImdbLoader(Context context,FilmsList list,FilmParser parser) {
        super(context);
        listWeakReference = new WeakReference<FilmsList>(list);
        parserWeakReference = new WeakReference<FilmParser>(parser);
        Log.d(TAG, "public ImdbLoader(Context context,FilmsList list)");
    }

    @Override
    public FilmsList loadInBackground() {
        Log.d(TAG, " public FilmsList loadInBackground()");
        FilmsList result = listWeakReference.get();
        FilmParser parser = parserWeakReference.get();
        parser.parse(result);
        return result;
    }
}
