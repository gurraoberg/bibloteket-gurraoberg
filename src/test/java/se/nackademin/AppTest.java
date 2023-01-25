package se.nackademin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest 
{
    
    @Test
    public void shouldCreateBookList() {
        final List<String> bookList = new ArrayList<String>();
        assertEquals(bookList, App.bookList);
    }

    @Test
    public void shouldCreateCDList() {
        final List<String> cdList = new ArrayList<String>();
        assertEquals(cdList, App.cdList);
    }

    @Test
    public void shouldCreateMovieList() {
        final List<String> movieList = new ArrayList<String>();
        assertEquals(movieList, App.movieList);
    }
}
