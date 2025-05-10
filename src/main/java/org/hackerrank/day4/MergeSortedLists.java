package org.hackerrank.day4;

import java.util.*;

public class MergeSortedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < n1; i++) {
            list1.add(sc.nextInt());
        }

        int n2 = sc.nextInt();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < n2; i++) {
            list2.add(sc.nextInt());
        }

        LinkedList<Integer> merged = new LinkedList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i++));
            }
            else {
                merged.add(list2.get(j++));
            }
        }

        // Add remaining elements
        while (i < list1.size()) {
            merged.add(list1.get(i++));
        }
        while (j < list2.size()) {
            merged.add(list2.get(j++));
        }

        // Output
        System.out.println("Merged Sorted List:");
        for (int num : merged) {
            System.out.print(num + " ");
        }

    }
}
