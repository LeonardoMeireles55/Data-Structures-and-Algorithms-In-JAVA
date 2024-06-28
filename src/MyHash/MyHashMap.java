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

    private int size;
    private Pair[] map;

    public MyHashMap(int size) {
        this.size = size;
        this.map = new Pair[size];
    }

    public int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        while (map[index] != null && map[index].key != key) {
            index = (index + 1) % size; // sondagem linear
        }
        map[index] = new Pair(key, value);
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
