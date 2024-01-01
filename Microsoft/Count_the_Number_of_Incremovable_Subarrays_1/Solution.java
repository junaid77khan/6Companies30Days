package com.Junaid.ReviseWithArsh.Microsoft.Count_the_Number_of_Incremovable_Subarrays_1;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {8,7,6,6};
        System.out.println(incremovableSubarrayCount(arr));
    }
    public static int incremovableSubarrayCount(int[] arr) {
        int ans = 0;

        for (int l = 0; l < arr.length; l++) {

            boolean till_l = true;
            for (int i = 0; i < l - 1; i++) {
                if (arr[i] >= arr[i + 1]) {
                    till_l = false;
                    break;
                }
            }

            if (till_l) {

                boolean from_r = true;
                for (int i = l + 1; i < arr.length - 1; i++) {
                    if (arr[i] >= arr[i + 1]) {
                        from_r = false;
                        break;
                    }
                }
                for (int r = l; r < arr.length; r++) {

                    if (!(from_r)) {
                        from_r = true;
                        for (int i = r + 1; i < arr.length - 1; i++) {
                            if (arr[i] >= arr[i + 1]) {
                                from_r = false;
                                break;
                            }
                        }
                    }

                    if (from_r) {
                        if (l > 0 && r < arr.length - 1) {
                            if (arr[l - 1] < arr[r + 1])
                                ans++;
                        } else {
                            ans++;
                        }
                    }
                }
            }

        }
        return ans;
    }
}
