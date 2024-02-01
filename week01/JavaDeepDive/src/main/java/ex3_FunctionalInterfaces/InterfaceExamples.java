package ex3_FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceExamples {

    public static void main(String[] args) {

        //Examples of functional interfaces in Java 8 (see commented out code below)
        /*
        //Consumer - takes in a value and returns nothing
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello World!");

        //Supplier - returns a value
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());

        //Function - takes in a value and returns a value
        Function<String, Integer> function = (x) -> x.length();
        System.out.println(function.apply("Hello World!"));

        //Predicate - returns true or false
        Predicate<String> predicate = (x) -> x.length() > 10;
        System.out.println(predicate.test("Hello World!"));
        */

        //3.1 Use predicate to filter a list of integers, so only those divisible by 7 remain
        List<Integer> numbers = Arrays.asList(14, 921, 365, 40, 44, 49, 50, 700);
        Predicate<Integer> isDivisibleBySeven = num -> num % 7 == 0;

        System.out.println("Numbers divisible by 7:" + numbers.stream()
                .filter(isDivisibleBySeven)
                .toList());

        //3.2 Use Supplier to create a list of Employee objects based on a list of names like Arrays.asList("John", "Jane", "Jack", "Joe", "Jill")
        Supplier<List<Employee>> createEmployees = getListSupplier();

        //3.3 Use Consumer to print the list of Employee objects
        Consumer<List<Employee>> printEmployees = (employees) -> {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        };

        printEmployees.accept(createEmployees.get());

        //3.4 Use Function to convert a list of Employee objects to a list of names
        Function<List<Employee>, List<String>> convertToNames = convertObjectsToListOfNames();
        System.out.println("Names: " + convertToNames.apply(createEmployees.get()));

        //3.5 Use Predicate to check if a given employee is older than 18
        Predicate<Employee> isOlderThan = (a) -> a.getAge() > 18;
        System.out.println("Is older than 18? " + isOlderThan.test(createEmployees.get().get(0)));
    }

    private static Supplier<List<Employee>> getListSupplier() {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");

        Supplier<List<Employee>> createEmployees = () -> {
            List<Employee> employees = new ArrayList<>();
            for (String name : names) {
                employees.add(new Employee(name, new Random().nextInt(80)));
            }
            return employees;
        };
        return createEmployees;
    }

    private static List<Employee> ageCheck(List<Employee> employees, Predicate<Employee> isOlderThan) {
        List<Employee> olderThan18 = new ArrayList<>();
        for (Employee emp : employees) {
            if (isOlderThan.test(emp)) {
                olderThan18.add(emp);
            }
        }
        return olderThan18;
    }

    private static Function<List<Employee>, List<String>> convertObjectsToListOfNames() {
        Function<List<Employee>, List<String>> convertToNames = employees -> {
            List<String> namesList = new ArrayList<>();
            for (Employee emp : employees) {
                namesList.add(emp.getName());
            }
            return namesList;
        };
        return convertToNames;
    }
}