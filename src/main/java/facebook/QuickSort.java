package facebook;

public class QuickSort {
    public static void sort(int [] arr, int start, int end) {
        if (start < end) {
            int part = partition(arr, start, end);
            sort(arr, start, part-1);
            sort(arr, part+1, end);
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
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arg =  new int[] {10,80,30,90,40,50,70};
        sort(arg, 0 , arg.length - 1);
        printArray(arg);
    }

    private static void printArray(int[] arg) {
        for (int element : arg) {
            System.out.print(element + " ");
        }
    }
}
