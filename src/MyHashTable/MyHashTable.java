package MyHashTable;

public class MyHashTable {
    private final int size;
    private final int[] table;
    static final double A = 0.63274838;

    public MyHashTable(int size) {
        this.size = size;
        table = new int[size];
    }
    public void insert(int value) {
        int index = (int) (((value * A) % 1) * size);
        while (table[index] != 0) {
            index = (index + 1) % size;
        }
        table[index] = value;
    }
    public void delete(int value) {
        int index = (int) (((value * A) % 1) * size);
        while (table[index] != value) {
            index = (index + 1) % size;
        }
        table[index] = 0;
    }
    public boolean search(int value) {
        int index = (int) (((value * A) % 1) * size);
        while (table[index] != value) {
            index = (index + 1) % size;
            if (table[index] == 0) {
                return false;
            }
        }
        return true;
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index: " + i + " Value: " + table[i]);
        }
    }
    public static void main(String[] args) {
        MyHashTable ht = new MyHashTable(10);
        ht.insert(10);
        ht.insert(20);
        ht.insert(30);
        ht.insert(40);
        ht.insert(50);
        ht.insert(60);
        ht.insert(70);
        ht.insert(80);
        ht.insert(90);
        ht.insert(100);
        ht.print();
    }
}
