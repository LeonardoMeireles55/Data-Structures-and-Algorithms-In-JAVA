package MyHash;

import java.util.Arrays;

import MySort.MySort;

public class MyHashTable {
    public int size;
    public int[] table;
    public int[] finalList;
    public double loadFactor = 0.75;
    public static final double A = 0.63274838;
    public MySort mySort;

    public int getSize() {
        return size;
    }

    public static int hash(int value, int size) {
        return (int) (((value * A) % 1) * size);
    }

    public MyHashTable(int size) {
        this.size = 0;
        this.table = new int[size];
    }

    public void rehash() {
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

    public void sortedPrint() {
        mySort = new MySort(table.length);
        int aux[] = new int[table.length];
        int auxCounter = 0;
        int helper = 0;

        for (int i = 0; i < table.length; i++) {
            if(table[i] != 0) {
                auxCounter++;
                mySort.myList[i] = table[i];
            }
            if(i == table.length - 1) {
                finalList = new int[auxCounter];
                mySort.myMergeSort(mySort.myList, aux, 0, mySort.myList.length - 1);
                for(int j = 0; j < mySort.myList.length; j++) {
                    if(mySort.myList[j] != 0) {
                        finalList[helper] = mySort.myList[j];
                        helper++;
                    }
                }
            }
        }
        System.out.println("Sorted List:");
        System.out.println(Arrays.toString(finalList));
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
