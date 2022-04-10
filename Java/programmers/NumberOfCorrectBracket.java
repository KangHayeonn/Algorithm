// 올바른 괄호의 개수 (프로그래머스 LEVEL4)

// ver 2 : 로직 변경 (성공)
/* [ 로직 ]
 * 1. 왼쪽 부터 세워줌
 * 2. 왼쪽보다 오른쪽의 카운트가 더 많을 경우 바로 return -> ex. ) or  ())
 * 3. 왼쪽이랑 오른쪽이 같을 경우 or 왼쪽이 더 많을 경우는 dfs
 * 4. 만약 왼쪽이랑 오른쪽의 갯수가 주어진 n과 같아지면 그때 count
 */
// dfs : 괄호를 직접 세우지 않고 '('': 좌 ')': 우 의 갯수만 카운트

import java.util.*;

class Solution {
    static int count = 0; // 올바른 괄호일 경우에 저장
    public int solution(int n) {
        dfs(0, 0, n);
        return count;
    }
    public static void dfs(int left, int right, int total) {
        if(right > left || left > total) return;
        if(left == total && right == total) {
            count++;
            return;
        }
        dfs(left+1, right, total);
        dfs(left, right+1, total);
    }
}

/* -------------------------------------------------------- */

// ver 1 : 시간초과 (실패)
// dfs : 괄호 세우기
// stack : 올바른 괄호 찾기

/*
import java.util.*;

class Solution {
    static Set<String> set; // 올바른 괄호일 경우에 저장
    public int solution(int n) {
        set = new HashSet<>();
        String s = "";

        for(int i=0; i<n; i++) {
            s += "()";
        }

        boolean[] visited = new boolean[s.length()];
        dfs(0, "", s, visited);

        return set.size();
    }
    // 괄호 세우기
    public static void dfs(int depth, String chkS,  String s, boolean[] visited) {
        if(depth==s.length()){
            if(isBracket(chkS)) {
                set.add(chkS);
            }
            return;
        }

        for(int i=0; i<s.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, chkS+s.charAt(i), s, visited);
                visited[i] = false;
            }
        }

    }
    // 올바른 괄호인지 체크
    public static boolean isBracket(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.charAt(0) == ')') return false;
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == ')') stack.pop();
            else stack.push(s.charAt(i));
        }
        return (stack.isEmpty()) ? true : false;
    }
}
*/