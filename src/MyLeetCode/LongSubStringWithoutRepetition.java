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

    private int recursiveMethod(String string, int start, int end) {
        if (start == end) {
            return 1;
        }

        if (string.charAt(start) == string.charAt(end)) {
            return recursiveMethod(string, start + 1, end) + 2;
        }

        return Math.max(recursiveMethod(string, start + 1, end),
         recursiveMethod(string, start, end - 1));
    }

    public static void main(String[] args) {
        LongSubStringWithoutRepetition longSubStringWithoutRepetition 
        = new LongSubStringWithoutRepetition();
        var string = "abcabc";
        int start = 0;
        int end = string.length() - 1;

        System.out.println(
            longSubStringWithoutRepetition.recursiveMethod(string, start, end)
        );
    }
}