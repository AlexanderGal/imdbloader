package com.examples.android.homework.imdbparserex.parser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.examples.android.homework.imdbparserex.entity.Film;
import com.examples.android.homework.imdbparserex.entity.FilmInformation;
import com.examples.android.homework.imdbparserex.storage.FilmListStorage;

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

    public void parse(FilmListStorage result) {
        try {
            Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
            Element element = document.getElementsByAttributeValue("data-caller-name", "chart-top250movie").get(0);
            Elements rowElem = element.getElementsByTag("tr");
            rowElem.remove(0);
            InputStream is = null;
            Bitmap icon = null;
            for (Element elem : rowElem) {
                // load 250 taking too much time
                if (rowElem.indexOf(elem) >= 10) return;
                String mTitle = elem.select(".titleColumn > a").text();
                String mDate = elem.select("span.secondaryInfo").text();
                String mRating = elem.select("td.ratingColumn > strong").text();
                String mFilmId = elem.select("div.wlb_ribbon").first().attr("data-tconst");
                String mFilmUrl = elem.select("a").first().attr("href");

                try {
                    is = new URL(elem.select("img").first().absUrl("src")).openConnection().getInputStream();
                    icon = BitmapFactory.decodeStream(is);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }
                Log.e(TAG, mTitle + " " + icon + " " + mDate + " " + mRating + " " + mFilmId + " " + mFilmUrl);
                result.fillList(new Film(icon, mTitle, mDate, mRating, mFilmId, mFilmUrl));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FilmInformation parseFilmInfo(String mFilmUrl) {
        FilmInformation filmInformation = new FilmInformation();
        InputStream is = null;
        Bitmap icon;
        Document document;

        try {
            document = Jsoup.connect(mFilmUrl).get();
            filmInformation.setTitle(document.getElementsByAttributeValue("itemprop", "name").first().text());
            filmInformation.setYear(document.getElementById("titleYear").text());
            filmInformation.setActors(document.getElementById("titleStoryLine").text());
            filmInformation.setVotes(document.getElementsByAttributeValue("itemprop", "ratingCount").first().text());
            filmInformation.setPlot(document.getElementsByAttributeValue("itemprop", "description").first().text());
            filmInformation.setRating(document.getElementsByAttributeValue("itemprop", "ratingValue").first().text());

            try {
                is = new URL(document.select("div.poster").first().select("img").first().absUrl("src")).openConnection().getInputStream();
                icon = BitmapFactory.decodeStream(is);
                filmInformation.setIcon(icon);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmInformation;
    }
}
