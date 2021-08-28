package facebook;

import java.util.Scanner;

public class GameOfTwoStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int score = 0;
        boolean done = false;
        while (!done && i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (score + a[i] > x) {
                    // Need to verify that B does not have a value that still satisifies score <= x;
                    if (score + b[j] <= x) {
                        score += b[j++];
                    } else {
                        done = true;
                    }
                } else {
                    score += a[i++];
                }
            } else {
                if (score + b[j] > x) {
                    if (score + a[i] <= x) {
                        score += a[i++];
                    } else {
                        done = true;
                    }
                } else {
                    score += b[j++];
                }
            }
        }
        while (!done && i < a.length) {
            if (score + a[i] > x) {
                done = true;
            } else {
                score += a[i++];
            }
        }

        while (!done && i < b.length) {
            if (score + b[j] > x) {
                done = true;
            } else {
                score += b[j++];
            }
        }
        return i + j;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(result);
        }

    }

}
