package MyHash;

import java.util.Arrays;

import MySort.MySort;

public class MyHashTable {
    public int size;
    public int[] table;
    public double loadFactor = 0.75;
    private static final double A = 0.63274838;

    public int getSize() {
        return this.size;
    }

    static int hash(int value, int size) {
        return (int) (((value * A) % 1) * size);
    }

    public MyHashTable(int size) {
        this.size = 0;
        this.table = new int[size];
    }

    void rehash() {
        int[] oldTable = this.table;
        this.table = new int[oldTable.length * 2];
        for (int i = 0; i < oldTable.length; i++) {
            int value = oldTable[i];
            if (value != 0) {
                this.insert(value);
            }
        }
    }

    public void insert(int value) {
        int sondage = 0;
        int index = hash((value + sondage), this.table.length);
        if (this.table[index] == value) {
            this.table[index] = value;
            this.size++;
            return;
        }
        while (this.table[index] != 0) {
            sondage++;
            // System.out.println("Collision at index " + index + ", inserting with sondage " + sondage);
            index = hash((value + sondage), this.table.length);
        }
        this.table[index] = value;
        this.size++;

        if ((double) this.size / this.table.length >= this.loadFactor) {
            // System.out.println("Resize and Rehashing");
            this.rehash();
        }
    }

    void delete(int value) {
        int sondage = 0;
        int index = hash((value + sondage), this.table.length);
        if (this.table[index] == value) {
            this.table[index] = 0;
            this.size--;
            return;
        }
        while (this.table[index] != value) {
            sondage++;
            System.out.println("deleting with sondage " + sondage);
            index = hash((value + sondage), this.table.length);
            if (this.table[index] == 0 || sondage >= this.table.length) {
                return;
            }
        }
    }

    public Boolean search(int value) {
        int sondage = 0;
        int index = hash((value + sondage), this.table.length);
        while (this.table[index] != value) {
            sondage++;
            System.out.println("searching with sondage " + sondage);
            index = hash((value + sondage), this.table.length);
            if (this.table[index] == 0 || sondage >= this.table.length) {
                System.out.println("Not found");
                return false;
            }
        }
        System.out.println("Found" + " at index " + index + " with sondage " + sondage + " value " + this.table[index]);

        return true;
    }

    public Boolean getIndex(int value) {
        int sondage = 0;
        int index = hash((value + sondage), this.table.length);
        while (this.table[index] != value) {
            sondage++;
            System.out.println("searching with sondage " + sondage);
            index = hash((value + sondage), this.table.length);
            if (this.table[index] == 0 || sondage >= this.table.length) {
                System.out.println("Not found");
                return false;
            }
        }
        System.out.println("Found" + " at index " + index + " with sondage " + sondage + " value " + this.table[index]);

        return true;
    }

    void print() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != 0) {
                System.out.println("Index: " + i + " Value: " + this.table[i]);
            }
        }
    }

    int[] sortedPrint() {
        MySort mySort;
        int[] finalList = new int[0];
        boolean firstZero = false;

        mySort = new MySort(this.table.length);
        int[] aux = new int[this.table.length];
        int auxCounter = 0;
        int helper = 0;

        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] == 0 && !firstZero) {
                firstZero = true;
                auxCounter++;
                mySort.myList[i] = this.table[i];
            }

            if (this.table[i] != 0) {
                auxCounter++;
                mySort.myList[i] = this.table[i];
            }
            if (i == this.table.length - 1) {
                finalList = new int[auxCounter];
                mySort.myMergeSort(mySort.myList, aux, 0, mySort.myList.length - 1);
                for (int j = 0; j < mySort.myList.length; j++) {
                    if (mySort.myList[j] != 0) {
                        finalList[helper] = mySort.myList[j];
                        helper++;
                    }
                }
            }
        }
        return finalList;
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
