package se.nackademin;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class BookTest {
    
    @Test
    public void shouldCreateNewBook() throws IOException {
        Book newBook = new Book().createBook("title", 0, 0, "author");
        String title = newBook.getTitle();
        float purchasePrice = newBook.getPurchasePrice();
        String author = newBook.getAuthor();
        int pages = newBook.getPages();
        String toCompare = title + ", " +  purchasePrice + ", " +  pages + ", " + author;
        assertEquals(newBook.toString(), toCompare);
    }
}
