package com.Junaid.ReviseWithArsh.Find_Missing_And_Repeating;

import java.util.Arrays;

class Solve {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoElement(new int[]{1, 2, 2, 3}, 4)));
    }
    public static int[] findTwoElement(int[] arr, int n) {
        int[] check = new int[n+1];
        for(int val : arr) {
            check[val]++;
        }
        int[] ans = new int[2];

        for(int i = 1; i < n+1; i++) {
            if(check[i] == 2) ans[0] = i;
            if(check[i] == 0) ans[1] = i;
        }
        return ans;
    }
}
