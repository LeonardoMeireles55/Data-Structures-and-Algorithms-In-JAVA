package MySort;

import java.util.Arrays;

public class MyBubbleSort {
    public  int[] myList;
    public void myBubbleSort() {
        for (int i = 0; i < myList.length; i++) {
            for (int k = 0; k < myList.length - 1; k++) {
                if (myList[k] > myList[k + 1]) {
                    int temp = myList[k];
                    myList[k] = myList[k + 1];
                    myList[k + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyBubbleSort myBubbleSort = new MyBubbleSort();
        System.out.println("--Bubble Sort--");
        myBubbleSort.myList = new int[]{5, 3, 4, 1, 2};
        System.out.println("Before Sort");
        System.out.println(Arrays.toString(myBubbleSort.myList));
        myBubbleSort.myBubbleSort();
        System.out.println("After Sort");
        System.out.println(Arrays.toString(myBubbleSort.myList));
    }
}
