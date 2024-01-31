package ex3_FunctionalInterfaces;

    public class Employee {

        //instance variables
        private String name;
        private int age;

        //no-arg constructor
        public Employee() {
        }

        //constructor with name parameter
        public Employee(String name){
            this.name = name;
        }

        //constructor with name and age parameter
        public Employee(String name, int age){
            this.name = name;
            this.age = age;
        }

        //getters and setters
        public String getName() {
            return name;
        }

        public int getAge(){return age;}

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age){this.age = age;}

        //toString method
        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
    }
}