// Lazaro Ramos
// 05/02/2025

import java.io.*;
import java.util.Scanner;

/* Imports java classes for file handling and scanner. */

public class BookInventoryApp2 {

    /* Declares class name. */

    private static final String FILE_NAME = "books.csv";

    /* Sets up constant variable that holds the name of the csv file. */

    private static Scanner input = new Scanner(System.in);

    /* Sets up scanner for user input reading. */

    private static BookStore2 store = new BookStore2();

    /* Sets up variable store for books to be stored and managed. */

    public static void main(String[] args) {

        /* Begins the main method of this class. */

        loadBooksFromFile();

        /* Loads the books from the csv file. */
        
        while (true) {
            
            /* Begins the menu loop.  */

            displayMenu();

            /* Displays menu. */

            String choice = input.nextLine();

            /* Reads the users input. */

            switch (choice) {
                case "1": addBook(); break;
                case "2": findBookByISBN(); break;
                case "3": removeBookByISBN(); break;
                case "4": editBookCost(); break;
                case "5": displayAllBooks(); break;
                case "6": generateReport(); break;
                case "7": saveBooksToFile(); return;
                default: System.out.println("Invalid choice. Please try again.");
            }

            /* Tells the program what to do based on users input. If input is invalid 
               it returns error message. */

        }
    }

