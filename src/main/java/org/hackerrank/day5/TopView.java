package org.hackerrank.day5;

import java.util.*;

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopView {
    // Method to print the top view
    public static void topView(Node root) {
        if (root == null) return;

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int hd = current.hd;
            Node node = current.node;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            if (node.left != null) queue.offer(new Pair(node.left, hd - 1));
            if (node.right != null) queue.offer(new Pair(node.right, hd + 1));
        }

        System.out.println("Top view of the binary tree:");
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
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
        String[] input = scan.nextLine().split(" ");

        Node root = null;
        for (String val : input) {
            int data = Integer.parseInt(val);
            root = insert(root, data);
        }

        System.out.print("In-order traversal: ");
        topView(root);
    }
}
