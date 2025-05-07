package org.hackerrank.day2;

import java.util.HashSet;
import java.util.Scanner;

public class TwoStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        for(int i=0;i<p;i++){

        String s1=sc.next();
        String s2=sc.next();

        HashSet<Character> set=new HashSet<>();
        String res="NO";
        for(char c: s1.toCharArray()){
            set.add(c);
        }
        for(char c:s2.toCharArray()){
            if(set.contains(c)){
                res="YES";
            }
        }

            System.out.println(res);
        }
    }
}
