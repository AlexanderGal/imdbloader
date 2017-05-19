package com.examples.android.homework.imdbparserex;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.examples.android.homework.imdbparserex.adapter.RecicerViewAdapter;
import com.examples.android.homework.imdbparserex.entity.FilmsList;
import com.examples.android.homework.imdbparserex.loader.ImdbLoader;
import com.examples.android.homework.imdbparserex.parser.FilmParser;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getCanonicalName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"protected void onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLinearLayout = (LinearLayout) findViewById(R.id.loading_layout);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        getSupportLoaderManager().initLoader(1, null, new FilmLoaderCallback()).forceLoad();
    }

    private class FilmLoaderCallback implements LoaderManager.LoaderCallbacks<FilmsList> {
        private final String TAG = this.getClass().getCanonicalName();

        @Override
        public Loader<FilmsList> onCreateLoader(int id, Bundle args) {
            Log.d(TAG, " public Loader<FilmsList> onCreateLoader(int id, Bundle args)");
            return new ImdbLoader(MainActivity.this, new FilmsList(),new FilmParser());
        }

        @Override
        public void onLoadFinished(Loader<FilmsList> loader, FilmsList data) {
            Log.d(TAG, "public void onLoadFinished(Loader<FilmsList> loader, FilmsList data)");
            mLinearLayout.setVisibility(View.GONE);
            mAdapter = new RecicerViewAdapter(data);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setVisibility(View.VISIBLE);
            Log.e(TAG, "onLoadFinished");
        }

        @Override
        public void onLoaderReset(Loader<FilmsList> loader) {
            Log.d(TAG, " public void onLoaderReset(Loader<FilmsList> loader)");
            mRecyclerView.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
            Log.d(TAG, "onLoaderReset");
        }
    }
}
