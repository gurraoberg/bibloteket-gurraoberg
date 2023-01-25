package se.nackademin;

import static org.junit.Assert.assertFalse;
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
        content.writeToCSV("test.csv", "test");
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
        content.readFromCSV("bookList.csv", App.bookList);
        content.readFromCSV("cdList.csv", App.cdList);
        content.readFromCSV("movieList.csv", App.movieList);
        float value = content.getTotalValue(App.bookList, App.cdList, App.movieList);
        assertTrue(value > 0);
    }

    @Test
    public void shouldGet0Value() {
        LibraryContent content = new LibraryContent();
        float value = content.getTotalValue(App.bookList, App.cdList, App.movieList);
        assertFalse(value > 0);
    }
}
