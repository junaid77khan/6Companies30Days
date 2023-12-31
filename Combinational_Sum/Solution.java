package com.Junaid.ReviseWithArsh.Combinational_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        comb(1, k, n, ans, list);
        return ans;
    }
    private static void comb(int num, int k, int n, List<List<Integer>> ans, List<Integer> list) {
        if(n == 0) {
            if(k == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
        }
        if(k == 0 || num > 9) {
            return;
        }
        if(n < 0) return;
        list.add(num);
        comb(num+1, k-1, n-num, ans, list);
        list.remove(list.size()-1);
        comb(num+1, k, n, ans, list);
        // for(int i = num; i <= 9; i++) {
        //     list.add(i);
        //     comb(i+1, k-1, n-i, ans, list);
        //     list.remove(list.size()-1);
        // }
    }
}
