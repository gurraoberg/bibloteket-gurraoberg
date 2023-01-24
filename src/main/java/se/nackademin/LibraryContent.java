package se.nackademin;

import java.io.*;
import java.util.List;

public class LibraryContent implements LibraryContentInterface {
    private String title;
    private float purchasePrice;

    public LibraryContent(String title, float purchasePrice) {
        this.title = title;
        this.purchasePrice = purchasePrice;
    }

    public LibraryContent() {}

    public float getTotalValue(List<String> bookList, List<String> cdList, List<String> movieList) {
        Movie movie = new Movie();
        float movieValue = movie.getTotalMovieValue(movieList);
        Book book = new Book();
        float bookValue = book.getTotalBookValue(bookList);
        CD cd = new CD();
        float cdValue = cd.getTotalCDValue(cdList);
        return movieValue + bookValue + cdValue;
    }

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

    @Override
    public void writeToCSV(String fileName, String toAdd) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(toAdd);
        writer.write("\n");
        writer.close();
    }

    @Override
    public void readFromCSV(String fileName, List<String> list) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
