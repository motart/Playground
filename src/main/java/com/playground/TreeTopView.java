package com.playground;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// TODO : Re-write this monstrosity
public class TreeTopView {
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    public static void topView(Node root) {
        TreeMap<Integer,Integer> memo = new TreeMap<>();
        TreeMap<Integer,Integer> memoRight = new TreeMap<>();
        TreeMap<Integer,Integer> memoLeft = new TreeMap<>();
        Integer position = 0;

        memoRight.put(position,root.data);
        topView(root.right,position + 1, memoRight, RIGHT);
        topView(root.left,position - 1, memoRight, LEFT);

        memoLeft.put(position,root.data);
        topView(root.left,position - 1, memoLeft, LEFT);
        topView(root.right,position + 1, memoLeft, RIGHT);

        memo.put(position,root.data);
        memo.putAll(memoRight.subMap(0,false,memoRight.lastKey(),true));
        memo.putAll(memoLeft.subMap(memoLeft.firstKey(),true,0,false));
        printMap(memo);
    }

    public static void printMap( TreeMap<Integer,Integer> memo) {
        for (Map.Entry<Integer,Integer> entry : memo.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void topView(Node root, Integer position, Map<Integer,Integer> memo, String direction) {
        if (root == null) {
            return;
        }
        Integer entry = memo.get(position);
        if (entry == null) {
            memo.put(position,root.data);
        }
        if (RIGHT.equals(direction)) {
            topView(root.right,position + 1 ,memo, direction);
            topView(root.left,position - 1 ,memo, direction);
        } else {
            topView(root.left,position - 1 ,memo, direction);
            topView(root.right,position + 1 ,memo, direction);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
