// 타겟 넘버 (프로그래머스 LEVEL2)

// dfs

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);      
        return answer;
    }
    public static void dfs(int count, int sum, int[] numbers, int target) {
        if(count==numbers.length) {
            if(sum==target) answer++;
            return;
        }
        
        dfs(count+1, sum+numbers[count], numbers, target);
        dfs(count+1, sum-numbers[count], numbers, target);
    }
}