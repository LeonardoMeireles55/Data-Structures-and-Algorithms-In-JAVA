package MyLeetCode;

import java.util.Arrays;

public class RemoveDuplicatesInPlace {

        public int removeDuplicates(int[] nums) {
          if (nums.length == 0) return 0;

          int k = 1;
          for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
              nums[k] = nums[i + 1];
              k++;
            }
          }
          return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        RemoveDuplicatesInPlace removeDuplicatesInPlace = new RemoveDuplicatesInPlace();
        System.out.println("Array before removing duplicates: " + Arrays.toString(nums));
        int k = removeDuplicatesInPlace.removeDuplicates(nums);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
