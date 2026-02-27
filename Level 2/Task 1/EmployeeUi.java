import java.util.Scanner;

public class EmployeeUi {

    public static void getAllEmployees() {
        for (Employee emp:EmployeeService.getAllEmployees()) {
            System.out.printf("""
                    ID: %d
                    Name: %s
                    Email: %s
                    Salary: %f
                    ===========================%n""", emp.getId(), emp.getName(), emp.getEmail(), emp.getSalary());
        }
    }

    public  static void addEmployee(Scanner input) {
        System.out.print("Input Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Input Employee Name: ");
        String name = input.nextLine();
        System.out.print("Input Employee Email: ");
        String email = input.nextLine();
        System.out.print("Input Employee Salary: ");
        double salary = input.nextDouble();
        Employee emp = new Employee(id,name,email,salary);
        System.out.println(EmployeeService.addEmployee(emp));
    }

    public static void getEmployee(Scanner input) throws EmployeeNotFoundException {
        System.out.print("Input Employee ID: ");
        int id = input.nextInt();
        Employee emp = EmployeeService.getEmployee(id);
        System.out.println(emp);
    }

    public static void updateEmployee(Scanner input) throws EmployeeNotFoundException {
        System.out.print("Input Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Input Employee New Name: ");
        String name = input.nextLine();
        System.out.println("Input Employee New Salary: ");
        double salary = input.nextDouble();
        System.out.println(EmployeeService.updateEmployee(id, name, salary));
    }

    public static void removeEmployee(Scanner input) throws EmployeeNotFoundException {
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        System.out.println(EmployeeService.removeEmployee(id));
    }
}
