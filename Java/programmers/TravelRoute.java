// 여행경로 (프로그래머스 LEVEL3)

// dfs (문제를 좀 더 쉽게 접근하려고 노력하기)

import java.util.*;

class Solution {
    static ArrayList<String> answers;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] result = answers.get(0).split(" ");
        return result;
    }
    public static void dfs(int count, String now, String answer, String[][] tickets) {
        if(count==tickets.length) {
            answers.add(answer);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(count+1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}