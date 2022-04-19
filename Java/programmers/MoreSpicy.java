// 더 맵게 (프로그래머스 LEVEL2)

// 우선순위 큐

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x-y);
        
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int first = 0, second = 0;
        
        while(first < K) {
            first = pq.poll();
            
            if(pq.isEmpty()) {
                answer = (first >= K) ? answer : -1; // 16번 테스트 케이스 부분
                break;
            }
            
            second = pq.poll();
    
            if(first < K) {   
                pq.add(first + second*2);
                answer++;
            }
        }
        
        return answer;
    }
}