package com.examples.android.homework.imdbparserex;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by Home on 19.05.2017.
 */

public class ImdbLoader extends AsyncTaskLoader<Film> {

    public ImdbLoader(Context context) {
        super(context);
    }

    @Override
    public Film loadInBackground() {
        return null;
    }
}
