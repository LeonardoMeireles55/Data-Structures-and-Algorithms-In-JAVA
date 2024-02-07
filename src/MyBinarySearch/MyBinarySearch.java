package MyBinarySearch;

public class MyBinarySearch {
    public static int[] arr = { 2, 3, 4, 10, 40 };

    public int binarySearch(int number, int[] arr) {
        int inital = 0;
        int end = arr.length - 1;

        while (inital <= end) {
            int middle = inital + (end - inital) / 2;

            if(arr[middle] == number) {
                System.out.println("Found!");
                return middle;
            } else if (arr[middle] < number) {
                return inital = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public static void main(String[] args) {
        MyBinarySearch myBinarySearch = new MyBinarySearch();

        myBinarySearch.binarySearch(2, MyBinarySearch.arr);
    }
}
