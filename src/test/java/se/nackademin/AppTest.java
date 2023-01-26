package se.nackademin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest 
{

    @Test
    public void shouldCreateBookList() {
        assertTrue(App.bookList.size() > 0);
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

    @Test
    public void shouldTestListsEmpty() {
        int listBook = App.bookList.size();
        int listCD = App.cdList.size();
        int listMovie = App.movieList.size();
        assertTrue(listBook < 1);
        assertTrue(listCD < 1);
        assertTrue(listMovie < 1);
    }

    @Test
    public void shouldAddSavedInfoToList() throws IOException {
        LibraryContent content = new LibraryContent();
        content.writeToCSV("test.csv", "test, 100");
        content.readFromCSV("test.csv", App.bookList);
        int listSize = App.bookList.size();
        assertTrue(listSize > 0);
    }
}
