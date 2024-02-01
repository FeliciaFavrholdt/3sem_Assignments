package ex8_Generics;

public class DatabaseStorage<T> implements DataStorage<T> {
    @Override
    public String store(T data) {
        return null;
    }

    @Override
    public T retrieve(String source) {
        return null;
    }
}
