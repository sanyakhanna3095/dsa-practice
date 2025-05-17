package org.hackerrank.day11;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingScheduling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(optimised(arr));
    }

    static boolean sol(int[][] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                if((arr[j][0]>arr[i][0] && arr[j][0]>arr[i][1]) || (arr[j][1]>arr[i][0] && arr[j][1]>arr[i][1])){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean optimised(int[][] arr){
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0], b[0]));

        for(int i=1;i< arr.length;i++){
            if(arr[i][0]<arr[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
