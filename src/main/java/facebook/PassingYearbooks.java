package facebook;

public class PassingYearbooks {
    public static void main(String[] args) {
        findSignatureCounts(new int[] {1, 2});
    }

    static int[] findSignatureCounts(int[] arr) {
        // Write your code here
        int[] initialOrder = arr.clone();
        int[] result = new int[arr.length];

        while (isSwapValid(arr, initialOrder)) signCurrentYB(result);
        signCurrentYB(result);
        return result;
    }

    private static void signCurrentYB(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
    }

    private static boolean isSwapValid(int[] result, int[] initialOrder) {
        int temp = result[0];
        for (int i  = 1; i < result.length; i++) {
            if (result[i] == initialOrder[i-1]) return false;
            result[i-1] = result[i];
        }
        result[result.length - 1] = temp;
        return true;
    }
}
