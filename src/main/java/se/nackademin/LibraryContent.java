package se.nackademin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LibraryContent implements LibraryContentInterface {
    private String title;
    private float purchasePrice;
    private float totalValue;

    public LibraryContent(String title, float purchasePrice) {
        this.title = title;
        this.purchasePrice = purchasePrice;
    }

    public LibraryContent() {}

    public LibraryContent(float totalValue) {
        this.totalValue = totalValue;
    }

    /* Calculates the total value of the whole library. */
    @Override
    public float getTotalValue(List<String> bookList, List<String> cdList, List<String> movieList) {
        Movie movie = new Movie();
        float movieValue = movie.getTotalMovieValue(movieList);
        Book book = new Book();
        float bookValue = book.getTotalBookValue(bookList);
        CD cd = new CD();
        float cdValue = cd.getTotalCDValue(cdList);
        this.totalValue = movieValue + bookValue + cdValue;
        return this.totalValue;
    }

    /* Prints the library content to the user if there is any. */
    @Override
    public void getLibraryContent(List<String> bookList, List<String> cdList, List<String> movieList) {
        getBookContent(bookList);
        getCDContent(cdList);
        getMovieContent(movieList);
    }

    private void getBookContent(List<String> list) {
        System.out.println("--------------------------Books---------------------------");
        System.out.println("Title | Purchase Price(sek) | Pages | Author");
        System.out.println("----------------------------------------------------------");
        if (list.size() > 0) {
            for (String book : list) {
                System.out.println(book);
            }
        }
        else {
            System.out.println("No data");
        }
    }

    private void getCDContent(List<String> list) {
        System.out.println("----------------------------CD----------------------------");
        System.out.println("Title | Purchase Price(sek) | Track Amount | Year | Artist");
        System.out.println("----------------------------------------------------------");
        if (list.size() > 0) {
            for (int i = 0; i < list.size();i++) {
                System.out.println(list.get(i));
            }
        }
        else {
            System.out.println("No data");
        }
    }

    private void getMovieContent(List<String> list) {
        System.out.println("--------------------------Movies--------------------------");
        System.out.println("Title | Purchase Price(sek) | Director | Playtime(min)");
        System.out.println("----------------------------------------------------------");
        if (list.size() > 0) {
            for (int i = 0; i < list.size();i++) {
                System.out.println(list.get(i));
            }
        }
        else {
            System.out.println("No data");
        }
        System.out.println("----------------------------------------------------------");
    }

    /* Saves the added data to a csv file. */
    @Override
    public void writeToCSV(String fileName, String toAdd) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(toAdd);
        writer.write("\n");
        writer.close();
    }

    /* Reads the saved data from a csv and loads it into lists if the csv file is created. */
    @Override
    public void readFromCSV(String fileName, List<String> list) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            String[] attributes = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
                for (String x : list) {
                    attributes = x.split(", ");
                    float price = Float.parseFloat(attributes[1]);
                    this.totalValue += price;
            }
        }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    /* Search method for the whole library.
     * Can search by any title that contains the input letters.
     * Sorts by alphabetical order if there are more than one displayed.
     */
    public void getTitleFromLibrary(List<String> bookList, List<String> cdList, List<String> movieList, String input) {
        List<String> libraryList = new ArrayList<String>();
        libraryList.addAll(bookList);
        libraryList.addAll(movieList);
        libraryList.addAll(cdList);
        Collections.sort(libraryList);
        String[] attributes = null;
        if (libraryList.size() > 0) {
            for (String library : libraryList) {
                attributes = library.split(", ");
                String title = attributes[0];
                if (title.contains(input)) {
                    System.out.println(Arrays.toString(attributes));
                }
            }
        }
    }

    public String getTitle() {
        return this.title;
    }

    public float getPurchasePrice() {
        return this.purchasePrice;
    }
}
