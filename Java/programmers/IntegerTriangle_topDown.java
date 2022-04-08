// top-down 방식

import java.util.*;

class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];     
        return dpFunc(0, 0, triangle);
    }
    public static int dpFunc(int i, int j, int[][] triangle) {
        if(i==triangle.length-1) return triangle[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        else return dp[i][j] = Math.max(dpFunc(i+1, j, triangle), dpFunc(i+1, j+1, triangle)) + triangle[i][j];
    }
}