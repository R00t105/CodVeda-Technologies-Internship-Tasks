package structure.Sevice;

import java.util.Scanner;

public class MenuHandler {

    public static void showMainMenu() {
        System.out.println("""
                        =========== Main Menu ===========
                        1. Users
                        2. Books
                        3. Transactions
                        4. Exit""");
    }

    public static void showUserMenu(Scanner scanner) {
        System.out.println("""
                        1. Add User
                        2. Update User
                        3. Delete User
                        4. Get All Users
                        5. Back""");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                UserService.addUser(scanner);
                break;
            case 2:
                UserService.updateUser(scanner);
                break;
            case 3:
                UserService.deleteUser(scanner);
                break;
            case 4:
                UserService.getAllUsers();
                break;
            case 5: break;
            default:
                System.out.println("Invalid choice");
                break;

        }
    }

    public static void showBookMenu(Scanner scanner) {
        System.out.println("""
                        1. Add Book
                        2. Update Book
                        3. Delete Book
                        4. Get All Books
                        5. Back""");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                BookService.addBook(scanner);
                break;
            case 2:
                BookService.updateBook(scanner);
                break;
            case 3:
                BookService.deleteBook(scanner);
                break;
            case 4:
                BookService.getAllBooks();
                break;
            case 5: break;
            default:
                System.out.println("Invalid choice");
                break;

        }
    }

    public static void showTransactionMenu(Scanner scanner) {
        System.out.println("""
                        1. Borrow Book
                        2. Return Book
                        3. All Transactions
                        4. Back""");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                TransactionService.borrowBook(scanner);
                break;
            case 2:
                TransactionService.returnBook(scanner);
                break;
            case 3:
                TransactionService.getAllTransactions();
                break;
            case 4: break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
