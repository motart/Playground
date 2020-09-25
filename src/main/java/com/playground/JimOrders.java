package com.playground;

import java.util.Arrays;

public class JimOrders {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        Guy[] guyArray = new Guy[orders.length];
        int[] result = new int[orders.length];
        for (int i =0; i < orders.length; i++) {
            guyArray[i] = new Guy(i+1, orders[i][0] + orders[i][1]);
        }
        Arrays.sort(guyArray);
        for (int i=0; i < guyArray.length; i++) {
            result[i] = guyArray[i].id;
        }
        return result;
    }
    public static class Guy implements Comparable<Guy>{
        Integer id;
        Integer serveTime;
        Guy(int id, int serveTime) {
            this.id = id;
            this.serveTime = serveTime;
        }
        @Override
        public int compareTo(Guy o) {
            if (serveTime == o.serveTime) {
                return o.serveTime - id;
            } else {
                return serveTime - o.serveTime;
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] order = new int[2];
        int[][] input = new int[5][2];
        input[0][0] = 1;
        input[0][1] = 3;
        input[1][0] = 2;
        input[1][1] = 6;
        input[2][0] = 3;
        input[2][1] = 1;
        input[3][0] = 4;
        input[3][1] = 2;
        input[4][0] = 5;
        input[4][1] = 1;
        jimOrders(input);
    }
}
