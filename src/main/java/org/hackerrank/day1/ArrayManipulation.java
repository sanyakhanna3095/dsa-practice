package org.hackerrank.day1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        Arrays.fill(arr, 0);

        int q_size=sc.nextInt();
        int[][] query=new int[q_size][3];
        for(int i=0;i<q_size;i++){
            for(int j=0;j<3;j++){
               query[i][j]=sc.nextInt();
            }
        }

        for(int[] q:query){
            int a=q[0];
            int b=q[1];
            int k=q[2];
            for(int i=a-1; i<b;i++){
                arr[i]+=k;
            }
        }

        int res=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            res=Math.max(res, arr[i]);
        }

        System.out.println(res);
    }
}
