package com.playground;

public class StringPermutations {
    public static void stringPermutations(String s) {
        stringPermutations(s, 0, s.length() - 1);
    }

    public static void stringPermutations(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        } else {
            for (int i=start; i<=end; i++) {
                s = swap(s,start,i);
                stringPermutations(s,start + 1, end);
                s = swap(s,start,i);
            }
        }
    }

    private static String swap(String s, int start, int end) {
        char[] str = s.toCharArray();
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        return String.valueOf(str);
    }
    public static void main(String[] args) {
        stringPermutations("ABC");
    }
}
