package structure.Sevice;

import structure.entity.Book;
import structure.repository.BookRepository;
import java.util.Scanner;

public class BookService {

    public static void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter availableCopies: ");
        int availableCopies = scanner.nextInt();
        BookRepository.create(new Book(title, author, availableCopies));
    }

    public static void updateBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New title: ");
        String title = scanner.nextLine();
        System.out.print("Enter New author: ");
        String author = scanner.nextLine();
        System.out.print("Enter New availableCopies: ");
        int availableCopies = scanner.nextInt();
        BookRepository.update(id, new Book(title, author, availableCopies));
    }

    public static void deleteBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        BookRepository.delete(id);
    }

    public static void getAllBooks() {
        BookRepository.findAll();
    }

}