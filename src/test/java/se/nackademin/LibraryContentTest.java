package se.nackademin;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LibraryContentTest {

    @Test
    public void shouldWriteAndReadFromFile() throws IOException {
        LibraryContent content = new LibraryContent();
        List<String> list = new ArrayList<String>();
        content.writeToCSV("test.csv", "test, 100");
        content.readFromCSV("test.csv", list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void shouldCheckIfFileExists() throws IOException {
        File file = new File("test.csv");
        assertTrue(file.exists());
    }

    @Test
    public void shouldGetTotalValue() throws IOException {
        LibraryContent content = new LibraryContent();
        Book book = new Book().createBook("null", 20, 0, "null");
        CD cd = new CD().createCD("null", 15, 0, 0, "null");
        Movie movie = new Movie().createMovie("null", 10, 0, "null");
        book.readFromCSV("bookList.csv", App.bookList);
        cd.readFromCSV("cdList.csv", App.cdList);
        movie.readFromCSV("movieList.csv", App.movieList);
        float value = content.getTotalValue(App.bookList, App.cdList, App.movieList);
        assertTrue(value > 0);
    }
}
