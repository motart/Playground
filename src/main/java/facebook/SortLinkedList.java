package facebook;

import java.util.ArrayList;
import java.util.List;

public class SortLinkedList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int pivot = head.val;
        ListNode rightNode = new ListNode();
        ListNode leftNode = new ListNode();
        ListNode tempRight= rightNode;
        ListNode tempLeft= leftNode;
        while (head != null) {
            if (head.val >= pivot) {
                tempRight.next = head;
                tempRight = tempRight.next;
            } else {
                tempLeft.next = head;
                tempLeft = tempLeft.next;
            }
            head = head.next;
        }
        tempLeft.next = null;
        tempRight.next = null;
        if (leftNode.next == null) {
            return rightNode.next;
        }
        if (rightNode.next == null) {
            return leftNode.next;
        }
        return merge(sortList(leftNode.next),sortList(rightNode.next));
    }

    private static ListNode getMid(ListNode head) {
        ListNode mid = head;
        while (head != null && head.next != null) {
            mid = mid.next;
            head = head.next.next;
        }
        return mid;
    }
    private static ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        }
        if (left == null && right != null) {
            return right;
        }
        if (right == null && left != null) {
            return left;
        }
        ListNode result = left;
        while (left.next != null) {
            left = left.next;
        }
        left.next = right;
        return result;
    }
    public static void main(String[] args) {

        List<Integer> p = new ArrayList<>();
        p.add(1);
        System.out.println( p.subList(1,p.size()));
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = l1.next;
//        l2.next = new ListNode(8);
//        ListNode l3 = l2.next;
//        l3.next = new ListNode(1);
//        ListNode l4 = l3.next;
//        l4.next = new ListNode(7);
        ListNode result = sortList(l1);
        // System.out.print(getMid(l1).val);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
