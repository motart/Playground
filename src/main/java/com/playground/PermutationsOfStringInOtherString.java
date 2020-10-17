package com.playground;

import java.util.*;

public class PermutationsOfStringInOtherString {
    static void findPermutations(String s, String b) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= b.length() - s.length(); i++) {
            if (isPermutation(s,b.substring(i,i+s.length()))) {
                result.add(i);
            }
        }
        System.out.print(result);
    }

    static TreeMap<Integer,Character> getMapFromArray(char[] arr) {
        TreeMap<Integer,Character> result = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            result.put(i,arr[i]);
        }
        return result;
    }

    static boolean isEqual(TreeMap<Integer,Character> a, TreeMap<Integer,Character> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPermutation(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        TreeMap<Integer,Character> trackA = getMapFromArray(arrayA);
        TreeMap<Integer,Character> trackB = getMapFromArray(arrayB);
        return isEqual(trackA,trackB);
    }

    public static void main(String[] args) {
        Set<Character> res = new HashSet<>();
        findPermutations("adc","dcda");
    }
}
