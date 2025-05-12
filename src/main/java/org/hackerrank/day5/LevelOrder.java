package org.hackerrank.day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.hackerrank.day5.InOrderTraversal.insert;

public class LevelOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        Node root = null;
        for (String val : input) {
            int data = Integer.parseInt(val);
            root = insert(root, data);
        }

        System.out.print("In-order traversal: ");
        levelOrder(root);
    }

    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data+" ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }
}
