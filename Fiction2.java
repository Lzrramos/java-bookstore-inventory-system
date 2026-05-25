// Lazaro Ramos
// 05/02/2025

/* This class is an extension of the Book2 class that is used to add, modify 
   and get fantasy genres in the inventory. */

public class Fiction2 extends Book2 {

    /* Declares class name and sets the inherited fields and methods from Book2 class. */

    private String genre;

    /* Declares private instance variable for genre. */

    public Fiction2(String isbn, String title, String author, int year, double cost, String genre) {

    /* Defines the constructor with data that matches the structure in BookInventoryApp2. */

        super(isbn, title, author, year, cost); 
        
        /* Calls the constructor of the super class Book2 using the super keyword. */

        this.genre = genre;

        /* Initializes the genre field of Fiction2 using parameters passed into constructor. */

    }    

    public String getGenre() {

        /* Public method that gets the value of genre field. */

        return genre;

        /* Returns the genre. */

    }
    
    public void setGenre(String genre) {

        /* Public method that sets up value of genre. */

        this.genre = genre;

        /* Assigns value of parameter genre to instance variable genre. */

    }

    @Override
    public String toString() {

        /* Overrides the toString method from Book2. */

        return super.toString() + " - " + genre;

        /* Returns the string from Book2 then add the genre to the end of the string. */

    }
}