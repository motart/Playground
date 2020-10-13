package com.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if (A[0] > 1 || (A[0] < 0 && A[A.length - 1] <= 0)) {
            return 1;
        } else {
            List<Integer> temp = new ArrayList<>();
            // filter out negative elements
            for (int i = 0; i<A.length; i++) {
                if (A[i] > 0) {
                    temp.add(A[i]);
                }
            }
            if (temp.isEmpty()) {
                return 1;
            } else if (temp.get(0) > 1) {
                    return 1;
            } else {
                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i + 1) - temp.get(i) > 1 && temp.get(i) > 1) {
                        return temp.get(i);
                    }
                }
            }
        }
        return A[A.length - 1] + 1;
    }
}
