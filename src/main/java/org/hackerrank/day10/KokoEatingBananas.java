package org.hackerrank.day10;

import java.util.Scanner;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int h=sc.nextInt();
//        int k=bruteForce(arr,h);
        int k=binarySearch(arr, h);
        System.out.println(k);
    }


    static int bruteForce(int[] piles, int h){
        int max=0;

        for(int i=0;i<piles.length;i++){
            max=Math.max(piles[i], max);
        }

        for(int k=1;k<=max;k++){
            if(getTime(piles,k)<= h){
                return k;
            }
        }
        return max;
    }


    static int getTime(int[] arr, int k){
        int time=0;
        for(int i=0;i<arr.length;i++){
            time+=arr[i]/k;

            if(arr[i]%k !=0){
                time++;
            }
        }
        return time;
    }

    static int binarySearch(int[] arr, int h){
        int left = 1;
        int right = 0;
        for(int i=0;i<arr.length;i++){
            right = Math.max(right, arr.length);
        }
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (getTime(arr,mid)<= h) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }
}
