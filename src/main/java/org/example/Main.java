package org.example;

import java.util.Scanner;

public class Main {
    static final int[][]key={{0, 0},{0,1}, {0,2}, {1,1}, {2,0}, {2,1}, {2,2}};
//    static final int[] point={0,1,2};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int[][] arr=new int[6][6];
//        for(int i=0;i<6;i++){
//            for(int j=0;j<6;j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }

        int arr[][] =
                {
                        {-9, -9, -9,  1, 1, 1},
                        { 0, -9,  0,  4, 3, 2},
                        {-9, -9, -9,  1, 2, 3},
                        { 0,  0,  8,  6, 6, 0},
                        { 0,  0,  0, -2, 0, 0},
                        { 0,  0,  1,  2, 4, 0}
                };
        System.out.println(solBruteForce(arr));
    }

    static int solBruteForce(int[][] arr){
        int res=Integer.MIN_VALUE;
//        int sum=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+ arr[i+1][j+1]+ arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                System.out.print(sum+" ");
                res=Math.max(res,sum);
            }
        }
        System.out.println();
        System.out.println("_______");

        return res;
    }
}