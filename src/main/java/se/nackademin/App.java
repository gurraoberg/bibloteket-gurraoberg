package se.nackademin;

import java.util.Scanner;

import java.util.InputMismatchException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    final static List<String> bookList = new ArrayList<String>();
    final static List<String> cdList = new ArrayList<String>();
    final static List<String> movieList = new ArrayList<String>();

    public static void main( String[] args ) throws InterruptedException, IOException, SQLException
    {

        LibraryContent content = new LibraryContent();
        Book book = new Book();
        CD cd = new CD();
        Movie movie = new Movie();

        content.readFromCSV("bookList.csv", bookList);
        content.readFromCSV("cdList.csv", cdList);
        content.readFromCSV("movieList.csv", movieList);

        Scanner sc = new Scanner(System.in);
        boolean mainLoop = true;

        int choice;
        while(mainLoop){
            System.out.println(mainMenu());
            System.out.print("\nEnter your menu choice: ");

            try {
                choice = sc.nextInt();

                switch(choice){
                    case 1:
                        System.out.println(addItemMenu());
                        System.out.print("Enter your choice: ");
                        int subMenuChoice = sc.nextInt();
                        if (subMenuChoice == 1) {
                            System.out.println(""); // For looks
                            sc.nextLine();

                            System.out.println("## Register a new book");
                            System.out.print("Book Title: ");
                            String readTitle = sc.nextLine();
                            System.out.print("Author: ");
                            String readAuthor = sc.nextLine();
                            System.out.print("Purchase Price(sek): ");
                            String readPrice = sc.nextLine();
                            System.out.print("Pages: ");
                            String readAmountOfPages = sc.nextLine();

                            String addBook = book.registerBook(readTitle, readPrice, readAmountOfPages, readAuthor, "bookList.csv");
                            bookList.add(addBook);

                            System.out.println("Added " + capitalizeString(readTitle) + " to library.");
                        }
                        else if (subMenuChoice == 2) {
                            // Do register CD
                            System.out.println(""); // For looks
                            sc.nextLine();

                            System.out.println("## Register a new CD");
                            System.out.print("Album Title: ");
                            String readTitle = sc.nextLine();
                            System.out.print("Artist: ");
                            String readArtist = sc.nextLine();
                            System.out.print("Purchase Price(sek): ");
                            String readPrice = sc.nextLine();
                            System.out.print("Amount of tracks: ");
                            String readTracks = sc.nextLine();
                            System.out.print("Purchase Year: ");
                            String readYear = sc.nextLine();

                            String addCD = cd.registerCD(readTitle, readPrice, readTracks,readYear,readArtist, "cdList.csv");
                            cdList.add(addCD);
                        }
                        else if (subMenuChoice == 3 ) {
                            // Do register Movie
                            System.out.println(""); // For looks
                            sc.nextLine();
                            System.out.println("## Register a new Movie");
                            System.out.print("Movie Title: ");
                            String readTitle = sc.nextLine();
                            System.out.print("Director: ");
                            String readDirector = sc.nextLine();
                            System.out.print("Purchase Price(sek): ");
                            String readPrice = sc.nextLine();
                            System.out.print("Playtime(min): ");
                            String readPlayTime= sc.nextLine();

                            String addMovie = movie.registerMovie(readTitle, readPrice, readDirector, readPlayTime, "movieList.csv");
                            movieList.add(addMovie);
                        }
                        Thread.sleep(700);
                        break;
                    case 2:
                        content.getLibraryContent(bookList, cdList, movieList);
                        Thread.sleep(700);
                        break;
                    case 3:
                        float totalBookValue = book.getTotalBookValue(bookList);
                        float totalCDValue = cd.getTotalCDValue(cdList);
                        float totalMovieValue = movie.getTotalMovieValue(movieList);
                        float libraryValue = content.getTotalValue(bookList, cdList, movieList);

                        if (totalBookValue > 0) {
                            System.out.println("");
                            System.out.println("Total value of all our books is " + totalBookValue + "sek.");
                        }
                        if (totalCDValue > 0) {
                            System.out.println("");
                            System.out.println("CDs decrease 3% in value each year.");
                            System.out.println("Total value of all our CDs is " + totalCDValue + "sek.");
                        }
                        if (totalMovieValue > 0) {
                            System.out.println("");
                            System.out.println("A movies value increases if the playtime is greater than 100minutes.");
                            System.out.println("Total value of all our movies is " + totalMovieValue + "sek.");
                        }
                        if (libraryValue >= 0) {
                            System.out.println("");
                            System.out.println("Total value of the whole library is " + libraryValue + "sek.");
                        }
                        else {
                            System.out.println("No Data");
                        }

                        Thread.sleep(700);
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.print("Item Title: ");
                        String readTitle = sc.nextLine();
                        content.getTitleFromLibrary(bookList, cdList, movieList, capitalizeString(readTitle));
                        break;
                    default :
                        System.out.println("\nInvalid input");
                        Thread.sleep(500);
                        break;
                    case 0:
                        mainLoop = false;
                }
            }
                catch (InputMismatchException e) {
                    System.out.println("Only numbers allowed " + e);
                    break;
            }
        }
        sc.close();
    }

    private static String addItemMenu () {
        String itemMenu = "1. Register Book\n2. Register CD\n3. Register Movie";
        return itemMenu;
    }

    private static String mainMenu() {
        String mainMenu = "\nLibrary Main Menu\n1. Register new item\n2. List library\n3. Check Library Value\n4. Search\n0. Exit\nEnter your menu choice: ";
        return mainMenu;
    }

    /* This method capitalizes a string. */
    public static String capitalizeString(String toCapitalize) {
        String newString = toCapitalize.substring(0,1).toUpperCase() + toCapitalize.substring(1);
        return newString;
    }
}


