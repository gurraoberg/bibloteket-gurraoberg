package se.nackademin;

import java.util.List;

public class Book extends LibraryContent {

    public Book(String title, float purchasePrice, int pages) {
        super(title, purchasePrice);
    } 

    public Book() {}

    public String capitalizeString(String toCapitalize) {
        String newString = toCapitalize.substring(0,1).toUpperCase() + toCapitalize.substring(1);
        return newString;
    }

    public float getTotalBookValue(List<String> list) {
        String[] attributes = null;
        float totalValue = 0;
        if (list.size() > 0) {
            for (String book : list) {
                attributes = book.split(", ");
                float price = Float.parseFloat(attributes[1]);

                totalValue += price;
            }
            return totalValue;
        }
        else {
            return 0f;
        }
    }

}
