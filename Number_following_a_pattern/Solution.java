package com.Junaid.ReviseWithArsh.Number_following_a_pattern;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(printMinNumberForPattern("IIDDD"));
    }

    static String printMinNumberForPattern(String S){
        StringBuilder str = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int curr = 1;

        for(int idx = 0; idx < S.length(); idx++) {
            if(S.charAt(idx) == 'D') {
                stack.push(curr);
                curr++;
            }
            else {
                stack.push(curr);
                curr++;

                while(stack.size() > 0) {
                    str.append(stack.pop());
                }
            }
        }
        stack.push(curr);
        while(stack.size() > 0) {
            str.append(stack.pop());
        }

        return str.toString();
    }
}
