package taskTwo_FunctionalProgramming;

public class MyExamples implements MyTransformingType, MyValidatingType {

    public static void main(String[] args) {
        //Task 2.3 - implementation - functional programming

        // Implementing methods using lambda expressions
        MyTransformingType addTwo = (x) -> x + 2;
        MyTransformingType multiplyByThree = (x) -> x * 3;

        MyValidatingType isDivisibleByThree = (x) -> x % 3 == 0;
        MyValidatingType isPositive = (x) -> x > 0;

        // print out the results of the lambda expressions
        System.out.println(addTwo.transform(5));
        System.out.println(multiplyByThree.transform(5));

        System.out.println(isDivisibleByThree.validate(5));
        System.out.println(isPositive.validate(5));

        System.out.println("--------------------------------------------------");

        // Create an array of numbers
        int[] myArray = {100, 32, 43, 674, 5};
        int[] arrayWithThrees = {3, 10, 9, 18, 67, 100, 88, 30, 90};

        // Map operation: doubling each value
        int[] doubledArray = map(myArray, (x) -> x * 2);

        // Print out the doubled array
        System.out.println("Doubled Array:");
        for (int num : doubledArray) {
            System.out.print(num + "\n");
        }

        System.out.println("--------------------------------------------------");

        // Adds two to each element in the array
        int[] arrayOne = map(myArray, addTwo);
        for (int i : arrayOne) {
            System.out.println(i);
        }

        System.out.println("--------------------------------------------------");

        // Filters out all elements that are not divisible by three
        System.out.println("Following numbers are divisible by three: ");

        int[] arrayTwo = filter(arrayWithThrees, isDivisibleByThree);
        for (int i: arrayTwo) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }

    // Method to perform mapping operation on an array
    private static int[] map(int[] a, MyTransformingType op) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = op.transform(a[i]);
        }
        return result;
    }

    // Method to perform filtering operation on an array
    private static int[] filter(int[] a, MyValidatingType op) {
        int[] array = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            boolean result = op.validate(a[i]);
            if (result == true) {
                array[i] = a[i];
            }
        }
        return array;
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