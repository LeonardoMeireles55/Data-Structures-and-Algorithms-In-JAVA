package MyHashTable;

public class MyHashTable {
    private int size;
    private int[] table;
    private double loadFactor = 0.75;
    static final double A = 0.63274838;

    public int getSize() {
        return size;
    }

    private static int hash(int value, int size) {
        return (int) (((value * A) % 1) * size);
    }

    public MyHashTable(int size) {
        this.size = 0;
        this.table = new int[size];
    }

    private void rehash() {
        int[] oldTable = table;
        table = new int[table.length * 2];
        for (int i = 0; i < oldTable.length; i++) {
            int value = oldTable[i];
            if (value != 0) {
                insert(value);
            }
        }
    }

    public void insert(int value) {
        int sondage = 0;
        int index = hash((value + sondage), table.length);
        if (table[index] == value) {
            table[index] = value;
            size++;
            return;
        }
        while (table[index] != 0) {
            sondage++;
            System.out.println("Collision at index " + index +
             ", inserting with sondage " + sondage);
            index = hash((value + sondage), table.length);
        }
        table[index] = value;
        size++;

        if ((double) size / table.length >= loadFactor) {
            System.out.println("Resize and Rehashing");
            rehash();
        }
    }

    public void delete(int value) {
        int sondage = 0;
        int index = hash((value + sondage), table.length);
        if (table[index] == value) {
            table[index] = 0;
            size--;
            return;
        }
        while (table[index] != value) {
            sondage++;
            System.out.println("deleting with sondage " + sondage);
            index = hash((value + sondage), table.length);
            if (table[index] == 0 || sondage >= table.length) {
                return;
            }
        }
    }

    public String search(int value) {
        int sondage = 0;
        int index = hash((value + sondage), table.length);
        while (table[index] != value) {
            sondage++;
            System.out.println("searching with sondage " + sondage);
            index = hash((value + sondage), table.length);
            if (table[index] == 0 || sondage >= table.length) {
                return "Not found";
            }
        }
        return "Found" + " at index " + index + " with sondage " + sondage + " value " + table[index];
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                System.out.println("Index: " + i + " Value: " + table[i]);
            }
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
        ht.insert(100);
        ht.insert(45);
        ht.insert(45);
        ht.insert(45);
        ht.delete(100);

        ht.print();

        System.out.println(ht.search(10));
        System.out.println(ht.getSize());
        System.out.println(ht.table.length);
    }
}
