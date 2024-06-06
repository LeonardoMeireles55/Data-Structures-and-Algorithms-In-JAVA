package MyLeetCode;

import java.util.HashMap;

public class LongSubStringWithoutRepetition {
    public int lengthOfLongestSubstring(String string) {
        int stringLength = string.length();
        int max = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        if (stringLength == 0) {
            return 0;
        }

        for(int i = 0; i < stringLength; i++) {
            if(map.containsKey(string.charAt(i))) {
                start = map.get(string.charAt(i)) + 1;
            }

            map.put(string.charAt(i), i);
            max = i - start + 1;
        }

        return max;
    }

    public static void main(String[] args) {
        LongSubStringWithoutRepetition longSubStringWithoutRepetition 
        = new LongSubStringWithoutRepetition();
        var string = "abcabcx";

        System.out.println(
            longSubStringWithoutRepetition.lengthOfLongestSubstring(string)
        );
    }
}