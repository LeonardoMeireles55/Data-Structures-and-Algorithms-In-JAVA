package MySort;

import java.util.Arrays;

public class MyInsertionSort {
    public  int[] myList;
    public void myInsertionSort() {
        for(int i = 1; i < myList.length; i++) {
            int currentElement = myList[i];
            int j = i - 1;
            while(j >= 0 && myList[j] > currentElement) {
                myList[j + 1] = myList[j];
                j = j - 1;
            }
            myList[j + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        MyInsertionSort myInsertionSort = new MyInsertionSort();
        System.out.println("Insertion Sort");
        myInsertionSort.myList = new int[]{5, 3, 4, 1, 2};
        System.out.println("Before Sort");
        System.out.println(Arrays.toString(myInsertionSort.myList));
        myInsertionSort.myInsertionSort();
        System.out.println("After Sort");
        System.out.println(Arrays.toString(myInsertionSort.myList));
    }
}
