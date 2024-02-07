package MySort;

public class MySort {

    private  int[] myList;
    private  int[] auxList;

    private Integer temp = 0;

    public MySort(int listSize) {
        myList = (int[]) new int[listSize];
        auxList = (int[]) new int[listSize];
    }

    public void mySelecionSort() {
        for (int i = 0; i < myList.length; i++) {
            for (int j = i + 1; j < myList.length; j++) {
                if (myList[i] > myList[j]) {
                    temp = myList[i];
                    myList[i] = myList[j];
                    myList[j] = temp;
                }
            }
        }
    }

    public void myBubbleSort() {
        for (int i = 0; i < myList.length; i++) {
            for (int k = 0; k < myList.length - 1; k++) {
                if (myList[k] > myList[k + 1]) {
                    temp = myList[k];
                    myList[k] = myList[k + 1];
                    myList[k + 1] = temp;
                }
            }
        }
    }

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


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= myList.length - 1; i++) {
            stringBuilder.append(myList[i]).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return "[" + stringBuilder + "] ";

    }


    public static void main(String[] args) {

        MySort mySort = new MySort(5);

        mySort.myList[0] = 9;
        mySort.myList[1] = 10;
        mySort.myList[2] = 8;
        mySort.myList[3] = 5;
        mySort.myList[4] = 4;

        mySort.myMergeSort(mySort.myList,mySort.auxList, 0, mySort.myList.length - 1);

        System.out.print("[");
        for(int i = 0; i < mySort.myList.length - 1; i++) {
            System.out.print("" + mySort.myList[i] + ", ");
        }
        System.out.print(mySort.myList[mySort.myList.length - 1]);
        System.out.print("]");
    }
}
