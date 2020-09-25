package com.playground;

import java.util.HashMap;
import java.util.Map;

public class MinimumBribesAlt {
    static int minimumBribes(int[] q) {
        int result = 0;
        Map<Integer,Integer> input = new HashMap<>();
        Map<Integer,Integer> inputMirror = new HashMap<>();
        for (int index = 0; index < q.length; index++) {
            if (q[index] - index - 1 >= 3) {
                System.out.println("Too chaotic");
            }

            // keys are input, values are indexes
            input.put(q[index],index+1);
            inputMirror.put(index+1,q[index]);
        }

        for (Map.Entry<Integer,Integer> element : input.entrySet()) {
            if (element.getValue() - element.getKey() > 0) {
                result = result + input.get(element.getKey()) - element.getKey() + 1;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] input = new int[]{1,4,5,2,3};
        System.out.println(minimumBribes(input));
    }
}
