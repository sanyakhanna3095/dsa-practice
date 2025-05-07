package org.hackerrank.day1;

import java.util.Scanner;

public class CommonChild {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s1=sc.nextLine();
        String s2=sc.nextLine();


//        Order is not maintained in this case so, it is also considering common elements not in order
        /*boolean[] visited=new boolean[26];

        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            for(int j=0;j<s1.length();j++){
                if(ch==s1.charAt(j)){
                    visited[ch-'A']=true;
                }

            }
        }
        for (int i=0;i<26;i++){
            System.out.println(i + ": "+visited[i]);
        }

        int cnt=0;

        for(int i=0;i<26;i++){
            if (visited[i]==true){
                cnt++;
            }
            else {
                visited[i]=false;
            }
        }

        System.out.println(cnt);

         */

        System.out.println(sol(s1,s2,0,0));
    }

    public static int sol(String s1, String s2, int i, int j){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }

        int cnt=0;
        if(s1.charAt(i)==s2.charAt(j)){
            cnt=1+sol(s1,s2,i+1,j+1);
        }
        else {
            cnt=Math.max(sol(s1,s2,i,j+1), sol(s1,s2,i+1,j));
        }

        return cnt;
    }
}
