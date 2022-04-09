// 도둑질 (프로그래머스 LEVEL4)

// dp (bottom-up)

import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dpFirst = new int[money.length]; // 첫번째 포함
        int[] dpLast = new int[money.length]; // 마지막 포함
        
        dpFirst[0] = money[0]; 
        dpFirst[1] = dpFirst[0];
        dpLast[1] = money[1];
        
        for(int i=2; i<money.length; i++) {
            dpFirst[i] = Math.max(dpFirst[i-2] + money[i], dpFirst[i-1]);
            dpLast[i] = Math.max(dpLast[i-2] + money[i], dpLast[i-1]);
        }
        
        return Math.max(dpFirst[money.length-2], dpLast[money.length-1]);
    }
}