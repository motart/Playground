package com.playground;

import java.util.TreeSet;

public class IsBinarySearchTree {
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

    The Node class is defined as follows:
        class Node {
            int data;
            Node left;
            Node right;
         }
    */
    TreeSet<Integer> data(Node root) {
        TreeSet<Integer> result = new TreeSet<>();
        if (root == null) {
            return result;
        }
        if (root.right == null && root.left == null) {
            result.add(root.data);
        }
        result.addAll(data(root.right));
        result.addAll(data(root.left));
        return result;
    }

    int leftData(Node root) {
        return data(root).last();
    }

    int rightData(Node root) {
        return data(root).first();
    }

    boolean checkBST(Node root) {
        boolean isBST;
        if (root.left != null && root.right != null) {
            isBST = root.data > leftData(root.left) && root.data < rightData(root.right);
            if (!isBST) {
                return false;
            }
            return checkBST(root.left) && checkBST(root.right);
        }
        return true;
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }

}
