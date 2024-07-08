package MyLeetCode;

import MyHash.MyHashMap;

public class TwoSum {

    public int[] result(int[] nums, int target) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(100);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.contains(complement)) {
                System.out.println("Complement: " + complement + " nums " + nums[i]);
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
}

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 15, 11, 7};
        int target = 9;

        int[] result = twoSum.result(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
