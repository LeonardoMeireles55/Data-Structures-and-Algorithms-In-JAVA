package MyHash;

public class MyHashMap<K, V> {
    private class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double LOAD_FACTOR = 0.75;
    private int capacity;
    private int size;
    private Pair<K, V> [] map;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new Pair[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void rehash() {
        int newSize = capacity * 2;
        Pair[] oldMap = map;
        map = new Pair[newSize];
        capacity = newSize;
        size = 0;

        for (Pair<K, V> pair : oldMap) {
            if (pair != null) {
                put(pair.key, pair.value);
            }
        }
    }

    public void put(K key, V value) {
        if ((double) size / capacity >= LOAD_FACTOR) {
            rehash();
        }

        int index = hash(key);
        while (map[index] != null && map[index].key != key) {
            index = (index + 1) % capacity;
        }
        if (map[index] == null) {
            map[index] = new Pair(key, value);
            size++;
        } else {
            map[index].value = value;
        }
    }

    public V get(K key) {
        int index = hash(key);
        while (map[index] != null) {
            if (map[index].key.equals(key)) {
                System.out.println("Key: " + key + " Value: " + map[index].value);
                return map[index].value;
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    public boolean contains(K key) {
        int index = hash(key);
        while (map[index] != null) {
            if (map[index].key == key) {
                return true;
            }
            index = (index + 1) % capacity;
        }
        return false;
    }
}