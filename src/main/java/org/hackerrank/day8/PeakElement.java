package org.hackerrank.day8;

import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

//        Binary search as time complexity constraint of O(log(n))
//        int res=binarySearch(arr);

        int res=recursive(arr, 0, n-1);
        System.out.println(res);
    }


    static int binarySearch(int[] arr){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid= left + (right-left)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]> arr[mid+1]){
                return mid;
            }
            else if(arr[mid+1]< arr[mid]){
                right=mid;
            }
            else {
                left= mid+1;
            }
        }
        return left;
    }

    static int recursive(int[] arr, int left, int right){
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if(arr[mid]>arr[mid-1] && arr[mid]> arr[mid+1]){
            return mid;
        }
        else if (arr[mid+1]< arr[mid]) {
            return recursive(arr, left, mid);
        }
        else {
            return recursive(arr, mid+1, right);
        }
    }
}
