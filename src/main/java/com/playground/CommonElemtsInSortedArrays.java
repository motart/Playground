package com.playground;

public class CommonElemtsInSortedArrays {
    static void commonElementsInSortedArrays(int [] a, int[] b) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else if (a[i] == b[j]) {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        commonElementsInSortedArrays(new int[]{13,27,35,40,49,55,59},new int[]{17,35,39,40,55,58,60});
    }
}
