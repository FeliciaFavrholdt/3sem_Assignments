package fridayReviewExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {

    public static void main(String[] args) {

        //FUNCTIONAL PROGRAMMING - A PROGRAMMING PARADIGM
        /* a programming paradigm is a style of building the structure and elements of computer programs
        that provides a way of designing solutions to problems using some programming language or other
        kinds of computer languages */

        //Create new person objects
        Person a = new Person("Alma", 20);
        Person b = new Person("Benjamin", 30);
        Person c = new Person("Caroline", 40);
        Person d = new Person("Daniel", 50);

        //parse into a list
        List<Person> personList = List.of(a, b, c, d);

        //lambda expression syntax - (parameters) -> {body}
        personList.forEach(person -> System.out.println(person));

        //method reference syntax - Classname :: methodName
        personList.forEach(System.out::println);

        personList.stream()
                .map(person -> person.getAge())
                .forEach(System.out::println);

        //method references are typically used to replace lambda expressions that simply call a method
        personList.stream()
                .map(Person::getAge)
                .forEach(System.out::println);

        //method references can also be used to call a constructor
        List<String> names = Arrays.asList("Alma", "Benjamin", "Caroline", "Daniel");

        List<Person> newPersonList = names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        List<Person> newPersonList2 = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        //method references can also be used to call from a class instance
        personList.forEach(a::printName);

        // LIMITATIONS OF FUNCTIONAL PROGRAMMING IN JAVA 8
        /* we must parse the exact object that we want and we must
         return the object or void */

        // WHEN TO USE LAMBDA EXPRESSIONS
        /* to define more logic and to make the code more readable */
        /* opportunity to define your own parameters */

        // WHEN TO USE METHOD REFERENCES
        /* to call a method that already exists */
        /* to call a constructor */
        /* to call from a class instance */




        // EXAMPLES
        //print list of numbers
        printAllNumbersInList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        printAllNumbersInList2(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int compare = FunctionalProgramming.compareNumber(20, 10);
        System.out.println("compare number: " + compare);

        Comparator<Integer> comparator = (x, y) -> compareNumber(x, y);
        System.out.println("compare number using lambda: " + comparator.compare(20, 10));
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        void doSomething();
    }


    //Java 8 lambda expressions

    //Java 8 method references: static, instance, constructor

    public static int compareNumber(int x, int y) {
        return Integer.compare(x, y); // x is greater than y -> 1, x is less than y -> -1, x is equal to y -> 0
    }

    //Classname :: methodName


    //Java 8 default and static interface methods


    private static void printAllNumbersInList(List<Integer> numbers) {
        //loop the numbers - structured programming
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("-------------");
    }

    private static void printAllNumbersInList2(List<Integer> numbers) {
        //converting list into a stream of numbers - functional programming
        numbers.stream()
                //looping the stream of numbers
                .forEach(number -> System.out.println(number + " "));
    }
}
