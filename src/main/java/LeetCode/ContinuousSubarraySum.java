package LeetCode;

import com.jayway.jsonpath.internal.function.numeric.Sum;

public class ContinuousSubarraySum {

    public static void main(String [] args) {
        ContinuousSubarraySum handle = new ContinuousSubarraySum();
        int[] input = new int[] {23,2,4,6,6};
        int k = 7;
        System.out.println( handle.checkSubarraySum(input,k) );
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // Brute force
        int result = 0;;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i  ; j < nums.length; j++) {
                sum =+ nums[j];
                if (sum % k == 0) {
                    result++;
                }
            }
            sum = 0;
        }
        return result > 0;
    }
}
