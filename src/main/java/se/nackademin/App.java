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
                            System.out.print("Purchase Price: ");
                            String readPrice = sc.nextLine();
                            System.out.print("Pages: ");
                            String readAmountOfPages = sc.nextLine();

                            String addBook = content.registerItem(readTitle, readPrice, readAmountOfPages, "bookList.csv");
                            bookList.add(addBook);

                            System.out.println("Added " + book.capitalizeString(readTitle) + " to library.");
                        }
                        else if (subMenuChoice == 2) {
                            // Do register CD
                            System.out.println(""); // For looks
                            sc.nextLine();

                            System.out.println("## Register a new CD");
                            System.out.print("Album Title: ");
                            String readTitle = sc.nextLine();
                            System.out.print("Purchase Price: ");
                            String readPrice = sc.nextLine();
                            System.out.print("Amount of tracks: ");
                            String readTracks = sc.nextLine();
                            System.out.print("Purchase Year: ");
                            String readYear = sc.nextLine();

                            String addCD = cd.registerCD(readTitle, readPrice, readTracks,readYear, "cdList.csv");
                            cdList.add(addCD);
                        }
                        else if (subMenuChoice == 3 ) {
                            // Do register Movie
                            System.out.println("Register Movie");
                        }
                        Thread.sleep(700);
                        break;
                    case 2:
                        content.getLibraryContent(bookList, cdList, movieList);
                        Thread.sleep(700);
                        break;
                    case 3:
                        book.getTotalBookValue(bookList);
                        cd.getTotalCDValue(cdList);
                        Thread.sleep(700);
                        break;
                    case 0:
                        mainLoop = false;
                    default : 
                        System.out.println("\nInvalid input");
                        Thread.sleep(500);
                        break;
                }
            }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input" + e);
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
        String mainMenu = "\nLibrary Main Menu\n1. Register new item\n2. List library\n3. Check Library Value\n0. Exit\nEnter your menu choice: ";
        return mainMenu;
    }
}


