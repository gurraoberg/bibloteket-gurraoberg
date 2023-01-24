package se.nackademin;

import java.io.IOException;
import java.util.List;

public class Movie extends LibraryContent {
    int playTime;
    String director;

    public Movie(String title, float purchasePrice, int playTime, String director) {
        super(title, purchasePrice);
        this.playTime = playTime;
        this.director = director;
    }

    public Movie() {}

    /* Method to add a movie into the library. */
    public String registerMovie(String title, String purchasePrice, String playTime, String director, String fileName) throws IOException {
        String toAdd = App.capitalizeString(title) + ", " + purchasePrice + ", " + playTime + ", " + App.capitalizeString(director);
        writeToCSV(fileName, toAdd);
        return toAdd;
    }

    /* Method to calculate the total value of all the movies that are in the library.
    /* A movies value depends on if the playtime is longer than 100minutes.
       Then the movie increases 1 sek in price by every minute over 100.
    */
    public float getTotalMovieValue(List<String> list) {
        String[] attributes = null;
        float totalValue = 0;
        if (list.size() > 0) {
            for (String movie : list) {
                attributes = movie.split(", ");
                float price = Float.parseFloat(attributes[1]);
                int playTime = Integer.parseInt(attributes[3]);
                if (playTime > 100) {
                    int addSek = playTime - 100;
                    totalValue += price + addSek;
                }
                else {
                    totalValue += price;
                }

                //totalValue += price;
            }
        }
        return totalValue;
    }
}
