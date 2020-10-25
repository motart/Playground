package com.playground;

public class QuickSort {
    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partitionArray(arr, start, end);
            quickSort(arr,start,partitionIndex - 1);
            quickSort(arr,partitionIndex + 1, end);
        }
    }


    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }


    private static int partitionArray(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,2,1,6};
        quickSort(arr,0,arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
