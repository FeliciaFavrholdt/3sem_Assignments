package ex8_Generics;

//8.3 In the main application, create instances of each storage class and demonstrate their usage by storing and retrieving data of different types.

public class DataStorageApp {
    public static void main(String[] args) {

        //instance of each storage class
        MemoryStorage<String> memoryStorage = new MemoryStorage<>();
        FileStorage<Integer> fileStorage = new FileStorage<>("file.txt");
        DatabaseStorage<Double> databaseStorage = new DatabaseStorage<>();

        //8.3 demonstrate their usage by storing and retrieving data of different types
        //MemoryStorage

        //FileStorage

        //DatabaseStorage

        // Create and demonstrate DatabaseStorage
    }
}