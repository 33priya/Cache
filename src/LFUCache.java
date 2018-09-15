import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    private class CacheEntry {
        private int data;
        private int frequency;

        private CacheEntry(int data, int frequency) {
            this.data = data;
            this.frequency = frequency;
        }
    }

    private final LinkedHashMap<Integer, CacheEntry> cache;
    private final int capacity;

    LFUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheEntry temp = cache.get(key);
            temp.frequency++;
            cache.put(key, temp);
            return temp.data;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        if (cache.size() == capacity) {
            int leastRecentlyUsed = getLFUKey();
            cache.remove(leastRecentlyUsed);
            CacheEntry temp = new CacheEntry(val, 0);
            cache.put(key, temp);
        } else {
            if (cache.containsKey(key)) {
                CacheEntry temp = cache.get(key);
                temp.frequency++;
                cache.put(key, temp);
            } else {
                CacheEntry temp = new CacheEntry(val, 0);
                cache.put(key, temp);
            }
        }
    }

    private int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, CacheEntry> entry : cache.entrySet()) {
            if(minFreq > entry.getValue().frequency) {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    public int size() {
        return cache.size();
    }
}
