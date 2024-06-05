package MyHash;

import java.util.Arrays;

public class MyHashSet extends MyHashTable {

    public MyHashSet(int size) {
        super(size);
    }

    @Override
    public void insert(int value) {
        int sondage = 0;
        int index = hash((value + sondage), table.length);
        if (table[index] == value) {
            table[index] = value;
            throw new IllegalArgumentException("Value already exists");
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

    public void myInnerJoin(int[] table1, int[] table2) {
        int[] helper = new int[table1.length + table2.length];
        int auxCounter = 0;
        int[] result;
        int resultCounter = 0;

        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table2.length; j++) {
                if (table1[i] == table2[j]) {
                    helper[i] = table1[i];
                }
            }
        
        }
        for (int k = 0; k < helper.length; k++) {
            if (helper[k] != 0) {
                auxCounter++;
            }
        }
            result = new int[auxCounter];
            for (int k = 0; k < helper.length; k++) {
                if (helper[k] != 0) {
                    result[resultCounter] = helper[k];
                    resultCounter++;
                    System.out.println("Adding " + helper[k] + " to result");
                }
            }
            System.out.println(Arrays.toString(result));
        }

        public void myLeftJoin(int[] table1, int[] table2) {
            int[] helper = new int[table1.length + table2.length];
            int auxCounter = 0;
            int[] result;
            int resultCounter = 0;
    
            for (int i = 0; i < table1.length; i++) {
                for (int j = 0; j < table2.length; j++) {
                    if (table1[i] == table2[j] || table1[i] != table2[j] ) {
                        helper[i] = table1[i];
                    }
                }
            
            }
            for (int k = 0; k < helper.length; k++) {
                if (helper[k] != 0) {
                    auxCounter++;
                }
            }
                result = new int[auxCounter];
                for (int k = 0; k < helper.length; k++) {
                    if (helper[k] != 0) {
                        result[resultCounter] = helper[k];
                        resultCounter++;
                        System.out.println("Adding " + helper[k] + " to result");
                    }
                }
                System.out.println(Arrays.toString(result));
            }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet(20);
        myHashSet.insert(1);
        myHashSet.insert(2);
        myHashSet.insert(3);
        myHashSet.insert(4);
        myHashSet.insert(5);
        myHashSet.insert(6);
        myHashSet.insert(7);
        myHashSet.insert(8);
        myHashSet.insert(9);
        myHashSet.insert(10);
        myHashSet.sortedPrint();

        MyHashSet myHashSet2 = new MyHashSet(20);
        myHashSet2.insert(1);
        myHashSet2.insert(2);
        myHashSet2.insert(3);
        myHashSet2.insert(8);
        myHashSet2.insert(11);

        myHashSet.myInnerJoin(myHashSet.table, myHashSet2.table);
        myHashSet.myLeftJoin(myHashSet.table, myHashSet2.table);
    }
    
}
