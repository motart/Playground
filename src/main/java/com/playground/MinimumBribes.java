package com.playground;

import java.util.HashMap;
import java.util.Map;

public class MinimumBribes {
    static void minimumBribes(int[] q) {
        int count = 0;
        // always keep track of min three values observed
        // Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree = Integer.MAX_VALUE;
        int minOfThree = Integer.MAX_VALUE;

        // iterating from left to right
        for (int i = q.length - 1; i >= 0; i--) {
            // person has no way to move more than two positions -> wrong
            if ((q[i] - i) > 3) {
                System.out.println("Too chaotic");
                return;
            } else {
                // means current value has passed at least 3 values -> wrong
                if (q[i] > maxOfThree) {
                    System.out.println("Too chaotic");
                    return;
                } else if (q[i] > midOfThree) { // means -> current value has bribed 2 ppl
                    count = count + 2;
                } else if (q[i] > minOfThree) { // means-> current value has bribed 1 person.
                    count = count + 1;
                }

                // Now adjust minThree values comparing, taking the current vlaue to account
                if (q[i] < minOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = minOfThree;
                    minOfThree = q[i];
                } else if (q[i] < midOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = q[i];
                } else if (q[i] < maxOfThree) {
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        minimumBribes(new int[]{1,2,5,6,3,4,9,7,8});
    }
}
