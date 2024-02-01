package ex8_Generics;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemoryStorage<T> implements DataStorage<T> {

    private Map<String, T> map;

    public MemoryStorage() {
        map = new HashMap<>();
    }

    @Override
    public String store(T data) {
        String id = UUID.randomUUID().toString(); // Generate unique ID
        map.put(id, data);
        return id;
    }

    @Override
    public T retrieve(String id) {
        return map.get(id);
    }
}