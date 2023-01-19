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

    public void getLibraryContent(List<String> bookList, List<String> cdList, List<String> movieList) {
        getBookContent(bookList);
        getCDContent(cdList);
        getMovieContent(movieList);
    }

    private void getBookContent(List<String> list) {
        System.out.println("-------------------Book-------------------");
        System.out.println("Title | Purchase Price(sek) | Pages");
        System.out.println("------------------------------------------");
        if (list.size() > 0) {
            for (int i = 0; i < list.size();i++) {
                System.out.println(list.get(i));
            }
        }
        else {
            System.out.println("No data");
        }
    }

    private void getCDContent(List<String> list) {
        System.out.println("--------------------CD--------------------");
        System.out.println("Title | Purchase Price(sek) | Track Amount");
        System.out.println("------------------------------------------");
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
        System.out.println("------------------Movies------------------");
        System.out.println("Title | Purchase Price(sek) | Playtime");
        System.out.println("------------------------------------------");
        if (list.size() > 0) {
            for (int i = 0; i < list.size();i++) {
                System.out.println(list.get(i));
            }
        }
        else {
            System.out.println("No data");
        }
        System.out.println("------------------------------------------");
    }

    @Override
    public void writeToCSV(String fileName, String toAdd) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(toAdd);
        writer.write("\n");
        writer.close();
    }

    @Override
    public void readFromCSV(String fileName, List<String> bookList) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                bookList.add(line);
            }
        } catch (FileNotFoundException e) {
            //System.out.println("File Not Found");
        }
    }

    public String registerItem(String title, String purchasePrice, String uniqueStat, String fileName) throws IOException {
        Book book = new Book();
        String toAdd = book.capitalizeString(title) + ", " + purchasePrice + ", " + uniqueStat;
        writeToCSV(fileName, toAdd);
        return toAdd;
    }
}
