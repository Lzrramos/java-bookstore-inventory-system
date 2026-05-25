// Lazaro Ramos
// 05/02/2025

import java.util.ArrayList;

/* Imports ArrayList class. */

public class BookStore2 {

    /* Declares the class name. */

    private ArrayList<Book2> inventory;

    /* Declares private list named inventory. */

    
    public BookStore2() {

        /* Constructor that runs when a new BookStore2 object is created */

        inventory = new ArrayList<>();

        /* Enables the inventory list to start empty. */

    }

    public boolean addBook(Book2 book) {

        /* Beginning of the method to add a new book to inventory. */

        if (book != null && book.isValidBook()) {

            /* Checks to see if the book is not null and it passes 
               the isValidBook check before adding. */

            inventory.add(book);

            /* Adds book to inventory. */

            return true;

            /* Returns true if book was added. */

        }
        return false;

        /* Returns false if book was not added. */

    }

    // Find a book by ISBN
    public Book2 findBookByISBN(String isbn) {

        /* Beginning of the method to find books by ISBN. */

        for (Book2 book : inventory) {

            /* Loops through inventory searching for book. */

            if (book.getIsbn().equals(isbn)) {

                /* Verifies if ISBN matches book in inventory. */

                return book;

                /* Returns book if true. */

            }
        }
        return null;

        /* Returns null if false. */

    }

    public boolean removeBookByISBN(String isbn) {

        /* Beginning of the method to remove books by ISBN. */

        Book2 book = findBookByISBN(isbn);

        /* Searches for the book using ISBN */

        if (book != null) {
            inventory.remove(book);
            return true;
        }

        /* If book is not equal to null it returns true and removes the book. */

        return false;

        /* If book is equal to null it returns false. */

    }

    public void displayBooks() {

        /* Beginning of the method to display all books. */

        if (inventory.isEmpty()) {
            System.out.println("Error! There are no books in inventory.");

            /* If there are no books it prints our error message. */

        } else {
            for (Book2 book : inventory) {
                System.out.println(book);
            }

            /* If there are books it prints out all the books */

        }
    }

    public ArrayList<Book2> getBooks() {
        return inventory;
    }

    /* Getter method used to return whole inventory list. */
    /* Can be used for saving to a file or report making. */

} 