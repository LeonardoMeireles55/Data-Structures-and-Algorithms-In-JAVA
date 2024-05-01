package MyBinarySearch;

public class MyBinarySearch {
    public static int[] arr = { 2, 3, 4, 10, 40, 50, 60, 70, 80, 90, 100 };

    public Boolean search(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                System.out.println("Found!");
                return true;
            }
        }
        System.out.println("Not found");
        return false;
    }

    public int binarySearch(int number, int[] arr) {
        int inital = 0;
        int end = arr.length - 1;

        while (inital <= end) {
            int middle = inital + (end - inital) / 2;

            if(arr[middle] == number) {
                System.out.println("Found!");
                return middle;
            } else if (arr[middle] < number) {
                inital = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public static void main(String[] args) {
        MyBinarySearch myBinarySearch = new MyBinarySearch();

        myBinarySearch.binarySearch(80, MyBinarySearch.arr);
    }
}
