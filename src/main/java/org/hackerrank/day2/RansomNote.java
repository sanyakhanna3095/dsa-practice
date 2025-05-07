package org.hackerrank.day2;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        String[] magazine=new String[m];
        for(int i=0;i<m;i++){
            magazine[i]=sc.next();
        }
        String[] note=new String[n];
        for(int i=0;i<n;i++){
            note[i]=sc.next();
        }
        HashMap<String, Integer> map=new HashMap<>();
        for(String s: magazine){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        String res="Yes";
        for(String s: note){
            if(!map.containsKey(s)){
                res="No";
            }
            else{
                if(map.get(s)>0){
                    map.put(s, map.get(s)-1);
                }
                else{
                    res="No";
                }
            }
        }

        System.out.println(res);
    }
}
