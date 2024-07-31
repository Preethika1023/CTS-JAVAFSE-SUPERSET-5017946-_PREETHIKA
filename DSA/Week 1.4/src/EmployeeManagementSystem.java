public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }


    public void addEmployee(Employee employee) {
        if (size < capacity) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }


    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }


    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            Employee emp = employees[i];
            System.out.println("ID: " + emp.getEmployeeId() + ", Name: " + emp.getName() +
                    ", Position: " + emp.getPosition() + ", Salary: " + emp.getSalary());
        }
    }


    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Employee e1 = new Employee("101", "Alice", "Manager", 75000);
        Employee e2 = new Employee("102", "Bob", "Developer", 60000);
        Employee e3 = new Employee("103", "Charlie", "Designer", 55000);

        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("\nSearch Employee with ID 102:");
        Employee emp = ems.searchEmployee("102");
        if (emp != null) {
            System.out.println("Found: " + emp.getName() + ", " + emp.getPosition() + ", " + emp.getSalary());
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDelete Employee with ID 102:");
        ems.deleteEmployee("102");

        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
