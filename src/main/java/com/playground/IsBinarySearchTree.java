package com.playground;

import java.util.TreeSet;

public class IsBinarySearchTree {




    boolean checkBST(Node root) {
        TreeSet<Integer> tSet = new TreeSet<>();
        if (root == null || (root.right == null && root.left == null)) {
            return false;
        } else

        if (root.data > root.left.data && root.data < root.right.data) {
            return true;
        }

        return checkBST(root.left) && checkBST(root.right);

    }

    static class Node {
        int data;
        Node left;
        Node right;
    }

}
