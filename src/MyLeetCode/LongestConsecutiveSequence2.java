package MyLeetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence2 {
    public int longestConsecutive(int[] nums) {
        var hashSet = new HashSet<Integer>();
        int longestConsecutiveSequence = 0;

        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return 1;
        }

        for (int num : nums) {
            hashSet.add(num);
        }

        if(hashSet.size() == 1) {
            return 1;
        }

        for (int sequence : hashSet) {
           if(!hashSet.contains(sequence - 1)) {
            int currentSequence = sequence;
            int currentSequenceLength = 1;
        
           while (hashSet.contains(currentSequence + 1)) {
                currentSequence++;
                currentSequenceLength++;
            } 
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentSequenceLength);
        }
    }  
         return longestConsecutiveSequence;
    }


    public static void main(String[] args) {
        int[] nums = {-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1, 0, 1, 2, 3};
        // -3, -2, -1, 1, 2, 3, 4
        LongestConsecutiveSequence2 longestConsecutiveSequence = new LongestConsecutiveSequence2();
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
}
