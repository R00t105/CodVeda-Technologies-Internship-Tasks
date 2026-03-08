package structure;

import structure.Sevice.MenuHandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                MenuHandler.showMainMenu();
                int choice = scanner.nextInt();
                if(choice == 4) {System.out.println("Good Bye!");break;}
                switch (choice) {
                    case 1: MenuHandler.showUserMenu(scanner);break;
                    case 2: MenuHandler.showBookMenu(scanner);break;
                    case 3: MenuHandler.showTransactionMenu(scanner);break;
                    default: System.out.println("Wrong choice");}
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                scanner.nextLine();}
        }
    }
}