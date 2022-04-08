// bottom-up 방식

import java.util.*;

class Solution {
    static int[][] dp;
    static int answer = 0;
    public int solution(int[][] triangle) {
        int len = triangle.length;
        dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<len; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j==0) dp[i][j] = dp[i-1][j] + triangle[i][j];   
                else if(j==triangle[i].length-1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]; 
            }
        }
        
        for(int i=0; i<len; i++) {
            if(dp[len-1][i] > answer) answer = dp[len-1][i];
        }

        return answer;
    }
}