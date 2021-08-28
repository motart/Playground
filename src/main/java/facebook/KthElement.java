package facebook;

import java.util.*;

public class KthElement {
    public static void main(String[] args) {
        System.out.println( findKthLargest(new int[]{9,3,2,5,8,0,1},3) );
    }
    public static int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        Set<Integer> test = new HashSet<>();
        test.add(1);
        test.remove(1);
        // output
        return heap.poll();
    }
}
