package facebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class IceCreamParlor {
    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        int[] result = new int[2];
        // Store all flavors' costs in a map : O(n)
        Map<Integer, List<Integer>> flavors = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = flavors.get(arr[i]);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(i + 1);
            flavors.put(arr[i],temp);
        }

        // Find first pair in map adding up to m
        for (int j = 1; j <= m; j++) {
            List<Integer> sunny = flavors.get(j);
            List<Integer> johnny = flavors.get(m-j);

            if (sunny != null && johnny != null) {
                if (j == m - j && sunny.size() < 2) {
                    // do nothing
                } else if (j == m - j) {
                    result[0] = sunny.get(0);
                    result[1] = sunny.get(1);
                    return result;
                } else {
                    result[0] = sunny.get(0);
                    result[1] = johnny.get(0);
                    return result;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);
            for (int element : result) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
