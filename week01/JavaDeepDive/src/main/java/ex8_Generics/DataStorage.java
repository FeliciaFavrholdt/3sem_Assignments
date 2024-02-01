package ex8_Generics;

//8.1 Create a Generic Storage Interface: Create a generic interface called DataStorage<T> that defines methods for storing and retrieving data of type T.

public interface DataStorage<T> {
    String store(T data); // return a unique ID for the stored data or the filename
    T retrieve(String source); // retrieve data from the specified source (like a file or database table or ID)
}