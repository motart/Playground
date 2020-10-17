package com.playground;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<Character,Integer> memo = new HashMap<>();
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return memo.get(s.charAt(0));
        } else if (memo.get(s.charAt(0)) < memo.get(s.charAt(1)) ) {
            return memo.get(s.charAt(1)) - memo.get(s.charAt(0)) + romanToInt(s.substring(2));
        } else {
            return romanToInt(s.substring(1)) + memo.get(s.charAt(0));
        }
    }

    public static void main(String[] args) {
        memo.put('I',1);
        memo.put('V',5);
        memo.put('X',10);
        memo.put('L',50);
        memo.put('C',100);
        memo.put('D',500);
        memo.put('M',1000);
        System.out.print(romanToInt("IX"));
    }
}
