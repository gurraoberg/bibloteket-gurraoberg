package se.nackademin;

import java.io.IOException;
import java.util.List;

public class Movie extends LibraryContent {
    int playTime;
    String director;
    float totalMovieValue = 0f;

    public Movie(String title, float purchasePrice, int playTime, String director) {
        super(title, purchasePrice);
        this.playTime = playTime;
        this.director = director;
    }

    public Movie() {}

    public Movie(float totalMovieValue) {
        this.totalMovieValue = totalMovieValue;
    }

    /* Creates a new movie.
     * And saves it to a CSV file.
     */
    public Movie createMovie(String title, float purchasePrice, int playTime, String director) throws IOException {
        Movie newMovie = new Movie(title, purchasePrice, playTime, director);
        writeToCSV("movieList.csv", newMovie.toString());
        this.totalMovieValue += purchasePrice;
        return newMovie;
    }

    @Override
    public String toString() {
      return this.getTitle() + ", " + this.getPurchasePrice() + ", " + this.getPlayTime() + ", " + this.getDirector();
    }

    /* Method to calculate the total value of all the movies that are in the library.
    /* A movies value depends on if the playtime is longer than 100minutes.
       Then the movie increases 1 sek in price by every minute over 100.
    */
    public float getTotalMovieValue(List<String> list) {
        this.totalMovieValue = 0f;
        String[] attributes = null;
        if (list.size() > 0) {
            for (String movie : list) {
                attributes = movie.split(", ");
                float price = Float.parseFloat(attributes[1]);
                this.playTime = Integer.parseInt(attributes[2]);
                if (this.playTime > 100) {
                    int addSek = playTime - 100;
                    float toAdd = price + addSek;
                    this.totalMovieValue += toAdd;
                }
                else {
                    this.totalMovieValue += price;
                }
            }
    }
    return this.totalMovieValue;
    }

    public String getDirector() {
        return this.director;
    }

    public int getPlayTime() {
        return this.playTime;
    }
}
