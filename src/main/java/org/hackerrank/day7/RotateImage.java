package org.hackerrank.day7;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateImage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }

//        bruteforce
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=n-1; i>=0;i--){
            ArrayList<Integer> l=new ArrayList<>();
            for(int j=0;j<n;j++){
                l.add(arr[i][j]);
            }
            list.add(l);
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=list.get(j).get(i);
            }
        }

        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
