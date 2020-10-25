package com.playground;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // System.out.println(myAtoi("20000000000000000000"));
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');

        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }

    static String isBalanced(String s) {
        if (s.length()%2 != 0) {
            return "NO";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if ((s.charAt(i) == '}' && '{' != stack.pop()) || (s.charAt(i) == ')' && '(' != stack.pop()) || (s.charAt(i) == ']' && '[' != stack.pop())){
                    return "NO";
                }
            }
        }
        if (stack.size() > 0) {
            return "NO";
        }
        return "YES";
    }

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int i = 0;
        StringBuilder result = new StringBuilder();
        boolean isSigned = false;

        // Trim spaces from beginning of String
        while (!s.isEmpty() && s.charAt(0) == ' ') {
            s = s.substring(1);
        }
        if (s.isEmpty()) {
            return 0;
        }
        if ( isADigit(s.charAt(0))) {
            isSigned = true;
        }

        while ((i < s.length()) && (((s.charAt(i) == '+' || s.charAt(i) == '-') && isSigned == false)
                || isADigit(s.charAt(i)))) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                isSigned = true;
            }
            result.append(s.charAt(i));
            i++;
        }
        return getInteger(result.toString());
    }

    public static int getInteger(String string) {
        if (string == null || string.isEmpty() || "+".equals(string)  || "-".equals(string)) {
            return 0;
        }
        Long result = Long.valueOf(string);
        if (result >= 2147483647) {
            return 2147483647;
        }
        if (result <= -2147483648) {
            return -2147483648;
        }
        return result.intValue();
    }

    public static boolean isADigit(char ch) {
        if (String.valueOf(ch).isEmpty()) {
            return false;
        }
        if (Integer.valueOf(ch) >= 48 && Integer.valueOf(ch) <=57) {
            return true;
        }
        return false;
    }
}
