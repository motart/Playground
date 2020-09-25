package com.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLeftRotation {
    static int[] rotLeft(int[] a, int d) {
        List<Integer> input = asList(a);
        List<Integer> result = new ArrayList<>();
        if (d == 0 || a.length < 2) {
            return a;
        }

        // O(1)
        result.addAll(input.subList(d+1, input.size()-1));
        result.addAll(input.subList(0,d));
        int[] arrayResult = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }

    // O(n)
    static List<Integer> asList(int[] a) {
        List<Integer> input = new ArrayList<>();
        for (int element : a) {
            input.add(element);
        }
        return input;
    }


    private static void main(String [] args) {

    }
}
