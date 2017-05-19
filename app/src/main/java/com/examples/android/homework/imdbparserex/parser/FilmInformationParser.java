package com.examples.android.homework.imdbparserex.parser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.FilmInformation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by enigm777 on 19.05.2017.
 */

public class FilmInformationParser {
    private static final String TAG = "FilmInformationParser";

    public FilmInformation parseInfo(URL movieInfoUrl){
        FilmInformation filmInformation = new FilmInformation();
        String jsonString = null;

        try {


            HttpURLConnection urlConnection = (HttpURLConnection) movieInfoUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            jsonString = buffer.toString();

        } catch (IOException e) {
            Log.e(TAG,e.getMessage());
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            filmInformation.setMovieTitle(jsonObject.getString("Title"));
            filmInformation.setMovieYear(jsonObject.getString("Year"));
            filmInformation.setMovieActors(jsonObject.getString("Actors"));
            filmInformation.setMovieVotes(jsonObject.getString("imdbVotes"));
            filmInformation.setMoviePlot(jsonObject.getString("Plot"));
            filmInformation.setMovieRating(jsonObject.getString("imdbRating"));
            InputStream movieIconInputStream = null;
            try {
                movieIconInputStream = new URL(jsonObject.getString("Poster")).openConnection().getInputStream();
                filmInformation.setMovieIcon(BitmapFactory.decodeStream(movieIconInputStream));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (movieIconInputStream != null){
                    movieIconInputStream.close();
                }
            }

        } catch (JSONException | IOException jsonException){
            Log.e(TAG,jsonException.getMessage());
        }


        return filmInformation;
    }
}
