package se.nackademin;

import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.lang.Math;

public class CD extends LibraryContent {
    int tracks;
    String artist;
    int year;
    float totalCDValue;

    public CD(String title, float purchasePrice, int tracks, int year, String artist) {
        super(title, purchasePrice);
        this.tracks = tracks;
        this.artist = artist;
        this.year = year;
    }

    public CD() {}

    /* Creates a new CD.
     * Saves the CD into a CSV file.
     */
    public CD createCD(String title, float purchasePrice, int tracks, int year, String artist) throws IOException {
        CD newCD = new CD(title, purchasePrice, tracks, year, artist);
        writeToCSV("cdList.csv", newCD.toString());
        totalCDValue += purchasePrice;
        return newCD;
    }

    @Override
    public String toString() {
      return this.getTitle() + ", " + this.getPurchasePrice() + ", " + this.getTracks() + ", " + this.getYear() + ", " + this.getArtist();
    }

    /* Method to calculate the total value of all the CDs in the library.
     * Value changes depending on how old the CD is.
     * Should decrease 3% in value each year.
     */
    public float getTotalCDValue(List<String> list) {
        totalCDValue = 0f;
        String[] attributes = null;
        int currentYear = Year.now().getValue();
        if (list.size() > 0) {
            for (String cd : list) {
                attributes = cd.split(", ");
                float price = Float.parseFloat(attributes[1]);
                int year = Integer.parseInt(attributes[3]);
                double cdAge = currentYear - year;
                if (cdAge > 0) {
                    float newValue = (float) (price * Math.pow(0.97f, cdAge));
                    totalCDValue += newValue;
                }
                else {
                    totalCDValue += price;
                }
            }
        }
        return totalCDValue;
    }

    public int getTracks() {
        return this.tracks;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getYear() {
        return this.year;
    }

    public float getTotalValue() {
        return totalCDValue;
    }
}
