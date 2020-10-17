package com.playground;

import com.sun.source.tree.BinaryTree;

import java.util.HashSet;
import java.util.Set;

public class HeightOfBinaryTree {
    int treeHeight(Node node) {
        // Empty tree
        if (node == null) {
            return 0;
        }
        // We are at a leaf
        if (node.left == null && node.right == null) {
            return -1;
        }
        return 1 + treeHeight(node.left) + treeHeight(node.right);
    }

    public static void main(String[] args) {
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
