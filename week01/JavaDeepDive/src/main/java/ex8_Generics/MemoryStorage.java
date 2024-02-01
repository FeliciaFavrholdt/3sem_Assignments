package ex8_Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemoryStorage<T> implements DataStorage<T> {


    @Override
    public String store(T data) {
        return null;
    }

    @Override
    public T retrieve(String source) {
        return null;
    }
}