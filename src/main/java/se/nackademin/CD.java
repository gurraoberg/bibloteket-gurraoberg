package se.nackademin;

import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.lang.Math;

public class CD extends LibraryContent {
    int tracks;
    String artist;

    public CD(String title, float purchasePrice, int tracks, String artist) {
        super(title, purchasePrice);
        this.tracks = tracks;
        this.artist = artist;
    }

    public CD() {}

    /* Method to add a CD into the library. */
    public String registerCD(String title, String purchasePrice, String tracks,String year,String artist, String fileName) throws IOException {
        String toAdd = App.capitalizeString(title) + ", " + purchasePrice + ", " + tracks + ", " + year + ", " + App.capitalizeString(artist);
        writeToCSV(fileName, toAdd);
        return toAdd;
    }

    /* Method to calculate the total value of all the CDs in the library.
     * Value changes depending on how old the CD is.
     * Should decrease 3% in value each year.
     */
    public float getTotalCDValue(List<String> list) {
        String[] attributes = null;
        float totalValue = 0f;
        int currentYear = Year.now().getValue();
        if (list.size() > 0) {
            for (String cd : list) {
                attributes = cd.split(", ");
                float price = Float.parseFloat(attributes[1]);
                int year = Integer.parseInt(attributes[3]);
                double cdAge = currentYear - year;
                if (cdAge > 0) {
                    float newValue = (float) (price * Math.pow(0.97f, cdAge));
                    totalValue += newValue;
                }
                else {
                    totalValue += price;
                }
            }
        }
        return totalValue;
    }
}
