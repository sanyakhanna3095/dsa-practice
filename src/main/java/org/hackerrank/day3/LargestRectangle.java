package org.hackerrank.day3;

import java.util.Scanner;

public class LargestRectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(sol(arr));
    }

    static int sol(int[] arr){
        int res=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            int cur=arr[i];

            for(int p=i-1; p>=0 && arr[p]>=arr[i]; p--){
                cur+=arr[i];
            }
            for(int p=i+1; p<arr.length && arr[p]>=arr[i]; p++){
                cur+=arr[i];
            }

            res=Math.max(res,cur);
        }
        return res;
    }
}
