class Solution {
    static boolean[] visited;
    static String t;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        t = target;
        
        visited = new boolean[words.length];
        answer = dfs(0, begin, words);
        answer = (answer != Integer.MAX_VALUE) ? answer : 0;
        
        return answer;
    }
    public static int dfs(int count, String begin, String[] words) {

        // equals() 함수 내부에서 자동으로 null 체크
        if(t.equals(begin)) {
            return count;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<words.length; i++) {
            if(!visited[i]) {
                String str = words[i];
                int cnt = 0;

                for(int j=0; j<str.length(); j++) {
                    if(begin.charAt(j) != str.charAt(j)) cnt++;
                }

                if(cnt==1) {
                    visited[i] = true;
                    min = Math.min(dfs(count+1, str, words), min);
                    visited[i] = false;
                }
            }
        }
        
        return min;
    }
}