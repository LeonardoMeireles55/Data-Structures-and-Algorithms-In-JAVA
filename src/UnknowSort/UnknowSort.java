package UnknowSort;

public class UnknowSort  {
    
    private Integer myList[];

    private Integer temp = 0;

    public UnknowSort(int listSize) {
        myList = (Integer[]) new Integer[listSize];
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


   public void MyUnknowSort() {
        for(int i = 0; i <= myList.length - 1; i++) {
            for(int j = 0; j <= myList.length -1; j++) {
                if (myList[i] < myList[j]) {
                    temp = myList[j];
                    myList[j] = myList[i];
                    myList[i] = temp;
                }
            }
        }
   }

   public void unknowSort2() {
    for(int i = 0; i < myList.length - 1; i++) {
        for(int j = i + 1; j < myList.length; j++) {
            if (myList[i] > myList[j]) {
                temp = myList[j];
                myList[j] = myList[i];
                myList[i] = temp;
            }
        }
    }
}



   public static void main(String[] args) {
    
    UnknowSort unknowSort = new UnknowSort(6);

    unknowSort.myList[0] = 9;
    unknowSort.myList[1] = 5; 
    unknowSort.myList[2] = 8; 
    unknowSort.myList[3] = 7; 
    unknowSort.myList[4] = 12; 
    unknowSort.myList[5] = 10; 


    System.out.println(unknowSort);

    unknowSort.MyUnknowSort();

    System.out.println(unknowSort);

   }
}
