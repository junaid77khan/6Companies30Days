package com.Junaid.ReviseWithArsh.Microsoft.Bulls_and_Cows;

class Solution {

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }
    public static String getHint(String secret, String guess) {
        int[] check = new int[11];
        int bulls = 0;
        int cows = 0;

        for(int idx = 0; idx < secret.length(); idx++) {
            int i = secret.charAt(idx) - '0';
            int j = guess.charAt(idx) - '0';

            if( i == j ) bulls++;
            else {

                if( check[i] < 0 ) cows++;
                if( check[j] > 0) cows++;

                check[i]++;
                check[j]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}