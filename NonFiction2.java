// Lazaro Ramos
// 05/02/2025

/* This class is an extension of the Book2 class that is used to add 
   the topic to the book details. */

public class NonFiction2 extends Book2 {

    /* Declares class name and sets the inherited fields and methods from Book2 class. */

    private String topic;

    /* Declares the encapsulated variable topic. */

    public NonFiction2(String isbn, String title, String author, int year, double cost, String topic) {

        /* Constructor used to set up the data when a book is created. */

        super(isbn, title, author, year, cost);

        /* Calls the constructor of Book2. */
        /* Super passes the common book details to store them appropriately. */

        this.topic = topic;

        /* Sets the topic variable passed into constructor. */

    }

    public String getTopic() {

        /* Getter that lets the other classes access the books topic. */

        return topic;

        /* Returns topic. */

    }

    public void setTopic(String topic) {

        /* Setter allowing modification of the books topic after creation. */

        this.topic = topic;
    }

    @Override
    public String toString() {

        /* Overrides the toString method from Book2. */

        return super.toString() + " - " + topic;

        /* Returns the string from Book2 then add the topic to the end of the string. */

    }
}