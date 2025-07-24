# LibraryManagementSystem
A Java-based console application for managing a library.

## Overview
The Library Management System is a console-based Java application designed to manage a library's books, users, and borrowing transactions. It demonstrates object-oriented programming (OOP) principles, file handling, and data persistence using CSV files. This project showcases modular, production-ready code suitable for a Software Development Engineer (SDE) portfolio.

## Features
- **Book Management**: Add, update, and view books in the library.
- **User Management**: Register and manage library users.
- **Borrowing System**: Allow users to borrow and return books, with availability tracking.
- **Data Persistence**: Store books, users, and transactions in CSV files.
- **Error Handling**: Robust input validation and error management.

## Technologies Used
- **Language**: Java 17
- **Concepts**: OOP (Encapsulation, Inheritance, Polymorphism), File I/O, ArrayList, Exception Handling
- **Data Storage**: CSV files

## Project Structure
    ```
    LibraryManagementSystem/
    ├── src/
    │   ├── model/
    │   │   ├── Book.java
    │   │   ├── User.java
    │   │   ├── Transaction.java
    │   ├── service/
    │   │   ├── LibraryService.java
    │   │   ├── FileHandler.java
    │   ├── Main.java
    ├── data/
    │   ├── books.csv
    │   ├── users.csv
    │   ├── transactions.csv
    ├── README.md

   

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/AmSh4/LibraryManagementSystem.git

2. **Compile and Run:**
    Ensure Java 17 is installed.
    Compile the project:
    ```bash
    javac -d bin src/*.java src/model/*.java src/service/*.java
  
 Run the application:
     
    java -cp bin Main

3.**Interact with the Application:**
    Use the console menu to add books/users, borrow/return books, or view the book list.
## Dataset
The data/ directory contains large datasets to demonstrate scalability:
books.csv: Stores 50 book records (ID, title, author, availability).
users.csv: Stores 20 user records (ID, name).
transactions.csv: Stores 30 borrowing records (book ID, user ID, borrow date, return date).

## Usage
Run the program and select options from the menu:
Add a new book to the library.
Register a new user.
Borrow a book (requires book ID and user ID).
Return a borrowed book.
Display all books with their availability status.
Exit the application.

## Future Enhancements
Add a GUI using JavaFX or Swing.
Implement a database (e.g., MySQL) instead of CSV files.
Add user authentication and role-based access (e.g., admin vs. user).
Generate detailed reports (e.g., overdue books).

## License
This project is licensed under the MIT License
