package MySort;

import java.util.Arrays;

public class MySelectionSort {
	public int[] myList;

	public void mySelectionSort() {
		for (int i = 0; i < myList.length; i++) {
			for (int j = i + 1; j < myList.length; j++) {
				System.out.println("CALL COUNTER" + " --> " + (i) + j);
				if (myList[i] > myList[j]) {
					System.out.println(this.myList[i] + " --> swapping --> " + this.myList[j]);
					int temp = myList[i];
					myList[i] = myList[j];
					myList[j] = temp;
					System.out.println(this.myList[i] + " --> swapping --> " + this.myList[j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		MySelectionSort mySelectionSort = new MySelectionSort();
		System.out.println("Selection Sort");
		mySelectionSort.myList = new int[] {5, 3, 4, 1, 2};
		System.out.println("Before Sort");
		System.out.println(Arrays.toString(mySelectionSort.myList));
		mySelectionSort.mySelectionSort();
		System.out.println("After Sort");
		System.out.println(Arrays.toString(mySelectionSort.myList));
	}
}
