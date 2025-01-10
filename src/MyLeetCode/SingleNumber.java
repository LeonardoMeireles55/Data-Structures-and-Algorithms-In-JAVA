package MyLeetCode;

import MyHash.MyHashMap;

public class SingleNumber {

	public int singleNumber(int[] nums) {

		MyHashMap<Integer, Integer> hashMap = new MyHashMap<>(1000);

		if (nums.length == 0) {
			throw new Error();
		}
		if (nums.length == 1) {
			return nums[0];
		}

		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], nums[i]);
		} ;

		return hashMap.getValue();
	}

	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();

		int[] array = {-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513,
				-560, -481, -174, 101, -997, 40, -527, -784, -283, 354};

		System.out.println(singleNumber.singleNumber(array));

	}
}
