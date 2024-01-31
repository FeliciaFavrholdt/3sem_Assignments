package ex2_FunctionalProgramming;

//2.1 - Functional programming

//Functional interface for transforming integer values
@FunctionalInterface
interface MyTransformingType {
    int transform(int value);
}