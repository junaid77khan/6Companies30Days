package com.Junaid.ReviseWithArsh.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        // return phonePadList("", digits);
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        return phonePadMap("", digits, map);
    }

    private static List<String> phonePadMap(String p, String up, HashMap<String, String> map) {
        List<String> ans = new ArrayList<>();
        if(up.isEmpty()) {
            ans.add(p);
            return ans;
        }
        String chars = map.get(up.substring(0,1));
        for(int i = 0; i < chars.length(); i++) {
            List<String> temp = phonePadMap(p+chars.charAt(i), up.substring(1), map);
            ans.addAll(temp);
        }
        return ans;
    }
    private static List<String> phonePadList(String p, String up) {
        List<String> ans = new ArrayList<>();
        if(up.isEmpty()) {
            ans.add(p);
            return ans;
        }
        int start;
        int end;
        int digit = up.charAt(0) - '0';
        if(digit <= 6) {
            start = (digit - 2)*3;
            end = (digit-1)*3;
        }
        else if(digit == 7) {
            start = (digit - 2)*3;
            end = (digit-1)*3 + 1;
        }

        else if(digit == 8) {
            start = (digit - 2)*3 + 1;
            end = (digit-1)*3 + 1;
        }

        else {
            start = (digit - 2)*3 + 1;
            end = (digit-1)*3 + 2;
        }
        for(int i = start; i < end; i++) {
            char ch = (char)('a' + i);
            List<String> temp = phonePadList(p+ch, up.substring(1));
            ans.addAll(temp);
        }
        return ans;
    }
}
