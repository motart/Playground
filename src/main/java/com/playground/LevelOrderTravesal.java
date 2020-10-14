package com.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevelOrderTravesal {
    public static void levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        int level = 0;
        levelOrder(root,level,levels);
        for (List<Integer> element : levels) {
            for (int value : element) {
                System.out.print(value + " ");
            }
        }
    }

    public static void levelOrder(Node root, int level, List<List<Integer>> levels) {
        if (root == null) {
            return;
        }
        addToList(root.data,level,levels);
        levelOrder( root.left,level + 1, levels);
        levelOrder( root.right,level + 1, levels);
    }

    public static void addToList(int data, int level, List<List<Integer>> levels) {
        List<Integer> levelData = new ArrayList<>();
        if (levels.size() > level) {
            levelData = levels.get(level);
        }

        if (levelData == null) {
            List<Integer> newLevelData = new ArrayList<>();
            newLevelData.add(data);
            levels.add(level,newLevelData);
        } else {
            levelData.add(data);
            if (levels.size() > level) {
                levels.set(level,levelData);
            } else {
                levels.add(level,levelData);
            }
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
        levelOrder(root);
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
