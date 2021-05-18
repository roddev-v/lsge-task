import models.Employee;

import java.util.ArrayList;
import java.util.Stack;

public class Company {
    private static Company instance = null;
    private Employee rootEmployee;

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public void storeEmployees() {

        // root level
        final Employee root = new Employee(1, "Employee 1", "Bucharest");

        // left
        final Employee emp1 = new Employee(2, "Employee 2", "Bucharest");
        final Employee emp4 = new Employee(4, "Employee 4", "Bucharest");

        final Employee emp7 = new Employee(7, "Employee 7", "Bucharest");
        final ArrayList<Employee> emp4Employees = new ArrayList<Employee>();
        emp4Employees.add(emp7);
        emp4.setEmployees(emp4Employees);

        final ArrayList<Employee> emp1Employees = new ArrayList<Employee>();
        emp1Employees.add(emp4);
        emp1.setEmployees(emp1Employees);

        // right
        final Employee emp2 = new Employee(3, "Employee 3", "Bucharest");
        final Employee emp5 = new Employee(5, "Employee 6", "Bucharest");
        final Employee emp6 = new Employee(6, "Employee 6", "Bucharest");
        final Employee emp8 = new Employee(8, "Employee 8", "Bucharest");
        final ArrayList<Employee> emp6Employees = new ArrayList<Employee>();
        emp6Employees.add(emp8);
        emp6.setEmployees(emp6Employees);

        final ArrayList<Employee> emp2Employees = new ArrayList<Employee>();
        emp2Employees.add(emp5);
        emp2Employees.add(emp6);
        emp2.setEmployees(emp2Employees);

        final ArrayList<Employee> rootEmployees = new ArrayList<>();
        rootEmployees.add(emp1);
        rootEmployees.add(emp2);

        root.setEmployees(rootEmployees);
        this.rootEmployee = root;
    }

    public void findTheClosestManager() {
        final Employee first = new Employee(2, "Employee 5'", "Bucharest");
        final Employee second = new Employee(3, "Employee 8'", "Bucharest");

        Employee manager = closestManager(this.rootEmployee, first, second);
        if (manager != null) {
            System.out.println(manager.getName());
        } else {
            System.out.println("No manager found");
        }
    }

    public Employee closestManager(Employee main, Employee first, Employee second) {
        Stack<Employee> pathToFirstEmployee = new Stack<>();
        deepSearch(main, first, pathToFirstEmployee);

        Stack<Employee> pathToSecondEmployee = new Stack<>();
        deepSearch(main, second, pathToSecondEmployee);

        boolean foundFirst = pathToFirstEmployee.peek().getId() == first.getId();
        boolean foundSecond = pathToSecondEmployee.peek().getId() == second.getId();

        if (foundFirst && foundSecond) {
            int size1 = pathToFirstEmployee.size();
            int size2 = pathToSecondEmployee.size();
            int distance = Math.abs(size2 - size1);

            if (size1 > size2) {
                moveUp(pathToFirstEmployee, distance);
            } else {
                moveUp(pathToSecondEmployee, distance);
            }

            while (pathToFirstEmployee.peek().getId() != pathToSecondEmployee.peek().getId()) {
                pathToFirstEmployee.pop();
                pathToSecondEmployee.pop();
            }

            if (pathToFirstEmployee.size() > 0) {
                return pathToFirstEmployee.pop();
            }
        }
        return null;
    }

    private boolean deepSearch(Employee root, Employee target, Stack<Employee> path) {
        path.push(root);
        if (root.getId() == target.getId()) {
            return true;
        }
        for (Employee employee : root.getEmployees()) {
            if (deepSearch(employee, target, path)) {
                return true;
            }
        }
        path.pop();
        return false;
    }

    private void moveUp(Stack<Employee> path, int d) {
        while (d > 0 && !path.isEmpty()) {
            path.pop();
            d--;
        }
    }
}
