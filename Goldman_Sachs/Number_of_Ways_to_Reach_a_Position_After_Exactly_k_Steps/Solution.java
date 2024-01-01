package com.Junaid.ReviseWithArsh.Goldman_Sachs.Number_of_Ways_to_Reach_a_Position_After_Exactly_k_Steps;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(numberOfWays(989, 1000, 99));
    }
    public static int numberOfWays(int s, int e, int steps) {
        int[][] dp = new int[4001][1001];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int diff = Math.abs(s-e);
        return findAll(s, e, steps, diff, dp);
    }

    public static int findAll(int s, int e, int steps, int rem, int[][] dp) {

        if(steps == 0 && rem == 0) return 1;

        if(steps == 0) return 0;

        if(steps < rem) return 0;

        if(dp[s+1001][steps] != -1) return dp[s+1001][steps];

        int ans = findAll( s + 1, e, steps - 1, Math.abs( ( s + 1 ) - e ), dp );
        ans += findAll( s - 1, e, steps - 1, Math.abs( ( s - 1 ) - e), dp );

        return dp[s+1001][steps] = ans%1000000007;
    }
}
