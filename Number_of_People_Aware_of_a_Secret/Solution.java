package com.Junaid.ReviseWithArsh.Number_of_People_Aware_of_a_Secret;

public class Solution {
     static long mod = (long)(1e9 + 7);

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4));
    }
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long[][] dp = new long[n][n+forget];
        int day = 0;
        long[] check = new long[n];
        dp[ day ][ day + forget ] = 1;
        check[day] = 1;
        day++;
        while(day < n) {
            for(int idx = 0; idx < day; idx++) {
                if(dp[idx][day] > 0) {
                    dp[idx][day] = 0;
                    check[idx] = 0;
                }
                else {
                    if(day - idx >= delay && check[idx] > 0) {
                        check[day] = (check[day]+check[idx])%mod;
                        dp[day][day+forget] = (dp[day][day+forget] + check[idx]) % mod;
                    }
                }
            }
            day++;
        }
        long ans = 0;
        for(long ele : check) ans = (ans + ele) % mod;
        return (int)(ans % mod);
    }
}
