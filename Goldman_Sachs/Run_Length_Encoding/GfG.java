package com.Junaid.ReviseWithArsh.Goldman_Sachs.Run_Length_Encoding;

public class GfG {
    public static void main(String[] args) {
        System.out.println(encode("abbbcdddd"));
    }
    public static String encode(String str)
    {
        StringBuilder ans = new StringBuilder();
        int len = 1;
        for(int idx = 1; idx < str.length(); idx++) {
            if(str.charAt(idx) == str.charAt(idx-1)) {
                len++;
            }
            else {
                ans.append(str.charAt(idx-1));
                ans.append(len);
                len = 1;
            }
        }
        ans.append(str.charAt(str.length()-1));
        ans.append(len);

        return ans.toString();
    }
}
