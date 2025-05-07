package org.hackerrank.day2;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashset {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<t;i++){
            String s=sc.nextLine();
            String[] arr=s.split(" ");
            String str1=arr[0]+" "+arr[1];
            String str2=arr[1]+" "+arr[0];
            if(!set.contains(str1) && !set.contains(str2)){
                set.add(str1);
            }
            System.out.println(set.size());
        }
    }

}
