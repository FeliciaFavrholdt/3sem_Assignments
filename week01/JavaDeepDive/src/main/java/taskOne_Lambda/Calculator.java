package taskOne_Lambda;

import java.util.Arrays;

public class Calculator implements ArithmeticOperation {

    public static void main(String[] args) {

        //Alternative way to create lambda expressions

       /* ArithmeticOperation addition = (a, b) -> {
            return Math.addExact(a, b);
        };*/

        //Lambda expressions to calculate the sum, difference, product, quotient, modulus, and power of two numbers
        ArithmeticOperation addition = (a, b) -> a + b;
        ArithmeticOperation subtraction = (a, b) -> a - b;
        ArithmeticOperation multiplication = (a, b) -> a * b;
        ArithmeticOperation division = (a, b) -> a / b;
        ArithmeticOperation modulus = (a, b) -> a % b;
        ArithmeticOperation power = (a, b) -> (int) Math.pow(a, b);

        //Lambda expressions in an array
        ArithmeticOperation[] operationsArray = {addition, subtraction, multiplication, division, modulus, power};

        //Loop through the array of operations and print the result of each operation
        /* for (ArithmeticOperation o : operationsArray) {
            System.out.println("result: " + operate(5, 3, o));
        }*/
        Arrays.stream(operationsArray).map(o -> "result: " + operate(5, 3, o)).forEach(System.out::println);
        System.out.println("---------------------------------");

        //Test lambda expressions
        System.out.println("Addition: " + addition.perform(5, 3)); // Output: 8
        System.out.println("Subtraction: " + subtraction.perform(5, 3)); // Output: 2
        System.out.println("Multiplication: " + multiplication.perform(5, 3)); // Output: 15
        System.out.println("Division: " + division.perform(5, 3)); // Output: 1
        System.out.println("Modulus: " + modulus.perform(5, 3)); // Output: 2
        System.out.println("Power: " + power.perform(5, 3)); // Output: 125
        System.out.println("---------------------------------");

        //Test operate method
        System.out.println("Operate result - addition: " + operate(5, 3, addition)); // Output: 8
        System.out.println("Operate result - subtraction: " + operate(5, 3, subtraction)); // Output: 2
        System.out.println("Operate result - multiplication: " + operate(5, 3, multiplication)); // Output: 15
        System.out.println("Operate result - division: " + operate(5, 3, division)); // Output: 1
        System.out.println("Operate result - modulus: " + operate(5, 3, modulus)); // Output: 2
        System.out.println("Operate result - power: " + operate(5, 3, power)); // Output: 125
        System.out.println("---------------------------------");

        //Arrays for testing
        int[] a = {10, 20, 30, 40, 50};
        int[] b = {5, 4, 3, 2, 1};

        //Loops through the array of operations and print the result of each operation
        OperationResultByArray(operationsArray, a, b);
        System.out.println("---------------------------------");

        System.out.println("Addition: " + Arrays.toString(operate(a, b, addition))); // Output: [15, 24, 33, 42, 51]
        System.out.println("Subtraction: " + Arrays.toString(operate(a, b, subtraction))); // Output: [5, 16, 27, 38, 49]
        System.out.println("Multiplication: " + Arrays.toString(operate(a, b, multiplication))); // Output: [50, 80, 90, 80, 50]
        System.out.println("Division: " + Arrays.toString(operate(a, b, division))); // Output: [2, 5, 10, 20, 50]
        System.out.println("Modulus: " + Arrays.toString(operate(a, b, modulus))); // Output: [0, 0, 0, 0, 0]
        System.out.println("Power: " + Arrays.toString(operate(a, b, power))); // Output: [100000, 160000, 27000, 1600, 50]
        System.out.println("---------------------------------");

    }

    private static void OperationResultByArray (ArithmeticOperation[] op, int[] a, int[] b) {
        for (ArithmeticOperation o : op) {
            System.out.println("result: " + Arrays.toString(operate(a, b, o)));
        }
    }

    private static int operate(int a, int b, ArithmeticOperation operation) {
        return operation.perform(a, b);
    }

    private static int[] operate(int[] a, int[] b, ArithmeticOperation operation) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array lengths must be equal");
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = operate(a[i], b[i], operation);
        }
        return result;
    }

    @Override
    public int perform(int a, int b) {
        return 0;
    }
}