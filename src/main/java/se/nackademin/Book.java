package se.nackademin;

import java.io.IOException;
import java.util.List;

public class Book extends LibraryContent {
    int pages;
    String author;
    float totalValue;

    public Book(String title, float purchasePrice, int pages, String author) {
        super(title, purchasePrice);
        this.pages = pages;
        this.author = author;
    } 

    public Book() {}

    /* Creates a new book.
     * Saves the book into a CSV file.
     */
    public Book createBook(String title, float purchasePrice, int pages, String author) throws IOException {
        Book newBook = new Book(title, purchasePrice, pages, author);
        writeToCSV("bookList.csv", newBook.toString());
        totalValue += purchasePrice;
        return newBook;
    }

    @Override
    public String toString() {
      return this.getTitle() + ", " + this.getPurchasePrice() + ", " + this.getPages() + ", " + this.getAuthor();
    }

    /* Method to calculate the total value of all the books that are in the library.
    /* A book always has the same value.
    */
    public float getTotalBookValue(List<String> list) {
        totalValue = 0f;
        String[] attributes = null;
        if (list.size() > 0) {
            for (String book : list) {
                attributes = book.split(", ");
                float price = Float.parseFloat(attributes[1]);

                totalValue += price;
            }
        }
        return totalValue;
    }

    public int getPages() {
        return this.pages;
    }

    public String getAuthor() {
        return this.author;
    }

}
