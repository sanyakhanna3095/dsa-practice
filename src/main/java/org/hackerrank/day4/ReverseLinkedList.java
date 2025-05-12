package org.hackerrank.day4;

import java.io.*;
import java.util.*;

public class ReverseLinkedList {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter writer) throws IOException {
        while (node != null) {
            writer.write(String.valueOf(node.data));
            node = node.next;
            if (node != null) writer.write(sep);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.insertNode(value);
        }

        SinglyLinkedListNode reversedHead = reverse(list.head);
        printSinglyLinkedList(reversedHead, " ", writer);
        writer.newLine();

        writer.close();
        scanner.close();
    }
}

