package se.nackademin;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.Year;
import org.junit.Test;

public class CDTest {
    
    @Test
    public void shouldCreateNewCD() throws IOException {
        CD newCD = new CD().createCD("title", 0, 0, 0, "artist");
        String title = newCD.getTitle();
        float purchasePrice = newCD.getPurchasePrice();
        String artist = newCD.getArtist();
        int tracks = newCD.getTracks();
        int year = newCD.getYear();
        String toCompare = title + ", " +  purchasePrice + ", " +  tracks + ", " + year + ", " + artist;
        assertEquals(newCD.toString(), toCompare);
    }

    @Test
    public void shouldTestElseConditionOnTotalValue() throws IOException {
        //CD cd = new CD().createCD("title", 900, 0, 2023, "artist");
        CD cd = new CD();
        cd.readFromCSV("cdList.csv", App.cdList);
        float value = cd.getTotalCDValue(App.cdList);
        int currentYear = Year.now().getValue();
        double cdAge = currentYear - cd.year;
        float cdValue = cd.getTotalValue();
        if (cdAge > 0) {
            assertEquals(value, cdValue, 0);
        }
    }
}
