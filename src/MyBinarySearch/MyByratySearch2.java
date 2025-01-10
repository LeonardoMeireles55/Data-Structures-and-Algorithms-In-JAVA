package MyBinarySearch;

public class MyByratySearch2 {

    int list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // 0, 1, 2, 3, 4, 5, 6, 7, 8,


    // left and right O(n)/2

    public boolean binarySearch(int[] list, int value) {

        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (list[middle] == value) {
                return true;
            }
            if (list[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    //

    public static void main(String[] args) {

        MyByratySearch2 myByratySearch2 = new MyByratySearch2();

        System.out.println(myByratySearch2.binarySearch(myByratySearch2.list, 10));

    }
}
