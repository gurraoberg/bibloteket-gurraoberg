package se.nackademin;

import java.io.IOException;
import java.util.List;

public class Book extends LibraryContent {
    int pages;
    String author;

    public Book(String title, float purchasePrice, int pages, String author) {
        super(title, purchasePrice);
        this.pages = pages;
        this.author = author;
    } 

    public Book() {}

    /* Method to add a book into the library. */
    public String registerBook(String title, String purchasePrice, String pages,String author, String fileName) throws IOException {
        String toAdd = App.capitalizeString(title) + ", " + purchasePrice + ", " + pages + ", " + App.capitalizeString(author);
        writeToCSV(fileName, toAdd);
        return toAdd;
    }

    /* Method to calculate the total value of all the books that are in the library.
    /* A book always has the same value.
    */
    public float getTotalBookValue(List<String> list) {
        String[] attributes = null;
        float totalValue = 0;
        if (list.size() > 0) {
            for (String book : list) {
                attributes = book.split(", ");
                float price = Float.parseFloat(attributes[1]);

                totalValue += price;
            }
        }
        return totalValue;
    }

}
