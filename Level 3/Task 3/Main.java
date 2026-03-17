import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BstService bstService = new BstService();

        while (true){
            System.out.print("\n ================== \n");
            System.out.printf("1. Insert \n2. Search \n3. Remove \n4. Traversal \n5. Exit \n");
            System.out.print("Choose an operation: ");
            try {

                int input = scanner.nextInt();
                if (input == 5) break;
                switch (input){
                    case 1: bstService.insert(scanner); break;
                    case 2: bstService.search(scanner); break;
                    case 3: bstService.remove(scanner); break;
                    case 4: bstService.traversal(scanner); break;
                    default: System.out.println("Invalid Value!"); break;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input!");
                scanner.nextLine();
            }
        }

    }
}
