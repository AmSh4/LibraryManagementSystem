package service;

import model.Book;
import model.User;
import model.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String BOOKS_FILE = "data/books.csv";
    private static final String USERS_FILE = "data/users.csv";
    private static final String TRANSACTIONS_FILE = "data/transactions.csv";

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Book book = new Book(parts[0], parts[1], parts[2]);
                book.setAvailable(Boolean.parseBoolean(parts[3]));
                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
        return books;
    }

    public void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                users.add(new User(parts[0], parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    public void saveUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Transaction transaction = new Transaction(parts[0], parts[1], LocalDate.parse(parts[2]));
                if (!parts[3].equals("Not Returned")) {
                    transaction.setReturnDate(LocalDate.parse(parts[3]));
                }
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }

    public void saveTransactions(List<Transaction> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }
        }
