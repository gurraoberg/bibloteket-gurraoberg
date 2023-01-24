package se.nackademin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Test;

public class MovieTest {

    @Test
    public void shouldTestValueNotEqual() {
        Movie movie = new Movie(9000f);
        float value = movie.getTotalMovieValue(App.movieList);
        assertNotEquals(value, 1000f, 0.0f);
    }

    @Test
    public void shouldTestMovieValueIsEqual() {
        Movie movie = new Movie(1200f);
        float value = movie.getTotalMovieValue(App.movieList);
        assertEquals(value, movie.totalMovieValue, 0.0f);
    }

    @Test
    public void shouldRegisterMovie() throws IOException {
        Movie movie = new Movie("Avatar", 199.49f, 135, "James Cameron");
        String title = movie.getTitle();
        float purchasePrice = movie.getPurchasePrice();
        String director = movie.getDirector();
        int playTime = movie.getPlayTime();
        String addMovie = movie.registerMovie("Avatar", "199.49", "135", "James Cameron", "movieList.csv");
        String toCompare = title + ", " +  purchasePrice + ", " +  playTime + ", " + director;
        assertEquals(toCompare, addMovie);
    }
}
