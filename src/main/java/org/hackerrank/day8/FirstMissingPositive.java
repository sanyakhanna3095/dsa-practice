package org.hackerrank.day8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

//        int res=bruteForce(arr);
        int res=inPlace(arr);
        System.out.println(res);
    }

    static int bruteForce(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                set.add(arr[i]);
            }
        }
        for(int i=1;i<=arr.length+1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    static int inPlace(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int val = nums[i];
                nums[i] = nums[val - 1];
                nums[val - 1] = val;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }


        return n+1;
    }
}
