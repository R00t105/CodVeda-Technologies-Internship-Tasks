import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount("Momen", BigDecimal.valueOf(1500));
        while (true) {

            System.out.println("""
                    --------------- Welcome -------------
                    Choose a service:
                    1. Deposit
                    2. Withdraw
                    3. Balance
                    4. Exit""");

            try {
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    System.out.print("Amount: ");
                    BigDecimal amount = input.nextBigDecimal();
                    bankAccount.deposit(amount);
                }
                else if (choice == 2) {
                    System.out.print("Amount: ");
                    BigDecimal amount = input.nextBigDecimal();
                    bankAccount.withdraw(amount);
                }
                else if (choice == 3) {
                    System.out.println("Account Balance: " + bankAccount.getBalance());
                } else if (choice == 4) {
                    break;
                } else System.out.println("Error! Choose a number from the list");

            }
            catch (Exception e) {
                System.out.println("Invalid input - Letters are not allowed!");
                input.nextLine();
            }
        }
    }
}
