package org.hackerrank.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        List<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++){
           arr.add(sc.nextInt());
        }

        List<Integer> list=waiter(arr,q);
        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }

    static List<Integer> generatePrimes(int q){
        List<Integer> res = new ArrayList<>();
        int num = 2;
        while (res.size() < q) {
            boolean prime = true;
            for (int i=2;i<=Math.sqrt(num);i++) {
                if (num%i==0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                res.add(num);
            }
            num++;
        }
        return res;
    }
    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        List<Integer> prime=generatePrimes(q);
        List<Integer> res=new ArrayList<>();
        Stack<Integer> st1=new Stack<>();
        for(int i=0;i<number.size();i++){
            st1.push(number.get(i));
        }

        for(int i=0;i<q;i++){
            Stack<Integer> st2=new Stack<>();
            Stack<Integer> nonDivisible=new Stack<>();
            int p=prime.get(i);
            while(!st1.isEmpty()){
                int top=st1.pop();
                if(top%p==0){
                    st2.push(top);
                }
                else{
                    nonDivisible.push(top);
                }
            }
            while (!st2.isEmpty()) {
                res.add(st2.pop());
            }
            st1=nonDivisible;
        }
        while (!st1.isEmpty()) {
            res.add(st1.pop());
        }
        return res;

    }
}
