// 게임 맵 최단거리 (프로그래머스 LEVEL2)

// bfs

import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0}; // 동 서 남 북
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    public static class Type {
        private int x; // 열
        private int y; // 행
        private int count;
        public Type(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public int solution(int[][] maps) {
        // int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(0, 0, maps, visited); // (1, 1) 대신 (0, 0)부터 시작하는 것으로 설정
        return answer;
    }
    public static void bfs(int x, int y, int[][] maps, boolean[][] visited) {
        Queue<Type> q = new LinkedList<>();
        q.add(new Type(x, y, 1)); // 처음 시작 점도 포함해서 count = 1 부터

        while(!q.isEmpty()) {
            Type t = q.poll();
            visited[t.y][t.x] = true;

            if(t.x == (maps[0].length-1) && t.y == (maps.length-1)) {
                answer = t.count;
                return;
            }
            for(int i=0; i<4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length) continue;

                if(!visited[ny][nx] && maps[ny][nx]==1) {
                    q.add(new Type(nx, ny, t.count+1));
                    visited[ny][nx] = true; /// 시간초과를 해결하기 위해서
                }
            }
        }

        answer = -1;
        return;
    }
}