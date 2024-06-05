package MyHash;

import java.util.Arrays;


public class MyHashSet extends MyHashTable {

    public MyHashSet(int size) {
        super(size);
    }

    boolean isFirstZero(int zero, MyHashSet zeroHashSet) {
        if(zeroHashSet.size == 0) {
            zeroHashSet.insert(zero);
            return true;
        }
        return false;
    }


    @Override
    public void insert(int value) {

        int sondage = 0;
        int index = hash((value + sondage), table.length);

        if (table[index] == value && value != 0) {
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

        public void myInnerJoinEnhanced(int[] table1, int[] table2) {
            MyHashSet myZeroHashSet = new MyHashSet(5);

            Integer[] helper = new Integer[table1.length + table2.length];    
            for (int i = 0; i < table1.length; i++) {
                    for (int j = 0; j < table2.length; j++) {
                        if (table1[i] == table2[j]) {
                            helper[i] = table1[i];
                        }
                    }
                } 

            Integer[] resultStream = Arrays.stream(helper)
            .filter(x -> x != null && (x != 0 || isFirstZero(x, myZeroHashSet)))
            .toArray(Integer[]::new);
            System.out.println("Inner Join: ");
            System.out.println(Arrays.toString(resultStream));
        }

        public void myLeftJoinEnhanced(int[] table1, int[] table2) {
            MyHashSet myZeroHashSet = new MyHashSet(5);

            Integer[] helper = new Integer[table1.length + table2.length];    
            for (int i = 0; i < table1.length; i++) {
                    for (int j = 0; j < table2.length; j++) {
                        if (table1[i] == table2[j] || table1[i] != table2[j] ) {
                            helper[i] = table1[i];
                        }
                    }
                } 

            Integer[] resultStream = Arrays.stream(helper)
            .filter(x -> x != null && (x != 0 || isFirstZero(x, myZeroHashSet)))
            .toArray(Integer[]::new);
            System.out.println("Left Join: ");
            System.out.println(Arrays.toString(resultStream));
        }


        public void myRigthJoinEnhanced(int[] table1, int[] table2) {
            Integer[] helper = new Integer[table1.length + table2.length];    
            MyHashSet myZeroHashSet = new MyHashSet(5);


            for (int i = 0; i < table2.length; i++) {
                    for (int j = 0; j < table1.length; j++) {
                        if (table2[i] == table1[j] || table2[i] != table1[j] ) {
                            helper[i] = table2[i];
                        }
                    }
                } 

            Integer[] resultStream = Arrays.stream(helper)
            .filter(x -> x != null && (x != 0 || isFirstZero(x, myZeroHashSet)))
            .toArray(Integer[]::new);
            System.out.println("Right Join: ");
            System.out.println(Arrays.toString(resultStream));
        }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet(5);
        myHashSet.insert(0);
        myHashSet.insert(1);
        myHashSet.insert(2);
        myHashSet.insert(3);
        myHashSet.insert(4);
        myHashSet.insert(5);

        // myHashSet.sortedPrint();

        MyHashSet myHashSet2 = new MyHashSet(5);
        myHashSet2.insert(0);
        myHashSet2.insert(1);
        myHashSet2.insert(2);
        myHashSet2.insert(3);
        myHashSet2.insert(8);
        myHashSet2.insert(11);

        myHashSet.myInnerJoinEnhanced
        (myHashSet.table, myHashSet2.table);

        myHashSet.myRigthJoinEnhanced
        (myHashSet.table, myHashSet2.table);

        myHashSet.myLeftJoinEnhanced
        (myHashSet.table, myHashSet2.table);
    }
    
}
