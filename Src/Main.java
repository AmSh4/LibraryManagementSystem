import service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(bookId, title, author);
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    library.addUser(userId, name);
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    library.borrowBook(bookId, userId);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    library.returnBook(bookId);
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
