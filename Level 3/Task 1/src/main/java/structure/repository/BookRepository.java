package structure.repository;

import structure.database.DatabaseConnection;
import structure.entity.Book;
import java.sql.*;

public class BookRepository {

    public static void findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM books");)
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("id") + "Title: " + resultSet.getString("title") + ", Author: " + resultSet.getString("author") + ", Available Copies: "+ resultSet.getInt("available_copies"));
            }
        } catch (SQLException e) {
            System.out.println("Error while trying to fetch all books: " + e.getMessage());
        }
    }

    public static void create(Book book) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO books (title, author, available_copies) VALUES (?,?,?)");)
        {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getAvailableCopies());
            statement.executeUpdate();
            System.out.println("Book has been created");
        }catch (SQLException e) {
            System.out.println("Error while trying to create book: " + e.getMessage());
        }
    }

    public static void update(int id, Book book) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE books SET title=?, author=?, available_copies=? WHERE id=?");)
        {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getAvailableCopies());
            statement.setInt(4, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0)
                System.out.println("Book Not Found");
            else
                System.out.println("Book has been updated");
        }catch (SQLException e){
            System.out.println("Error while trying to update book: " + e.getMessage());
        }
    }

    public static void delete(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id=?");)
        {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0)
                System.out.println("Book Not Found");
            else
                System.out.println("Book has been deleted");
        }catch (SQLException e){
            System.out.println("Error while trying to delete book: " + e.getMessage());
        }
    }

    public static Book getById(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE id=?")
        )
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int copies = resultSet.getInt("available_copies");
                Book book = new Book(title, author, copies);
                book.setId(resultSet.getInt("id"));
                return book;
            }else
                return null;
        }catch (SQLException e){
            System.out.println("Error while trying to find book by id: " + e.getMessage());
            return null;
        }
    }

}