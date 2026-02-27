import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(" 1. Factorial\n 2. Exit ");
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 2) {break;}
                else if (choice == 1) {
                    System.out.print("Enter a number: ");
                    long number = input.nextLong();
                    input.nextLine();
                    if (number < 0)
                        System.out.println("Number cannot be negative");
                    else
                        System.out.println("Result: " + factorial(number));
                }else {
                    System.out.println("Error! Choose between 1 and 2");}
            }catch (Exception e){
                System.out.println("Letters is not allowed");
                input.nextLine();
            }
        }
    }

    public static long factorial(long n){
        if (n == 1 || n == 0) {return 1;}
        else
            return n * factorial(n-1);
    }
}

