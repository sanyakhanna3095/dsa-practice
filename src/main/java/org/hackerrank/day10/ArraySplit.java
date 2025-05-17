package org.hackerrank.day10;

public class ArraySplit {
    public static void main(String[] args) {

    }

    static int sol(int[] nums, int k){
    int start=0, end=0;

        for(int num : nums){
        start = Math.max(start, num);
        end += num;
    }

    int ans = start;
        while(start <= end){
        int mid = start + (end - start) / 2;

        if (isPossibleSplitsFound(nums, mid, k)){
            ans = mid;
            end = mid - 1;
        } else start = mid + 1;
    }
        return ans;
}

private static boolean isPossibleSplitsFound(int[] nums, int mid, int m) {

    int sum = 0;
    int splits = 1;
    for (int num : nums) {
        sum += num;
        if (sum > mid) {
            sum = num;
            splits++;
        }
    }
    return splits <= m;
}
}
