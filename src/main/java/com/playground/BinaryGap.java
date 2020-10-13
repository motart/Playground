package com.playground;

public class BinaryGap {
    public static int solution(int N) {
        // write your code in Java SE 8
        int result = 0;
        String intString = Integer.toBinaryString(N);
        String[] intSplitString = intString.split("1");
        int memo = 0;
        for (int i=0; i<intSplitString.length; i++) {
            if (intString.charAt(memo) == '1' && intString.charAt(memo + intSplitString[i].length()) == '1'){
                if (intSplitString[i].length() > result) {
                    result = intSplitString[i].length();
                }
            }
            memo = memo + intSplitString[i].length();
        }
        return result;
    }

    public static void main (String[] args) {
        System.out.println(solution(1041));
    }
}
