package facebook;

public class BinarySort {
    private static int iterativeBinarySort(int[] arr, int value) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end)/2;
            if (arr[middle] == value) {
                return middle;
            }
            if (arr[middle] < value) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10,30,40,50,70,80,90};
        System.out.println(iterativeBinarySort(arr,80));
        System.out.println(recursiveSort(arr,0,arr.length-1,80));

    }

    private static int recursiveSort(int[] arr, int start, int end, int value) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] < value) {
                return recursiveSort(arr, mid + 1,end, value);
            } else {
                return recursiveSort(arr, start, mid - 1, value);
            }
        }
        return -1;
    }
}
