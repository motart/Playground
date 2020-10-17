package com.playground;

import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {

    // Inefficient O(2^n/2)
    static int inefFibonacci(int a) {
        if (a <= 1) {
            return a;
        } else {
            return inefFibonacci(a-1) + inefFibonacci(a-2);
        }
    }


    // Supposed to help but not seeing it
    static Map<Integer, Integer> memo = new TreeMap<>();
    static int fibonacciWithMemo(int a) {
        int result;
        Integer memoValue = memo.get(a);
        if (memoValue != null) {
            return memoValue;
        }
        if (a <= 1) {
            return a;
        }
        result = inefFibonacci(a-1) + inefFibonacci(a-2);
        memo.put(a,result);
        return result;
    }

    // O(n)
    static int efFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int b = 0;
        int c = 1;
        int a;
        for (int i = 2; i <= n ; i++) {
            a = b;
            b = c;
            c = b + a;
        }
        return c;
    }
    public static void main(String[] args) {
        // System.out.println(inefFibonacci(20));
        System.out.println(efFibonacci(200));
        System.out.println(fibonacciWithMemo(200));
    }
}
