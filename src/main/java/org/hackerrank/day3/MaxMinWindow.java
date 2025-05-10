package org.hackerrank.day3;

import java.util.Scanner;

public class MaxMinWindow {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] res=new int[n];
        for (int k = 1; k <= n; k++) {
            int maxOfMin = Integer.MIN_VALUE;
            for (int i = 0; i <= n - k; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i; j < i + k; j++) {
                    min = Math.min(min, arr[j]);
                }
                maxOfMin = Math.max(maxOfMin, min);
            }
            res[k - 1] = maxOfMin;
        }
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
}
