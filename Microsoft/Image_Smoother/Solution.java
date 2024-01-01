package com.Junaid.ReviseWithArsh.Microsoft.Image_Smoother;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] img = {
                {100, 200, 100}, {200, 50, 200}, {100, 200, 100}
        };
        System.out.println(Arrays.deepToString(imageSmoother(img)));
    }

    public static int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int sum = 0;
                int count = 0;

                for(int n = i - 1; n <= i + 1; n++) {
                    for(int m = j - 1; m <= j + 1; m++) {
                        if(n >=0 && n < row && m >= 0 && m < col) {
                            sum += img[n][m] & ((1<<8) - 1);
                            count++;
                        }
                    }
                }

                img[i][j] |= (sum/count)<<8;
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                img[i][j] >>= 8;
            }
        }
        return img;
    }
//    public static int[][] imageSmoother(int[][] img) {
//        int row = img.length;
//        int col = img[0].length;
//        int prevele = 0;
//        int[] prev = new int[img[0].length];
//
//        for(int i = 0; i < row; i++) {
//            for(int j = 0; j < col; j++) {
//                if(j-1 >= 0) {
//                    prevele = img[i][j-1];
//                }
//                int sum = 0, count = 0;
////                next row neighbour
//                if(i + 1 < row) {
//                    if(j - 1 >= 0)  {
//                        sum += img[i + 1][j - 1];
//                        count++;
//                    }
//                    sum += img[i + 1][j];
//                    count++;
//
//                    if(j + 1 < col) {
//                        sum += img[i + 1][j + 1];
//                        count++;
//                    }
//                }
//
////                curr row neighbour
//                sum += img[i][j];
//                count++;
//                if( j - 1 >= 0) {
//                    sum += prevele;
//                    count++;
//                }
//                if(j + 1 < col) {
//                    sum += img[i][j + 1];
//                    count++;
//                }
//
////                prev row neighbour
//                if(i - 1 >= 0) {
//                    if(j - 1 >= 0) {
//                        sum += prev[j - 1];
//                        count++;
//                    }
//                    sum += prev[j];
//                    count++;
//                    if(j + 1 < col) {
//                        sum += prev[j + 1];
//                        count++;
//                    }
//                }
//                img[i][j] = sum/count;
//            }
//            prev = Arrays.copyOf(img[i], img[i].length);
//        }
//        return img;
//    }
}
