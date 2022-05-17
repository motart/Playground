package facebook;

// Given a string s, find the length of the longest substring without repeating characters.

import java.util.HashMap;

public class LongestSubStringWithoutRepeats {
    public static void main(String[] args) {
        String input = "dvdf";
        System.out.println(processString(input, 0));
    }

    // For each character place it in a hashmap, with char as the key and the position/index as the value.
    // if char already exists in the map, assign current index - previous index to the

    private static int processString(String str, int maxLength) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                return processString(str.substring(1), Math.max(maxLength, i));
            } else {
                map.put(str.charAt(i), i);
            }
        }

        return Math.max(str.length(), maxLength);
    }
}
