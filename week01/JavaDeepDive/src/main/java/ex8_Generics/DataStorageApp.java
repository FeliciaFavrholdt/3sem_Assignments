package ex8_Generics;

//8.3 In the main application, create instances of each storage class and demonstrate their usage by storing and retrieving data of different types.

public class DataStorageApp {
    public static void main(String[] args) {

        //8.3 demonstrate their usage by storing and retrieving data of different types
        //MemoryStorage
        MemoryStorage<String> memoryStorage = new MemoryStorage<>();
        memoryStorage.store("Some data goes here");
        String retrievedString = memoryStorage.retrieve(null);
        System.out.println(retrievedString);

        //FileStorage
        FileStorage<Employee> fileStorage = new FileStorage<>();
        String filename = fileStorage.store(new Employee("John", 30));
        Employee retrievedInt = fileStorage.retrieve(filename);
        System.out.println(retrievedInt);

        //DatabaseStorage
        DatabaseStorage<Double> databaseStorage = new DatabaseStorage<>();
        databaseStorage.store(3.14);
        Double retrievedDouble = databaseStorage.retrieve("3.14");
        System.out.println(retrievedDouble);
    }
}