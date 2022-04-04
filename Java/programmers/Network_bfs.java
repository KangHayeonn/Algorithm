// 네트워크 (프로그래머스 LEVEL3)

// bfs

import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0; // 처음 시작 한개부터
        visited = new boolean[computers.length];
        
        // 다른 정점으로 연결되어 있는 네트워크가 있을 수도 있으므로 (정점 모두를 체크)
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i, visited, computers);
            }
        }
        
        return answer;
    }
    public static void bfs(int v, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        
        while(!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true;
            
            for(int i=0; i<computers[x].length; i++) {
                if(computers[x][i]==1 && !visited[i]) {
                    q.add(i);
                }
            }
        }
    }
}