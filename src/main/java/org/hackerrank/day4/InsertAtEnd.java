package org.hackerrank.day4;

import java.util.Scanner;

public class InsertAtEnd {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) return newNode;

        SinglyLinkedListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        SinglyLinkedListNode head = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            head = insertNodeAtTail(head, data);
        }

        printList(head);
    }
}

