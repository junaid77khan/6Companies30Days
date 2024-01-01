package com.Junaid.ReviseWithArsh.Microsoft.Circle_and_Rectangle_Overlapping;

public class Solution {

    public static void main(String[] args) {
        System.out.println(checkOverlap(4, 102, 50, 0, 0,100 ,100));
    }
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int Xn = (int) Math.max( (int)Math.min(x2, xCenter), x1 );
        int Yn = (int) Math.max( (int)Math.min(y2, yCenter), y1 );

        int diff1 = Math.abs(Xn - xCenter);
        int diff2 = Math.abs(Yn - yCenter);

        return (diff1*diff1) + (diff2*diff2) <= radius*radius;
    }
}
