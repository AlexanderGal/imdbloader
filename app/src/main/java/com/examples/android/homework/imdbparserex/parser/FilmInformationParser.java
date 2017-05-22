package com.examples.android.homework.imdbparserex.parser;

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
    private static final String TAG = FilmInformationParser.class.getCanonicalName();

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
            filmInformation.setTitle(jsonObject.getString("Title"));
            filmInformation.setYear(jsonObject.getString("Year"));
            filmInformation.setActors(jsonObject.getString("Actors"));
            filmInformation.setVotes(jsonObject.getString("imdbVotes"));
            filmInformation.setPlot(jsonObject.getString("Plot"));
            filmInformation.setRating(jsonObject.getString("imdbRating"));
            InputStream movieIconInputStream = null;
            try {
                movieIconInputStream = new URL(jsonObject.getString("Poster")).openConnection().getInputStream();
                filmInformation.setIcon(BitmapFactory.decodeStream(movieIconInputStream));
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
