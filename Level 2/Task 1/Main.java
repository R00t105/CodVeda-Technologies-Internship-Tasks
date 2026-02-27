import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("""
                        Choose a Service:
                        1. Get All Employees
                        2. Get Employee by ID
                        3. Add Employee
                        4. Update Employee by ID
                        5. Remove Employee by ID
                        6. Exit Program
                        """);
                int choice = input.nextInt();
                input.nextLine();
                if (choice >= 1 && choice <= 5) {
                    switch (choice) {
                        case 1: EmployeeUi.getAllEmployees();break;
                        case 2: EmployeeUi.getEmployee(input); break;
                        case 3: EmployeeUi.addEmployee(input);break;
                        case 4: EmployeeUi.updateEmployee(input); break;
                        case 5: EmployeeUi.removeEmployee(input); break;
                        default: System.out.println("Invalid choice");
                    }
                } else if (choice == 6) {
                    break;
                } else {
                    System.out.println("Error! Choose from the choices only");
                }

            } catch (Exception e) {
                System.out.println("Invalid Data");
                input.nextLine();
            }
        }
        input.close();
    }
}
