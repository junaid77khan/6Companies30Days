package com.Junaid.ReviseWithArsh.Microsoft.Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,10,2,9} ;
        System.out.println(minMoves2(arr));
    }
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            ans += nums[e] - nums[s];
            s++;
            e--;
        }
        return ans;
    }
}