    private static void loadBooksFromFile() {

        /* Method used to load books into thr program. */

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            /* Begins try-catch block. Creating new buffered reader instance */

            String line;

            /* Holds each line of file as its read. */

            while ((line = reader.readLine()) != null) {

                /* Begins a loop reading each line until the end of the file then stops. */

                String[] parts = line.split(",", -1);

                /* Holds each column of data after its seperated. Split method breaks line 
                   into parts by using the comma as a delimeter. keeping empty trailing parts
                   if there are extra commas in the end. */

                for (int i = 0; i < parts.length; i++) {

                    /* Loop that goes through each element. Starting at 0 and stopping after 
                       i is less than the length of the  parts array. i++ raises i by increments
                       of 1 after each iteration. */

                    parts[i] = parts[i].replaceAll("^\"|\"$", "").trim();

                    /* Removes quatation marks and any white space from the beginning and end of each line. */

                }

                if (parts.length == 7) {

                    /* Checks if the parts array has exactly 7 elements. */

                    String type = parts[0];
                    String isbn = parts[1];
                    String title = parts[2];
                    String author = parts[3];
                    int year = Integer.parseInt(parts[4]);
                    double cost = Double.parseDouble(parts[5]);
                    String genreOrTopic = parts[6];

                    /* Assigning the 7 elements its checking for. */

                    Book2 book = null;

                    /* Declares book object and initially sets it at null. */

                    if (type.equalsIgnoreCase("F")) {

                        /* Checks if the book type is F ignoring the case of the letter. */

                        book = new Fiction2(isbn, title, author, year, cost, genreOrTopic);

                        /* Creates new Fiction2 object using book details and assigns it to the book variable. */

                    } else if (type.equalsIgnoreCase("N")) {

                        /* Checks if the book type is N ignoring the case of the letter. */

                        book = new NonFiction2(isbn, title, author, year, cost, genreOrTopic);

                        /* Creates new NonFiction2 object using book details and assigns it to the book variable. */

                    }

                    if (book != null) {

                        /* Checks if the book object is not null. */

                        store.addBook(book);

                        /* If its not null it adds it to the inventory. */

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading the following book(s): " + e.getMessage());

            /* Catches any errors during file reading and prints out error message. */

        }
    }

    private static void saveBooksToFile() {

        /* Begins method used to save booksto the file. */

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            /* Begins try-with-resources block. Used to open the books csv and 
               creates PrintWriter to write in the file, then automatically closes. */

            for (Book2 book : store.getBooks()) {

                /* For-each loop. Goes though every book2 object. Returns full list 
                   of books. runs once for each book. */

                if (book instanceof Fiction2) {

                    /* Checks if book is a Fiction2 object. */

                    writer.printf("F,%s,%s,%s,%d,%.2f,%s\n",

                    /* Print formatted line into csv file. */

                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYear(), book.getUnitPrice(), ((Fiction2) book).getGenre());

                        /* Values used in the print line. each one fills in a placeholder. */

                } else if (book instanceof NonFiction2) {

                    /* Checks if its NonFiction2 object. */

                    writer.printf("N,%s,%s,%s,%d,%.2f,%s\n",

                    /* Print formatted line into csv file. */

                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYear(), book.getUnitPrice(), ((NonFiction2) book).getTopic());

                        /* Values used in the print line. each one fills in a placeholder. */

                }
            }
            System.out.println("Books have been saved successfully.");

            /* Prints out success message after all books have been written to file. */

        } catch (IOException e) {

            /* Catches errors */

            System.out.println("There was an error saving books: " + e.getMessage());

            /* Prints error message if books could not be saved. */

        }
    }

    private static void displayMenu() {

        /* Defines private static method to display the menu. */

        System.out.println("\nBook Inventory Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Find Book by ISBN");
        System.out.println("3. Remove Book by ISBN");
        System.out.println("4. Edit Book Cost");
        System.out.println("5. Display All Books");
        System.out.println("6. Generate Report");
        System.out.println("7. Save & Exit");
        System.out.print("Please choose an option: ");

        /* Prints out menu header, each line option and asks the user to choose one. */

    }

    private static void addBook() {

        /* Defines private static method to add a book. */

        System.out.print("Please enter book type (F/N): ");

        /* Asks user for book type. */

        String type = input.nextLine();

        /* Reads user input and stores it in type variable. */

        System.out.print("Please enter ISBN: ");

        /* Asks user for ISBN. */

        String isbn = input.nextLine();

        /* Reads user input and stores it in isbn variable. */

        System.out.print("Please enter title: ");

        /* Asks user for title. */

        String title = input.nextLine();

        /* Reads user input and stores it in title variable. */

        System.out.print("Please enter author: ");

        /* Asks for author. */

        String author = input.nextLine();

        /* Reads user input and stores it in author variable. */

        System.out.print("Please enter year: ");

        /* Asks for year. */

        int year = Integer.parseInt(input.nextLine());

        /* Reads user input converts it to int and stores it in year variable. */

        System.out.print("Please enter cost: ");

        /* Asks for cost. */

        double cost = Double.parseDouble(input.nextLine());

        /* Reads user input converts it to double and stores it in cost variable. */

        Book2 book = null;

        /* Creates Book2 variable and initially sets it to null. */

        if (type.equalsIgnoreCase("F")) {

            /* Checks if you entered f. */

            System.out.print("Please enter genre: ");

            /* If its fiction asks for genre. */

            String genre = input.nextLine();

            /* Reads input and stores it in genre variable. */

            book = new Fiction2(isbn, title, author, year, cost, genre);

            /* Creates new Fiction2 object and assigns it to book. */

        } else if (type.equalsIgnoreCase("N")) {

            /* Checks if n was entered. */

            System.out.print("Please enter topic: ");

            /* Asks for book topic. */

            String topic = input.nextLine();

            /* Reads input and stores in topic variable. */

            book = new NonFiction2(isbn, title, author, year, cost, topic);

            /* Creates new NonFiction2 object and assigns it to book. */


        }

        if (book != null && store.addBook(book)) {

            /* Checks if book is not null and adds book to inventory. */

            System.out.println("Book was added successfully!");

            /* Prints out message if book was added. */

        } else {
            System.out.println("Error! Failed to add book.");

            /* Prints out error message if book was not added. */

        }
    }

    private static void findBookByISBN() {

        /* Declares private method to find book by ISBN. */

        System.out.print("Please enter ISBN: ");

        /* asks user to enter ISBN. */

        String isbn = input.nextLine();

        /* Reads input and stores in isbn variable as a string. */

        Book2 book = store.findBookByISBN(isbn);

        /* Calls findBookByISBN method if book matches its returned otherwise book is null. */

        if (book != null) {

            /* Checks whether book was found. */

            System.out.println(book);

            /* Prints book details if it is found. */

        } else {
            System.out.println("Error! Book was not found.");

            /* Prints error message if book isnt found. */

        }
    }

    private static void removeBookByISBN() {

        /* Declares private method to remove book by ISBN. */

        System.out.print("Please enter ISBN to remove: ");

        /* Asks for ISBN. */

        String isbn = input.nextLine();

        /* Reads input and stores in isbn string variable. */

        if (store.removeBookByISBN(isbn)) {

            /*Calls removeBookByISBN method passes the ISBN and checks result. */

            System.out.println("Book was successfully removed.");

            /* If true the book is removed and success message is displayed. */

        } else {
            System.out.println("Error! Book was not found.");

            /* if false an error message in displayed. */

        }
    }

    private static void editBookCost() {

        /* Declares private method to edit books cost. */

        System.out.print("Please enter ISBN: ");

        /* Asks user for ISBN. */

        String isbn = input.nextLine();

        /* Reads user input and stores in isbn variable. */

        Book2 book = store.findBookByISBN(isbn);

        /* Calls findBookByISBN method and searches for isbn.  */

        if (book != null) {

            /* Checks if book was found. */

            System.out.print("Please enter new cost: ");

            /* If book is found, asks user for new cost. */

            double cost = Double.parseDouble(input.nextLine());

            /* Reads user input and stores in cost variable */

            book.setCost(cost);

            /* Calls setCost method passes new value and updates cost. */

            System.out.println("Cost was updated successfully.");

            /* If cost was updated successfully it prints our message. */

        } else {
            System.out.println("Error! Book not found.");

            /* If book was not found it prints out error message. */

        }
    }

    private static void displayAllBooks() {

        /* Declares private method to display all books. */

        store.displayBooks();

        /* Calls displayBooks method and loops through all books and prints each one. */

    }

    private static void generateReport() {

        /* Declares private method to generate report. */

        System.out.println("\n=== Book Report ===");

        /* Prints report header. */

        for (Book2 book : store.getBooks()) {

            /* For-each loop. loops though each book2 object and puts put one book into book variable. */

            System.out.printf("%s (%d) - $%.2f\n", book.toString(), book.getYear(), book.getUnitPrice());

            /* Prints formatted details of the books. */

        }
    }
}