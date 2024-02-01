package ex8_Generics;

import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class FileStorage<T> implements DataStorage<T> {
    private FileWriter fileWriter;

    FileStorage<T> storage = new FileStorage<>();

    @Override
    public String store(T data) {
        if(data != null) {
            storage.store(data);
        }
        return null;
    }

    @Override
    public T retrieve(String source) {
        return storage.retrieve(source);
    }
}
