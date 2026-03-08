package structure.Sevice;

import structure.entity.Transaction;
import structure.repository.TransactionRepository;
import java.util.Scanner;

public class TransactionService {

    public static void borrowBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int bookID = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        TransactionRepository.borrowBook(new Transaction(userId, bookID));
    }

    public static void returnBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int bookID = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        TransactionRepository.returnBook(new Transaction(userId, bookID));
    }

    public static void getAllTransactions() {
        TransactionRepository.getAllTransactions();
    }
}
