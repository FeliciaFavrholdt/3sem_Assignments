package taskTwo_FunctionalProgramming;

//Task 2.2 - Functional programming

// Functional interface for validating integer values
@FunctionalInterface
interface MyValidatingType {
    boolean validate(int value);
}