package org.hackerrank.day1;

import java.util.Scanner;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        reverse(arr, 0, n-1);
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);

        System.out.println("Rotated array: ");
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void reverse(int[] arr, int start, int end){
        while(start<end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
}
