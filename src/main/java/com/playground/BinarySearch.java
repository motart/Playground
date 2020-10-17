package com.playground;

import java.util.SortedMap;

public class BinarySearch {

    // Given a SortedMap array
    static int find(int[] arr, int start, int end,int value) {
        int mid = start + (end - start)/2;
        if (arr[mid] == value) {
            return mid;
        }
        if (arr[mid] > value) {
            return find(arr,start,mid,value);
        }
        if (arr[mid] < value) {
            return find(arr,mid,end,value);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(find(new int[]{0,0,0,1,1,1,1,3,5,6,7},0,10,3));
    }
}
