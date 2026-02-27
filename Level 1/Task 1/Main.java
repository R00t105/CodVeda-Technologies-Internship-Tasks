import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int operator;
        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                Ui.welcomeMessage();
                operator = scanner.nextInt();
                scanner.nextLine();

                if (operator == 5)
                    break;
                else if (operator >= 1 && operator <= 4) {
                    System.out.print("Enter First Number: ");
                    double num1 = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Second Number: ");
                    double num2 = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(Calculator.calculate(operator, num1, num2));
                }
                else
                    Ui.errorChoice();

            }catch (Exception e){
                Ui.errorInput();
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}