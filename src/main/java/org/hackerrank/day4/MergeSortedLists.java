package org.hackerrank.day4;

import java.util.Scanner;

public class MergeSortedLists {

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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        SinglyLinkedListNode head;

        if (head1.data <= head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode current = head;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) current.next = head1;
        else current.next = head2;

        return head;
    }

    static void printList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            SinglyLinkedList list1 = new SinglyLinkedList();
            int n1 = scanner.nextInt();
            for (int i = 0; i < n1; i++) {
                list1.insertNode(scanner.nextInt());
            }

            SinglyLinkedList list2 = new SinglyLinkedList();
            int n2 = scanner.nextInt();
            for (int i = 0; i < n2; i++) {
                list2.insertNode(scanner.nextInt());
            }

            SinglyLinkedListNode mergedHead = mergeLists(list1.head, list2.head);
            printList(mergedHead);

    }
}
