package structure.repository;

import structure.database.DatabaseConnection;
import structure.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    
    public static void findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");)
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("id") + ", Name: " + resultSet.getString("name") + ", Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error while trying to fetch all users: " + e.getMessage());
        }
    }

    public static void create(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, email) VALUES (?,?)");)
        {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
            System.out.println("user has been created");
        }catch (SQLException e) {
            System.out.println("Error while trying to create user: " + e.getMessage());
        }
    }

    public static void update(int id, User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET name=?, email=? WHERE id=?");)
        {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0)
                System.out.println("user Not Found");
            else
                System.out.println("user has been updated");
        }catch (SQLException e){
            System.out.println("Error while trying to update user: " + e.getMessage());
        }
    }

    public static void delete(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?");)
        {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0)
                System.out.println("user Not Found");
            else
                System.out.println("user has been deleted");
        }catch (SQLException e){
            System.out.println("Error while trying to delete user: " + e.getMessage());
        }
    }
        
}