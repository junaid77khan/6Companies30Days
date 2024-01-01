package com.Junaid.ReviseWithArsh.Microsoft.Count_Number_of_Nice_Subarrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]%2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }
        return findSubArr( nums, k ) - findSubArr( nums, k-1 );
    }
    public static int findSubArr(int[] nums, int k) {
        int subArr = 0;
        int sum = 0;
        int t = 0;
        for(int h = 0; h < nums.length; h++) {
            sum += nums[h];

            while(t <= h && sum > k) {
                sum -= nums[t];
                t++;
            }

            subArr += (h - t + 1);
        }
        return subArr;
    }
}