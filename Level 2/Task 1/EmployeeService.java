import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    static List<Employee> employees = new ArrayList<>();

    public static List<Employee> getAllEmployees() {
        return employees;
    }

    public static Employee getEmployee(int id) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException(id);
    }

    public static String addEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == employee.getId()) {
                return "Employee already exists";
            }
        }
        employees.add(employee);
        return "Employee added successfully";
    }

    public static String updateEmployee(int id, String name, Double salary) throws EmployeeNotFoundException {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(name);
                e.setSalary(salary);
                return "Employee updated successfully";
            }
        }
        throw new EmployeeNotFoundException(id);
    }

    public static String removeEmployee(int id) throws EmployeeNotFoundException {
        var status = employees.removeIf(employee -> employee.getId() == id);
        if (status) {return "Employee removed successfully";}
        throw new EmployeeNotFoundException(id);
    }
}
