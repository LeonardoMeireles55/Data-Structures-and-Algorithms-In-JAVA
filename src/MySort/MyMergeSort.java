package MySort;

import java.util.Arrays;

public class MyMergeSort {
    public void merge (int[] list, int[] aux, int initial, int middle, int end) {
        for(int i = initial; i <= end; i++) {
            aux[i] = list[i];
        }
        int initialPositition = initial;
        int middlePosition = middle + 1;

        for(int i = initial; i <= end; i++) {
            if(initialPositition > middle) {
                list[i] = aux[middlePosition++];
            } else if (middlePosition > end) {
                list[i] = aux[initialPositition++];
            } else if (aux[initialPositition] < aux[middlePosition]) {
                list[i] = aux[initialPositition++];
            } else {
                list[i] = aux[middlePosition++];
            }
        }
    }

    public void myMergeSort(int[] list, int[] aux, int initial, int end) {
        if (initial < end) {
            int middle = (initial + end) / 2;
            myMergeSort(list, aux, initial, middle);
            myMergeSort(list, aux, middle + 1, end);

            merge(list, aux, initial, middle, end);
        }
    }

    public static void main(String[] args) {
        MyMergeSort myMergeSort = new MyMergeSort();

        int[] myList = new int[]{5, 3, 4, 1, 2};
        int[] aux = new int[myList.length];
        System.out.println("Before Sort");
        System.out.println(Arrays.toString(myList));
        myMergeSort.myMergeSort(myList, aux, 0, myList.length - 1);
        System.out.println("After Sort");
        System.out.println(Arrays.toString(myList));
    }
}
