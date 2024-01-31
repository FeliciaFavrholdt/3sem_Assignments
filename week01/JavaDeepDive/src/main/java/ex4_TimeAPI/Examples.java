package ex4_TimeAPI;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        //4.1 Calculate the age of each employee based on their birthdate - see Employee.java
        calculateAgeFromBirthdate(employees);

        //4.2 Calculate the average age of all employees
        double averageAge = getAverageAge(employees);
        System.out.println("-------------------");
        System.out.println("Average age of all employees: " + averageAge + " years old");

        //4.3 Filter and display employees who have birthdays in a specific month.

        //Displays list of employees with birthdays in a random month
        getEmployeeListByRandomMonth(employees);

        System.out.println("-------------------");

        //Displays list of employees with birthdays in the current month
        getEmployeeListBySpecificMonth(employees);

        System.out.println("-------------------");

        //4.4 Group employees by birth month and display the count of employees in each group.
        Map<Month, Long> employeesByBirthMonth = groupEmployeeByBirthMonth(employees);

        System.out.println("Count of employees by birth month:");
        employeesByBirthMonth.forEach((month, count) ->
                System.out.println(month + ": " + count + " - " + employees.stream()
                        .filter(employee -> employee.getBirthDate().getMonth() == month)
                        .map(Employee::getName)
                        .collect(Collectors.joining(", ")))); // "joining" is a "collector

        //4.5  all employees who has a birthday in the current month.
        getAllEmployeesByCurrentMonth(employees);
    }

    private static Map<Month, Long> groupEmployeeByBirthMonth(List<Employee> employees) {
        Map<Month, Long> employeesByBirthMonth = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.getBirthDate().getMonth(),
                        Collectors.counting()
                ));
        return employeesByBirthMonth;
    }

    private static void getAllEmployeesByCurrentMonth(List<Employee> employees) {
        Month currentMonth = LocalDate.now().getMonth();
        List<Employee> employeesWithCurrentMonthBirthday = employees.stream()
                .filter(employee -> employee.getBirthDate().getMonth() == currentMonth)
                .collect(Collectors.toList());

        System.out.println("-------------------");
        System.out.println("Employees with birthdays in the current month:");
        employeesWithCurrentMonthBirthday.forEach(employee ->
                System.out.println(employee.getName() + ": " + employee.getBirthDate()));
    }

    private static void getEmployeeListBySpecificMonth(List<Employee> employees) {
        Month specificMonth = Month.JUNE;
        List<Employee> employeesInSpecificMonth = employees.stream()
                .filter(employee -> employee.getBirthDate().getMonth() == specificMonth)
                .toList();
        System.out.println("Employees with birthdays in " + specificMonth + ":");
        employeesInSpecificMonth.forEach(employee ->
                System.out.printf(employee.getName() + ": " + employee.getBirthDate() + "\n"));
    }

    private static void getEmployeeListByRandomMonth(List<Employee> employees) {
        Random random = new Random();
        Month randomMonth = Month.values()[random.nextInt(Month.values().length)];

        List<Employee> employeesInSpecificMonth = employees.stream()
                .filter(employee -> employee.getBirthDate().getMonth() == randomMonth)
                .toList();
        System.out.println("Employees with birthdays in " + randomMonth + ":");
        employeesInSpecificMonth.forEach(employee ->
                System.out.printf(employee.getName() + ": " + employee.getBirthDate() + "\n"));
    }

    private static List<Employee> getEmployees() {
        return List.of(
                new Employee("Rikke", LocalDate.of(1972, Month.JUNE, 2)),
                new Employee("Julie", LocalDate.of(1900, Month.JUNE, 22)),
                new Employee("Birgitte", LocalDate.of(1952, Month.JUNE, 7)),
                new Employee("Hans", LocalDate.of(1947, Month.MARCH, 12)),
                new Employee("Mads", LocalDate.of(1995, Month.JULY, 22)),
                new Employee("Kaj", LocalDate.of(1941, Month.JANUARY, 18)),
                new Employee("Tobias", LocalDate.of(1996, Month.FEBRUARY, 1)),
                new Employee("Sarah", LocalDate.of(2009, Month.DECEMBER, 15))
        );
    }

    private static void calculateAgeFromBirthdate(List<Employee> employees) {
        employees.stream()
                .forEach(employee -> System.out.println(
                        employee.getName() + " is " + employee.calculateAge() + " years old"));
    }

    private static double getAverageAge(List<Employee> employees) {
        double averageAge = employees.stream()
                .mapToInt(Employee::calculateAge)
                .average()
                .orElse(0);
        return averageAge;
    }
}