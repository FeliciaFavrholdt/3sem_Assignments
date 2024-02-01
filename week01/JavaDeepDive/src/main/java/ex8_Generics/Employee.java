package ex8_Generics;

public class Employee {
    //attributes
    private String name;
    private int age;

    //constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //no-args constructor
    public Employee() {
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString method

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}