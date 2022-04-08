// N으로 표현 (프로그래머스 LEVEL3)

// dfs (재귀 이용)

import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int N, int number) {
        
        dfs(0, N, number, 0);

        return (answer!=0) ? answer : -1;
    }
    public static void dfs(int depth, int N, int target, int result) {
        if(depth > 8) return;
        if(target == result) {
            answer = (answer == 0) ? depth : Math.min(depth, answer);
            return;
        }
        
        int num = 0;
        // i는 사용한 횟수를 의미
        for(int i=1; i<9; i++) {
            num = num*10+N;
            dfs(depth+i, N, target, result+num);
            dfs(depth+i, N, target, result-num);
            dfs(depth+i, N, target, result*num);
            dfs(depth+i, N, target, result/num); // num이 0이 될 경우는 없으므로 조건문 생략
        }
    }
}