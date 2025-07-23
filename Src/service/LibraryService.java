package service;

import model.Book;
import model.User;
import model.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;
    private List<User> users;
    private List<Transaction> transactions;
    private FileHandler fileHandler;

    public LibraryService() {
        fileHandler = new FileHandler();
        books = fileHandler.loadBooks();
        users = fileHandler.loadUsers();
        transactions = fileHandler.loadTransactions();
    }

    public void addBook(String id, String title, String author) {
        books.add(new Book(id, title, author));
        fileHandler.saveBooks(books);
        System.out.println("Book added successfully!");
    }

    public void addUser(String id, String name) {
        users.add(new User(id, name));
        fileHandler.saveUsers(users);
        System.out.println("User added successfully!");
    }

    public void borrowBook(String bookId, String userId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available!");
            return;
        }
        if (findUser(userId) == null) {
            System.out.println("User not found!");
            return;
        }
        book.setAvailable(false);
        transactions.add(new Transaction(bookId, userId, LocalDate.now()));
        fileHandler.saveBooks(books);
        fileHandler.saveTransactions(transactions);
        System.out.println("Book borrowed successfully!");
    }

    public void returnBook(String bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        Transaction transaction = findActiveTransaction(bookId);
        if (transaction == null) {
            System.out.println("No active borrow record found!");
            return;
        }
        book.setAvailable(true);
        transaction.setReturnDate(LocalDate.now());
        fileHandler.saveBooks(books);
        fileHandler.saveTransactions(transactions);
        System.out.println("Book returned successfully!");
    }

    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor() +
                    " [" + (book.isAvailable() ? "Available" : "Borrowed") + "]");
        }
    }

    private Book findBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private User findUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    private Transaction findActiveTransaction(String bookId) {
        for (Transaction transaction : transactions) {
            if (transaction.getBookId().equals(bookId) && transaction.getReturnDate() == null) {
                return transaction;
            }
        }
        return null;
    }
              }
