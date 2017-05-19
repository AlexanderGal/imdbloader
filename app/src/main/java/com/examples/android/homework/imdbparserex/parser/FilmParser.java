package com.examples.android.homework.imdbparserex.parser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.entity.FilmsList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by ASGalochkin on 19.05.2017.
 */

public class FilmParser {
    private final String TAG = this.getClass().getCanonicalName();
    private String title;
    private Bitmap icon;
    private String date;
    private String rating;
    private String filmId;
    private String filmPath;

    public void parse(FilmsList result) {
        try {
            Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
            Element element = document.getElementsByAttributeValue("data-caller-name", "chart-top250movie").get(0);
            Elements rowElem = element.getElementsByTag("tr");
            InputStream is = null;
            int i = 0;
            for (Element elem : rowElem) {

                if (elem == rowElem.get(0)) {
                    continue;
                }

                // load 250 taking too much time
               if(rowElem.indexOf(elem)>=20)return;
                title = elem.select(".titleColumn > a").text();
                date = elem.select("span.secondaryInfo").text();
                rating = elem.select("td.ratingColumn > strong").text();
                String iconURL = elem.select("img").first().absUrl("src");

                try {
                    is = new URL(iconURL).openConnection().getInputStream();
                    icon = BitmapFactory.decodeStream(is);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null){
                        is.close();
                    }
                }

                Log.d(TAG, title + " " + icon + " " + date + " " + rating);
                result.addFilm(new Film(icon,title,date,rating,filmId));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
