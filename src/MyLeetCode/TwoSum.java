package MyLeetCode;

public class TwoSum {

    public int[] table;

    private class MyHashMap {
        private class Pair {
            int key;
            int value;

            Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private Pair[] map;

        public MyHashMap(int size) {
            this.size = size;
            this.map = new Pair[size];
        }

        public int hash(int key) {
            return key % size;
        }

        public void put(int key, int value) {
            int index = hash(key);
            while (map[index] != null && map[index].key != key) {
                index = (index + 1) % size;
            }
            map[index] = new Pair(key, value);
        }

        public int get(int key) {
            int index = hash(key);
            while (map[index] != null) {
                if (map[index].key == key) {
                    return map[index].value;
                }
                index = (index + 1) % size;
            }
            return -1;
        }

        public boolean contains(int key) {
            int index = hash(key);
            while (map[index] != null) {
                if (map[index].key == key) {
                    return true;
                }
                index = (index + 1) % size;
            }
            return false;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        MyHashMap map = new MyHashMap(25);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.contains(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
}

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum.twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
