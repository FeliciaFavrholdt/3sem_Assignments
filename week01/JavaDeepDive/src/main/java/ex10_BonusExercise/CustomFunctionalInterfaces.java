package ex10_BonusExercise;

public class CustomFunctionalInterfaces {

    //10.6 Custom Functional Interfaces:
    //Define custom functional interfaces to represent various operations. For example, you could define an interface for filtering employees based on a certain condition.
    @FunctionalInterface
    interface EmployeeFilter {
        boolean filter(Employee employee);
    }




}
