package se.nackademin;

import java.io.IOException;

public class Book extends LibraryContent {

    public Book(String title, float purchasePrice, int pages) {
        super(title, purchasePrice);
    }

    public Book() {}

    public String registerBook(String title, String purchasePrice, String pages) throws IOException {
        LibraryContent content = new LibraryContent();
        String toAdd = capitalizeString(title) + ", " + purchasePrice + ", " + pages;
        content.writeToCSV("bookList.csv", toAdd);
        return toAdd;
    }

    public String capitalizeString(String toCapitalize) {
        String newString = toCapitalize.substring(0,1).toUpperCase() + toCapitalize.substring(1);
        return newString;
    }


}
