package structure.Sevice;

import structure.entity.User;
import structure.repository.UserRepository;
import java.util.Scanner;

public class UserService {

    public static void addUser(Scanner scanner) {
        System.out.print("Enter Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        UserRepository.create(new User(name, email));
    }

    public static void updateUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        UserRepository.update(id, new User(name, email));
    }

    public static void deleteUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        UserRepository.delete(id);
    }

    public static void getAllUsers() {
        UserRepository.findAll();
    }

}