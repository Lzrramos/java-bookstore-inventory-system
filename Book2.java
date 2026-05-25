// Lazaro Ramos
// 05/02/2025

public abstract class Book2 {

    /* Declares the abstract class name. */

    private String isbn;
    private String title;
    private String author;
    private int year;
    private double unitPrice;
    private boolean validBook;

    /* Setting instance variables for book */

    public Book2(String isbn, String title, String author, int year, double cost) {

        /* Contstuctor method runs when new Book2 objects are created */

        if (isValidISBN(isbn) && title != null && !title.isEmpty() 
        && author != null && !author.isEmpty() && year > 0 && cost >= 0.0) {

            /* Checks if all values are valid. ISBN is formatted correctly, Title and 
               author are not empty, year and price is greater than 0. */

            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.year = year;
            this.unitPrice = cost;
            this.validBook = true;

            /* If valid it sets all fields and marks validBook as true. */

        } else {
            this.isbn = "*";
            this.title = title;
            this.author = author;
            this.year = year;
            this.unitPrice = cost;
            this.validBook = false;

            /* If its not valid it sets the isbn to * and validBook to false. */

        }
    }

    public boolean isValidISBN(String isbn) {

        /* Declares a method to check if ISBN string follows validISBN rules. */

        return isbn != null && isbn.matches("^(978|979)\\d{10}$");

        /* Checks if the ISBN is not null and it matches the 13 digit pattern for valid ISBNs. */

    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public double getUnitPrice() { return unitPrice; }
    public boolean isValidBook() { return validBook; }

    /* Getters that return the value of each field. */

    public void setCost(double cost) {

        /* Defines a setter method to allow the cost to be modified. */

        if (cost >= 0.0) {

            /* Checks if the cost is greater than or equal to 0. */

            this.unitPrice = cost;

            /* If the cost is valid and non negative it updates the cost. */

        }
    }

    // toString method
    @Override
    public String toString() {
        return isbn + ": " + title + " - " + author + " - $" + String.format("%.2f", unitPrice);

        /* Overrides toString method to return a formatted string showing the book details. */

    }
} 