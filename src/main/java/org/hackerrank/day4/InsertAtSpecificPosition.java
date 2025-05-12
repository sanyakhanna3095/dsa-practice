package org.hackerrank.day4;

import java.util.Scanner;

public class InsertAtSpecificPosition {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtSpecificPosition(SinglyLinkedListNode head, int data, int pos) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }

        SinglyLinkedListNode curr = head;
        for (int i = 0; i < pos - 1 ; i++) {
            curr = curr.next;
        }

            newNode.next = curr.next;
            curr.next = newNode;


        return head;
    }

    static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // Number of elements in initial list
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int dataToInsert = sc.nextInt();
        int position = sc.nextInt();

        head = insertNodeAtSpecificPosition(head, dataToInsert, position);
        printList(head);
    }
}
