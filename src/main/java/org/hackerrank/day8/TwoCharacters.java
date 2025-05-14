package org.hackerrank.day8;

import java.util.*;

public class TwoCharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(sol(s));
    }

    public static int sol(String s) {
        // Write your code here
        Set<Character> set=new HashSet<>();
        int res=0;
        for(char c:s.toCharArray()){
            set.add(c);
        }

        List<Character> list=new ArrayList<>(set);
        for(int i=0;i<set.size();i++){
            for(int j=i+1;j<set.size();j++){
                char a=list.get(i);
                char b=list.get(j);
                StringBuilder sb=new StringBuilder();
                for(char c:s.toCharArray()){
                    if(c==a||c==b){
                        sb.append(c);
                    }
                }
                if(isAlternating(sb)){
                    res=Math.max(res, sb.length());
                }
            }
        }
        return res;
    }

    static boolean isAlternating(StringBuilder sb){
        if(sb==null || sb.length()<=1){
            return false;
        }
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i)==sb.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}
