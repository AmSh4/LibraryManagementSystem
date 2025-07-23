package model;

import java.time.LocalDate;

public class Transaction {
    private String bookId;
    private String userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // Constructor
    public Transaction(String bookId, String userId, LocalDate borrowDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return bookId + "," + userId + "," + borrowDate + "," + (returnDate != null ? returnDate : "Not Returned");
    }
}
