package MySort;

public class MySort {
    
    private final Integer[] myList;

    private Integer temp = 0;

    public MySort(int listSize) {
        myList = (Integer[]) new Integer[listSize];
    }

   public void mySelecionSort() {
        for(int i = 0; i < myList.length; i++) {
            for(int j = i + 1; j < myList.length; j++) {
                if (myList[i] > myList[j]) {
                    temp = myList[i];
                    myList[i] = myList[j];
                    myList[j] = temp;
                }
            }
        }
   }

    public void myBubbleSort() {
        for(int i = 0; i < myList.length; i++) {
                for (int k = 0; k < myList.length-1; k++) {
                    if(myList[k] > myList[k+1]) {
                        temp = myList[k];
                        myList[k] = myList[k+1];
                        myList[k+1] = temp;
                    }
                }
            }
        }

    public void myInsertionSort() {
        int i;
        int j;
        int temp;
        for(j = 1; j < myList.length; j++) {
            temp = myList[j];
            for(i = j - 1; (i >= 0) && (myList[i] > temp); i--) {
                myList[i + 1] = myList[i];
            }
            myList[i + 1] = temp;
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i <= myList.length - 1; i ++) {
            stringBuilder.append(myList[i]).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return "[" + stringBuilder + "] ";

    }
   public static void main(String[] args) {
    
    MySort mySort = new MySort(4);

    mySort.myList[0] = 9;
    mySort.myList[1] = 10;
    mySort.myList[2] = 8;
    mySort.myList[3] = 5;

    System.out.println(mySort);

    mySort.myInsertionSort();

    System.out.println(mySort);

   }
}
