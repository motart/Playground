package com.playground;

import org.apache.commons.math.linear.RealMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        List<Query> queryList = new ArrayList<>();
        int[] sums = new int[n];
        for (int[] query : queries) {
            queryList.add(new Query(query[0],query[1],query[2]));
        }
        Collections.sort(queryList);
        for (Query query : queryList) {
            for (int i = query.min - 1; i < query.max; i++) {
                sums[i] = sums[i] + query.value;
            }
        }
        return getMax(sums);
    }

    private static long getMax(int[] sums) {
        long result = 0L;
        for (int value : sums) {
            if (value > result) {
                result = value;
            }
        }
        return result;
    }

    static class Query implements Comparable<Query> {
        int min;
        int max;
        int value;
        Query(int min, int max, int value) {
            this.min = min;
            this.max = max;
            this.value = value;
        }
        public int compareTo(Query o) {
            if (min == o.min) {
                return max - o.max;
            }
            return min - o.min;
        }
    }



    public static void main(String[] args) {
        int[][] input = new int[5][3];
        input[0][0] = 1;
        input[0][1] = 4;
        input[0][2] = 1;

        input[1][0] = 3;
        input[1][1] = 4;
        input[1][2] = 1;

        input[2][0] = 2;
        input[2][1] = 6;
        input[2][2] = 1;

        input[3][0] = 1;
        input[3][1] = 3;
        input[3][2] = 1;

        input[4][0] = 5;
        input[4][1] = 7;
        input[4][2] = 1;


        arrayManipulation(10,input);
    }


}
