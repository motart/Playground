package com.playground;

import java.util.*;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        Map<Integer,Long> queryMap = new HashMap<>();
        for (int i=0; i < n; i++) {
            queryMap.put(i+1,0L);
        }

        for (int[] query : queries) {
            for (int i=query[0]; i<=query[1];i++) {
                queryMap.put(i,queryMap.get(i)+query[2]);
            }
        }

        List<Long> queryList = new ArrayList<>();
        for (Map.Entry<Integer,Long> entry : queryMap.entrySet()) {
            queryList.add(entry.getValue());
        }

        return getMax(queryList);
    }

    private static long getMax(List<Long> sums) {
        Collections.sort(sums,Collections.<Long>reverseOrder());
        return sums.get(0);
    }



    public static void main(String[] args) {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 2;
        input[0][2] = 100;

        input[1][0] = 2;
        input[1][1] = 5;
        input[1][2] = 100;

        input[2][0] = 3;
        input[2][1] = 4;
        input[2][2] = 100;
        System.out.println(arrayManipulation(5,input));
    }


}
