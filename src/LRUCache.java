import java.util.LinkedHashMap;
import java.util.Set;

public class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int val = cache.remove(key);
            cache.put(key, val);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }

        if (cache.size() == capacity) {
            Set<Integer> keySet = cache.keySet();
            int leastRecentlyUsed = keySet.iterator().next();
            cache.remove(leastRecentlyUsed);
        }

        cache.put(key, val);
    }

    public int size() {
        return cache.size();
    }
}
