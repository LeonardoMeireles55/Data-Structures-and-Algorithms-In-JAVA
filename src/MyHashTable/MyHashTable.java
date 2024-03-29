package MyHashTable;

public class MyHashTable {
    private final int size;
    private final int[] table;
    static final double A = 0.63274838;

    public MyHashTable(int size) {
        this.size = size;
        table = new int[size * 100];
    }

    public void insert(int value) {
        double index = (((value * A) % 1) * size);
        while (table[((int) index)] != 0) {
            index = (index + 1) * size;
        }
        table[(int) index] = value;
    }

    public void delete(int value) {
        int index = (int) (((value * A) % 1) * size);
        while (table[index] != value) {
            index = (index + 1) % size;
        }
        table[index] = 0;
    }

    public String search(int value) {
        double index = (((value * A) % 1) * size);
        while (table[(int) index] != value) {
            index = (index + 1) % size;
            if (table[(int) index] == 0) {
                return "Not Found";
            }
        }
        return "Found at index: " + (int) index + " Value: " + table[(int) index];
    }

    // public void print() {
    //     for (int i = 0; i < size; i++) {
    //         System.out.println("Index: " + i + " Value: " + table[i]);
    //     }
    // }

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
        ht.insert(100);
        // ht.print();

        System.out.println(ht.search(25));
    }
}
