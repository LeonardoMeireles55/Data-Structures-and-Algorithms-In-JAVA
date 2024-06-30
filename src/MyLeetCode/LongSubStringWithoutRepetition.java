package MyLeetCode;

import java.util.HashMap;

public class LongSubStringWithoutRepetition {
    public int lengthOfLongestSubstring(String string) {
        int stringLength = string.length();
        if (stringLength == 0) {
            return 0;
        }

        int max = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < stringLength; i++) {
            if(map.containsKey(string.charAt(i)) && map.get(string.charAt(i)) >= start) {
                start = map.get(string.charAt(i)) + 1;
            }

            map.put(string.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongSubStringWithoutRepetition longSubStringWithoutRepetition 
        = new LongSubStringWithoutRepetition();
        var string = "abcabcxabcxz";

        System.out.println(
            longSubStringWithoutRepetition.lengthOfLongestSubstring(string)
        );
    }
}