package org.hackerrank.day3;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        for(int a:arr){
            st1.push(a);
        }

        while(!st1.isEmpty()){
            System.out.print(st1.peek()+" ");
            st2.push(st1.pop());
        }
        System.out.println();
        while(!st2.isEmpty()){
            System.out.println(st2.pop());
        }

    }
}
