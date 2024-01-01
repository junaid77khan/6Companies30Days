package com.Junaid.ReviseWithArsh.Goldman_Sachs.Minimize_the_Maximum_of_Two_Arrays;
class Solution {
    public static void main(String[] args) {
        System.out.println(minimizeSet(2, 7, 1, 3));
    }
    public static int minimizeSet(int d1, int d2, int u1, int u2) {
        long start = 2;
        long end = (long)(10 * 1e9);
        long mid = start + (end - start)/2;

        while (start < end) {
            if( isValid((long)d1, (long)d2, (long)u1, (long)u2, mid) ) {
                end = mid;
            }
            else {
                start = mid+1;
            }
            mid = start + (end - start)/2;
        }

        return (int)mid;

    }
    public static boolean isValid(long d1, long d2, long u1, long u2, long mid) {
        long a = mid - (mid / d1);
        long b = mid - (mid / d2);
        long lcm = (d1 * d2) / gcd(d1, d2);
        long c = mid - (mid/d1) - (mid/d2) + mid/lcm;

        if(a >= u1 && b >= u2 && ( a + b - c ) >= ( u1 + u2 )) return true;
        return false;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}