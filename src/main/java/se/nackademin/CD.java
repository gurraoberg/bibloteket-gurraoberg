package se.nackademin;

import java.io.IOException;
import java.util.List;

public class CD extends LibraryContent {
    
    public CD(String title, float purchasePrice, int tracks) {
        super(title, purchasePrice);
    }

    public CD() {}

    public String registerCD(String title, String purchasePrice, String tracks,String year, String fileName) throws IOException {
        Book book = new Book();
        String toAdd = book.capitalizeString(title) + ", " + purchasePrice + ", " + tracks + ", " + year;
        writeToCSV(fileName, toAdd);
        return toAdd;
    }

    public void getTotalCDValue(List<String> list) {
        String[] attributes = null;
        float totalValue = 0;
        if (list.size() > 0) {
            for (String cd : list) {
                attributes = cd.split(", ");
                float price = Float.parseFloat(attributes[1]);

                totalValue += price;
            }
            System.out.println("Total value of all our CDs is " + totalValue + "sek");
        }
        else {
            System.out.println("No data");
        }
    }
}
