package ex10_BonusExercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class DataCollection {

    public static void main(String[] args) {
        System.out.println(createEmployees());
        System.out.println("-------------------");

        //10.4 Data Analysis - Implement the following tasks using lambda expressions and streams:

        //Calculate the average age of all employees
        createEmployees().stream()
                .mapToInt(Employee::getAge)
                .average()
                .ifPresent(employee -> System.out.println("Average age of all employees: " + employee));
        System.out.println("-------------------");

        //Find the employee with the highest salary
        System.out.println("The employee with the highest salary is: ");
        createEmployees().stream()
                .max((employee1, employee2) -> (int) (employee1.getSalary() - employee2.getSalary()))
                .ifPresent(employee -> System.out.println(employee.getName() + " - " + employee.getSalary()));
        System.out.println("-------------------");

        //Group employees by department and calculate the average salary for each department
        createEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((department, salary) -> System.out.println("Department " + department + "\nAverage salary: " + salary + "\n"));
        System.out.println("-------------------");

        //Count the number of employees in each department
        createEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((department, count) -> System.out.println("Department " + department + "\nNumber of employees: " + count + "\n"));
        System.out.println("-------------------");

        //Find the three oldest employees
        System.out.println("The three oldest employees are: ");
        createEmployees().stream()
                .sorted((employee1, employee2) -> employee2.getAge() - employee1.getAge())
                .limit(3)
                .forEach(employee -> System.out.println(employee.getName() + " aged " + employee.getAge()));
        System.out.println("-------------------");

        //Filter and display employees whose salary is above a certain threshold
        long threshold = 50000;
        boolean match = createEmployees().stream()
                .anyMatch(employee -> employee.getSalary() > threshold);
        System.out.println("Employees with a salary above 50.000: ");
        createEmployees().stream()
                .filter(employee -> employee.getSalary() > 50000)
                .forEach(employee -> System.out.println(employee.getName() + " - " + employee.getSalary()));


        System.out.println("-------------------");

        // 10.5 Sorting - Use the sorted method to sort employees based on different criteria, such as age, salary, or name.
        // Sort employees by age
        createEmployees().stream()
                .sorted((employee1, employee2) -> employee1.getAge() - employee2.getAge())
                .forEach(employee -> System.out.println(employee.getName() + " - " + employee.getAge()));
        System.out.println("-------------------");

        // Sort employees by salary
        createEmployees().stream()
                .sorted((employee1, employee2) -> (int) (employee1.getSalary() - employee2.getSalary()))
                .forEach(employee -> System.out.println(employee.getName() + " - " + employee.getSalary()));

        System.out.println("-------------------");

        // Sort employees by name
        createEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(employee -> System.out.println(employee.getName() + " - " + employee.getSalary()));


        //10.7 Advanced Operations:
        /* Implement more complex operations, such as:
        Combine multiple streams or operations.
        Transform data, such as calculating bonuses based on employee performance.
        Handle cases where some attributes might be missing (use Optional to handle null values).*/
    }

    //10.3 Create a collection of Employee objects to work with. You can either create a sample dataset or read data from a file or database.
    //Method to create a collection of Employee objects in an ArrayList
    private static Collection<Employee> createEmployees() {
        Collection<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rikke", 44, "IT", 51000));
        employees.add(new Employee("Marie", 33, "HR", 27000));
        employees.add(new Employee("Søren", 28, "SALES", 17000));
        employees.add(new Employee("Lars", 40, "PR", 50300));
        employees.add(new Employee("Lars", 22, "PR", 22100));
        employees.add(new Employee("Kenneth", 45, "IT", 93000));
        employees.add(new Employee("Mark", 50, "IT", 100000));
        return employees;
    }

}
