package fridayReviewExamples;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Examples {

    /*
    - What is functional programming and how to use it in Java 8.
    - Illustrate principles of functional programming. Show examples of:
    * Java 8 functional interfaces
    * Java 8 labmda expressions
    * Java 8 method references: static, instance, constructor
    * Java 8 default and static interface methods
     */

    //FUNCTIONAL INTERFACE - an interface with only one abstract method
    @FunctionalInterface
    interface MyFunctionalInterface {
        void myMethod();
    }

    public static void main(String[] args) {

        //FUNCTIONAL INTERFACES - built-in functional interfaces
        //Function - takes one argument and returns a result
        Function<String, Integer> toInteger = Integer::valueOf;
        Integer integer = toInteger.apply("12345");
        System.out.println(integer);

        //BiFunction - takes two arguments and returns a result
        BiFunction<String, String, String> concat = (s1, str) -> s1.concat(str);
        String result = concat.apply("Vi ", "Ses!");
        System.out.println(result);

        //Consumer - takes one argument and returns no result
        Consumer<String> print = System.out::println;

        //Predicate - takes one argument and returns a boolean
        Predicate<String> startsWithA = (s) -> s.startsWith("A");
        boolean isTrue = startsWithA.test("A");
        System.out.println(isTrue);

        //Supplier - takes no arguments and returns a result
        Supplier<String> supplier = String::new;
        String newString = supplier.get();
        System.out.println(newString);

        //LAMBDA EXPRESSIONS

        //EXAMPLE 1
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Hello World");
        myFunctionalInterface.myMethod();

        //EXAMPLE 2
        Function<String, Integer> stringToInteger = (s) -> Integer.valueOf(s);
        Integer integerLambda = stringToInteger.apply("123");
        System.out.println(integerLambda);

        //STREAM API
        //Filter
        List<String> list = List.of("Abe", "Banan", "C", "Dyr", "Elefant");

        //imperative approach
        for (String s : list) {
            if (s.startsWith("A")) {
                System.out.println(s);
            }
        }

        //declarative approach
        list.stream().filter(s -> s.startsWith("D")).forEach(System.out::println);

        //Map
        List<Integer> listInt = List.of(1, 2, 3, 4, 5);

        //imperative approach
        for (int i : listInt) {
            System.out.println(i * 2);
        }

        //declarative approach
        listInt.stream().map(i -> i * 2).forEach(System.out::println);

        //Reduce
        List<Person> personList = List.of(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Jack", 35)
        );

        //imperative approach
        int age = 0;
        for (Person p : personList) {
            age += p.getAge();
        }
        System.out.println(age);

        //declarative approach
        int sum = listInt.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        //Find first

        //imperative approach
        Person person1 = null;
        for (Person p : personList) {
            if (p.getName().startsWith("J")) {
                person1 = p;
                break;
            }
        }
        System.out.println(person1);

        //declarative approach
        Person person = personList.stream().filter(p -> p.getName().startsWith("J")).findFirst().orElse(null);
        System.out.println(person);

        //METHOD REFERENCES
        //Static method reference
        Function<String, Integer> toIntegerStatic = Integer::valueOf;
        Integer integerStatic = toIntegerStatic.apply("123");
        System.out.println(integerStatic);

        //Instance method reference
        String string = "Hello World";
        Consumer<String> printInstance = System.out::println;
        printInstance.accept(string);

        //Constructor method reference
        Supplier<String> supplierConstructor = String::new;
        String newStringConstructor = supplierConstructor.get();
        System.out.println(newStringConstructor);
    }
}