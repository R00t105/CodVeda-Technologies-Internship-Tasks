package structure.repository;

import structure.database.DatabaseConnection;
import structure.entity.Book;
import structure.entity.Transaction;
import java.sql.*;
import java.time.LocalDate;

public class TransactionRepository {

    public static void borrowBook(Transaction transaction) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transactions (user_id, book_id, borrow_date, return_date)  VALUES (?, ?, ?, ?)");
             PreparedStatement updateBookCopies = connection.prepareStatement("UPDATE books SET available_copies = ? WHERE id =?");)
        {
            Book borrowedBook = BookRepository.getById(transaction.getBookId());
            if (borrowedBook == null || borrowedBook.getAvailableCopies() <= 0){
                System.out.println("No Copies Available Or Book Not Available");
                return;
            }
            preparedStatement.setInt(1, transaction.getUserId());
            preparedStatement.setInt(2, transaction.getBookId());
            preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatement.setNull(4, Types.DATE);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No User or Book Match");
                return;
            }
            updateBookCopies.setInt(1, (borrowedBook.getAvailableCopies() - 1));
            updateBookCopies.setInt(2, borrowedBook.getId());
            updateBookCopies.executeUpdate();
            System.out.println("Book Borrowed Successfully");

        }catch (SQLException e){
            System.out.println("Error in borrowing transaction: " + e.getMessage());
        }
    }

    public static void returnBook(Transaction transaction) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE transactions SET return_date = ? WHERE user_id = ? AND id =?");
             PreparedStatement updateBookCopies = connection.prepareStatement("UPDATE books SET available_copies = ? WHERE id =?");)
        {
            preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(2, transaction.getUserId());
            preparedStatement.setInt(3, transaction.getBookId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No User or Book Match");
                return;
            }

            Book returnedBook = BookRepository.getById(transaction.getBookId());
            updateBookCopies.setInt(1, (returnedBook.getAvailableCopies() + 1));
            updateBookCopies.setInt(2, transaction.getBookId());
            updateBookCopies.executeUpdate();
            System.out.println("Book Returned Successfully");
        }catch (SQLException e) {
            System.out.println("Error in Returning Book: " + e.getMessage());
        }
    }

    public static void getAllTransactions() {
        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transactions");)
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(String.format("""
                        Transaction ID: %d, User ID: %d, Book ID: %d, Borrow Date: %s, Return Date: %s
                        """,
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("book_id"),
                        resultSet.getString("borrow_date".toString()),
                        resultSet.getString("return_date".toString())
                        ));
            }
        }catch (SQLException e) {
            System.out.println("Error while Trying To Get All Transactions");
        }
    }
}