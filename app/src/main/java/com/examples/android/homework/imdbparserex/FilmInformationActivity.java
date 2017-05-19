package com.examples.android.homework.imdbparserex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.examples.android.homework.imdbparserex.entity.FilmInformation;
import com.examples.android.homework.imdbparserex.loader.FilmInformationLoader;
import com.examples.android.homework.imdbparserex.parser.FilmInformationParser;

import java.io.IOException;
import java.net.URL;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformationActivity extends AppCompatActivity {

    private static final String TAG = "FilmInformationActivity";
    private static final int FILM_INFORMATION_LOADER_ID = 777;

    private TextView mMovieTitle;
    private ImageView mMovieIcon;
    private TextView mMovieYear;
    private TextView mMovieRating;
    private TextView mMovieVotes;
    private TextView mMovieActors;
    private TextView mMoviePlot;

    private ProgressBar mProgressBar;

    private URL mFilmInformationUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_information);

        mMovieTitle = (TextView) findViewById(R.id.movie_title);
        mMovieIcon = (ImageView) findViewById(R.id.movie_icon);
        mMovieYear = (TextView)findViewById(R.id.movie_year);
        mMovieRating = (TextView)findViewById(R.id.imdb_rating);
        mMovieVotes = (TextView)findViewById(R.id.imdb_votes);
        mMovieActors = (TextView)findViewById(R.id.movie_actors);
        mMoviePlot = (TextView)findViewById(R.id.movie_plot);

        mProgressBar = (ProgressBar)findViewById(R.id.movie_info_loading);
        String movieTitle = getIntent().getStringExtra("movieTitle");
        try {
            mFilmInformationUrl = new URL("http://www.omdbapi.com/?t="+getIntent().getStringExtra("movieTitle")+"&plot=full");
        } catch(IOException ex){
            Log.e(TAG,ex.getMessage());
        }

        getSupportLoaderManager().initLoader(FILM_INFORMATION_LOADER_ID,null,new FilmInformationLoaderCallbacks()).forceLoad();


    }

    private class FilmInformationLoaderCallbacks implements LoaderManager.LoaderCallbacks<FilmInformation>{

        @Override
        public Loader<FilmInformation> onCreateLoader(int id, Bundle args) {
            return new FilmInformationLoader(FilmInformationActivity.this,mFilmInformationUrl,new FilmInformationParser());
        }

        @Override
        public void onLoadFinished(Loader<FilmInformation> loader, FilmInformation data) {
            mProgressBar.setVisibility(View.GONE);
            mMovieTitle.setText(data.getMovieTitle());
            mMoviePlot.setText(data.getMoviePlot());
            mMovieActors.setText(data.getMovieActors());
            mMovieRating.setText(data.getMovieRating());
            mMovieVotes.setText(data.getMovieVotes());
            mMovieYear.setText(data.getMovieYear());
            mMovieIcon.setImageBitmap(data.getMovieIcon());

            Log.d(TAG,"onLoadFinished");
        }

        @Override
        public void onLoaderReset(Loader<FilmInformation> loader) {

        }
    }
}
