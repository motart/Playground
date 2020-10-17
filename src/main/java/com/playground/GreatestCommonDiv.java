package com.playground;

public class GreatestCommonDiv {

    // Brute force O(n)
    static int getGCDNonIter(int a, int b) {

        if (a % b == 0) {
            return b;
        }
        if (b % a == 0) {
            return a;
        }
        if (a > b) {
            for (int i = b; i > 0; i--) {
                if (a % i == 0 && b % i == 0) {
                    return i;
                }
            }
        } else {
            for (int i = a; i > 0; i--) {
                if (a % i == 0 && b % i == 0) {
                    return i;
                }
            }
        }
        return 1;
    }

    // Recursive O(logn)
    static int getGCDIter(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCDIter(b,a%b);
    }

    public static void main(String[] args) {
        // System.out.println(getGCDNonIter(1408755,254));
        System.out.println(getGCDIter(24,9));
    }

}
