package com.examples.android.homework.imdbparserex.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.android.homework.imdbparserex.R;
import com.examples.android.homework.imdbparserex.entity.FilmInformation;
import com.examples.android.homework.imdbparserex.loader.FilmInformationLoader;
import com.examples.android.homework.imdbparserex.parser.FilmParser;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformationActivity extends AppCompatActivity {
    private static final String TAG = FilmInformationActivity.class.getCanonicalName();
    private static final int FILM_INFORMATION_LOADER_ID = 777;

    private TextView mMovieTitleTextView;
    private ImageView mMovieIconImageView;
//    private TextView mMovieYearTextView;
//    private TextView mMovieRatingTextView;
//    private TextView mMovieVotesTextView;
    private TextView mMovieActorsTextView;
    private TextView mMoviePlotTextView;

    private String mFilmInformationUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_information);

        mMovieTitleTextView = (TextView) findViewById(R.id.movie_title_textview);
        mMovieIconImageView = (ImageView) findViewById(R.id.movie_icon_imageview);
//        mMovieYearTextView = (TextView) findViewById(R.id.movie_year_textview);
//        mMovieRatingTextView = (TextView) findViewById(R.id.imdb_rating_textview);
//        mMovieVotesTextView = (TextView) findViewById(R.id.imdb_votes_textview);
        mMovieActorsTextView = (TextView) findViewById(R.id.movie_actors_textview);
        mMoviePlotTextView = (TextView) findViewById(R.id.movie_plot_textview);
        mFilmInformationUrl = getIntent().getStringExtra("filmURL");


        getSupportLoaderManager().initLoader(FILM_INFORMATION_LOADER_ID, null, new FilmInformationLoaderCallbacks()).forceLoad();
    }

    private class FilmInformationLoaderCallbacks implements LoaderManager.LoaderCallbacks<FilmInformation> {

        @Override
        public Loader<FilmInformation> onCreateLoader(int id, Bundle args) {
            return new FilmInformationLoader(FilmInformationActivity.this, mFilmInformationUrl, new FilmParser());
        }

        @Override
        public void onLoadFinished(Loader<FilmInformation> loader, FilmInformation data) {
            mMovieTitleTextView.setText(data.getTitle());
            mMoviePlotTextView.setText(data.getPlot());
            mMovieActorsTextView.setText(data.getActors());
//            mMovieRatingTextView.setText(data.getRating());
//            mMovieVotesTextView.setText(data.getVotes());
//            mMovieYearTextView.setText(data.getYear());
            mMovieIconImageView.setImageBitmap(data.getIcon());

            Log.d(TAG, "onLoadFinished");
        }

        @Override
        public void onLoaderReset(Loader<FilmInformation> loader) {
        }
    }
}
