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

        content.readFromCSV("bookList.csv", bookList);
        content.readFromCSV("cdList.csv", cdList);
        content.readFromCSV("movieList.csv", movieList);

        Scanner sc = new Scanner(System.in);
        boolean mainLoop = true;

        int choice;
        while(mainLoop){
            System.out.println("\nLibrary Main Menu\n");
            System.out.print("1. Register new item\n");
            System.out.print("2. List library\n");
            System.out.print("3. Download library content\n");
            System.out.print("0. Exit");
            System.out.print("\nEnter Your Menu Choice: ");

            try {
                choice = sc.nextInt();

                switch(choice){
                    case 1:
                        System.out.println(""); // For looks
                        sc.nextLine();

                        System.out.println("## Register a new book");
                        System.out.print("Book Title: ");
                        String readTitle = sc.nextLine();
                        System.out.print("Purchase Price: ");
                        String readPrice = sc.nextLine();
                        System.out.print("Pages: ");
                        String readAmountOfPages = sc.nextLine();

                        String toAdd = book.registerBook(readTitle, readPrice, readAmountOfPages);
                        bookList.add(toAdd);

                        System.out.println("Added " + book.capitalizeString(readTitle) + " to library.");
                        Thread.sleep(700);
                        break;
                    case 2:
                        content.getLibraryContent(bookList, cdList, movieList);
                        Thread.sleep(700);
                        break;
                    case 3:
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
}


