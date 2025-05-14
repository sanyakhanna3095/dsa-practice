package org.hackerrank.day8;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        fourPointerApproach(arr);
    }

    static void fourPointerApproach(int[][]arr){
        int m=arr.length;
        int n=arr[0].length;

        ArrayList<Integer> res=new ArrayList<>();
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(arr[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                res.add(arr[i][right]);
            }
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(arr[i][left]);
                }
                left++;
            }
        }
        printList(res);
    }

    private static void printList(ArrayList<Integer> res) {
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }
}
