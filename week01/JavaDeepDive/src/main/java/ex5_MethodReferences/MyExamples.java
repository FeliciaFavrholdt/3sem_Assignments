package ex5_MethodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyExamples implements MyTransformingType, MyValidatingType {

    /*
    The methods defined in Step 2 "Functional Programming" can be implemented using
    method references. Implement them using method references. E.g. Create a named
    method that doubles a value and use this method as a method reference:
    MyTransformingType doubleValue = (x) -> x * 2; in your map function.
    */

    public static void main(String[] args) {

        //Create an array of numbers
        List<Integer> myArray = Arrays.asList(7, 10, 15, 60, 5);

        //Using method reference
        List<Integer> doubledValues = mapArray(myArray, x -> doubleValue(x, 2)); //output: [14, 20, 30, 120, 10]
        List<Integer> multipliedValues = mapArray(myArray, x -> multiplyByThree(x, 3)); //output: [21, 30, 45, 180, 15]
        List<Integer> filteredValues = validateArray(myArray, x -> isDivisibleByThree(x, 3)); //output: [15, 60]
        List<Integer> positiveValues = validateArray(myArray, x -> isPositive(x, 0)); //output: [7, 10, 15, 60, 5]

        //Example of method reference using variables
        System.out.println("x is bigger than y: " + isPositive(5, 0)); //output: true
        System.out.println("x is divisible by y: " + isDivisibleByThree(77, 3)); //output: false
        System.out.println("--------------------------------------------------");

        //Output arrays:
        printArray("Original array: ", myArray);
        printArray("Doubled array: ", doubledValues);
        printArray("Multiplied array: ", multipliedValues);
        printArray("Filtered array: ", filteredValues);
        printArray("Positive array: ", positiveValues);
    }

    //Method to double a number
    private static int doubleValue(int x, int y) {
        return x * y;
    }

    //Method to multiply a number by three
    private static int multiplyByThree(int x, int y) {
        return x * y;
    }

    //Method to check if a number is divisible by three
    private static boolean isDivisibleByThree(int x, int y) {
        return x % y == 0;
    }

    private static boolean isPositive(int x, int y) {
        return x > y;
    }

    //Method to perform mapping operation on an array
    private static List<Integer> mapArray(List<Integer> myArray, MyTransformingType op) {
        return myArray.stream()
                .map(op::transform)
                .collect(Collectors.toList());
    }

    //Method to perform filtering operation on an array
    private static List<Integer> validateArray(List<Integer> myArray, MyValidatingType op) {
        return myArray.stream()
                .filter(op::validate)
                .collect(Collectors.toList());
    }

    private static void printArray(String message, List<Integer> array) {
        System.out.println(message);
        System.out.println(array);
        System.out.println("--------------------------------------------------");
    }

    @Override
    public int transform(int value) {
        return 0;
    }

    @Override
    public boolean validate(int value) {
        return false;
    }
}