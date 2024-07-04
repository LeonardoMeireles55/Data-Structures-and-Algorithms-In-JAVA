package MyHash;

public class MyHashMap {
    private class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double LOAD_FACTOR = 0.75;
    private int size;
    private int used;
    private Pair[] map;

    public MyHashMap(int size) {
        this.size = size;
        this.used = 0;
        this.map = new Pair[size];
    }

    private int hash(int key) {
        return Math.abs(key % size);
    }

    private void rehash() {
        int newSize = size * 2;
        Pair[] oldMap = map;
        map = new Pair[newSize];
        size = newSize;
        used = 0;

        for (Pair pair : oldMap) {
            if (pair != null) {
                put(pair.key, pair.value);
            }
        }
    }

    public void put(int key, int value) {
        if ((double) used / size >= LOAD_FACTOR) {
            rehash();
        }

        int index = hash(key);
        while (map[index] != null && map[index].key != key) {
            index = (index + 1) % size;
        }
        if (map[index] == null) {
            map[index] = new Pair(key, value);
            used++;
        } else {
            map[index].value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        while (map[index] != null) {
            if (map[index].key == key) {
                return map[index].value;
            }
            index = (index + 1) % size;
        }
        return -1;
    }

    public boolean contains(int key) {
        int index = hash(key);
        while (map[index] != null) {
            if (map[index].key == key) {
                return true;
            }
            index = (index + 1) % size;
        }
        return false;
    }
}