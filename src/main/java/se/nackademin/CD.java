package se.nackademin;

import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.lang.Math;

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

    public float getTotalCDValue(List<String> list) {
        String[] attributes = null;
        float totalValue = 0;
        int currentYear = Year.now().getValue();
        if (list.size() > 0) {
            for (String cd : list) {
                attributes = cd.split(", ");
                float price = Float.parseFloat(attributes[1]);
                int year = Integer.parseInt(attributes[3]);
                double cdAge = currentYear - year;
                if (cdAge > 0) {
                    //Should decrease in value by 3% every year.
                    float newValue = (float) (price * Math.pow(0.97f, cdAge));
                    totalValue += newValue;
                }
                else {
                    totalValue += price;
                }
            }
            return totalValue;
        }
        else {
            return 0f;
        }
    }
}
