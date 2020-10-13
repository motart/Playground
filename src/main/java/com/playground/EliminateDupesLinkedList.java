package com.playground;

import java.util.HashSet;
import java.util.Set;

public class EliminateDupesLinkedList {
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        Set<Integer> temp = new HashSet<>();
        while (head != null) {
            if (head.data == head.next.data) {
            }
        }

        return null;
    }

    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

}
