package com.examples.android.homework.imdbparserex.activity;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.examples.android.homework.imdbparserex.R;
import com.examples.android.homework.imdbparserex.adapter.RecyclerViewAdapter;
import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.storage.FilmListStorage;
import com.examples.android.homework.imdbparserex.loader.ImdbLoader;
import com.examples.android.homework.imdbparserex.parser.FilmParser;
import com.examples.android.homework.imdbparserex.storage.FilmListStorageProvider;

import java.util.List;

public class FilmsListActivity extends AppCompatActivity {
    private final static String TAG = FilmsListActivity.class.getCanonicalName();
    private final static int LOADER_ID = 4423421;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private FilmListStorage mFilmListStorage;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "protected void onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films_list_layout);

        FilmListStorageProvider provider = ((FilmListStorageProvider) getApplicationContext());
        mFilmListStorage = provider.getStorage();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLinearLayout = (LinearLayout) findViewById(R.id.loading_layout);

        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new FilmLoaderCallback());
    }

    private class FilmLoaderCallback implements LoaderManager.LoaderCallbacks<List<Film>> {
        @Override
        public Loader<List<Film>> onCreateLoader(int id, Bundle args) {
            Log.d(TAG, " public Loader<FilmListStorage> onCreateLoader(int id, Bundle args)");
            return new ImdbLoader(FilmsListActivity.this, mFilmListStorage , new FilmParser());
        }

        @Override
        public void onLoadFinished(Loader<List<Film>> loader, List<Film> data) {
            Log.e(TAG, "public void onLoadFinished(Loader<FilmListStorage> loader, FilmListStorage data)");
            mRecyclerViewAdapter.setFilms(data);
            mFilmListStorage.setFilmList(data);
            mLinearLayout.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }

        @Override
        public void onLoaderReset(Loader<List<Film>> data) {
            Log.e(TAG, " public void onLoaderReset(Loader<FilmListStorage> loader)");
        }
    }
}
