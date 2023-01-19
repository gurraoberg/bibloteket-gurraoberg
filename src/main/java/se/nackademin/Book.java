package se.nackademin;

public class Book extends LibraryContent {

    public Book(String title, float purchasePrice, int pages) {
        super(title, purchasePrice);
    }

    public Book() {}

    public String capitalizeString(String toCapitalize) {
        String newString = toCapitalize.substring(0,1).toUpperCase() + toCapitalize.substring(1);
        return newString;
    }


}
