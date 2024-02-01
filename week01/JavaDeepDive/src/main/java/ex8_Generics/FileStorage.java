package ex8_Generics;

import java.io.ObjectOutputStream;

public class FileStorage<T> implements DataStorage<T> {

    public FileStorage(String file) {
    }

    @Override
    public String store(T data) {
        return null;
    }

    @Override
    public T retrieve(String source) {
        return null;
    }
}
