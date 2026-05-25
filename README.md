# Bookstore Inventory Management System (Java)

## Overview
This project is a console-based bookstore inventory management system built in Java. It demonstrates object-oriented programming principles, including encapsulation, inheritance, and abstract classes, along with file handling for persistent data storage using CSV files.

The system allows users to manage a collection of books, including fiction and non-fiction types, while supporting full inventory operations through a menu-driven interface.

---

## Features
- Add new books (Fiction and Non-Fiction)
- Remove books by ISBN
- Search for books by ISBN
- Edit book pricing
- Display all books in inventory
- Generate formatted inventory reports
- Track book quantity and stock status
- Identify out-of-stock books
- Load inventory data from CSV file on startup
- Save updated inventory back to CSV file on exit

---

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Abstract Classes
- Inheritance & Polymorphism
- File I/O (BufferedReader, FileWriter, PrintWriter)
- CSV Data Handling
- Scanner for user input
- Exception Handling
---

## Project Structure
src/
├── Book.java
├── Book2.java
├── Fiction2.java
├── NonFiction2.java
├── BookStore.java
├── BookStore2.java
├── BookInventoryApp.java
├── BookInventoryApp2.java
├── CheckISBN.java

data/
└── books.csv


---

## Concepts Demonstrated
- Encapsulation and data hiding
- Constructor overloading
- Abstract class design
- Method overriding
- Dynamic object creation (Fiction vs Non-Fiction)
- Array-based inventory management
- File persistence using CSV
- Input validation and error handling
- Menu-driven application design

---

## How It Works
1. The application starts and loads book data from a CSV file
2. Users interact with a menu-driven interface
3. Books can be added, removed, searched, or edited
4. Inventory reports can be generated at any time
5. All changes are saved back to the CSV file before exiting

---

## What I Learned
- How to design and build multi-class Java applications
- How inheritance improves code structure and reusability
- How to persist data using file I/O
- How to organize larger programs into maintainable components
- How real-world inventory systems are structured

---

## Future Improvements
- Add a graphical user interface (GUI)
- Replace arrays with ArrayLists for scalability
- Add database integration (MySQL or SQLite)
- Improve search with partial matching
- Add user login system

---

## Author
Lazaro Ramos
