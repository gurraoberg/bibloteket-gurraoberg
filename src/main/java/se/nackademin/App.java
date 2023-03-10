package se.nackademin;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    final static List<String> bookList = new ArrayList<String>();
    final static List<String> cdList = new ArrayList<String>();
    final static List<String> movieList = new ArrayList<String>();

    public static void main( String[] args ) throws InterruptedException, IOException
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
                            float readPrice = sc.nextFloat();
                            System.out.print("Pages: ");
                            int readAmountOfPages = sc.nextInt();

                            Book newBook = book.createBook(readTitle, readPrice, readAmountOfPages, readAuthor);
                            bookList.add(newBook.toString());
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
                            float readPrice = sc.nextFloat();
                            System.out.print("Amount of tracks: ");
                            int readTracks = sc.nextInt();
                            System.out.print("Purchase Year: ");
                            int readYear = sc.nextInt();

                            CD newCD = cd.createCD(readTitle, readPrice, readTracks, readYear, readArtist);
                            cdList.add(newCD.toString());
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
                            float readPrice = sc.nextFloat();
                            System.out.print("Playtime(min): ");
                            int readPlayTime= sc.nextInt();

                            Movie newMovie = movie.createMovie(readTitle, readPrice, readPlayTime, readDirector);
                            movieList.add(newMovie.toString());
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
                        content.getTitleFromLibrary(bookList, cdList, movieList, readTitle);
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
}


