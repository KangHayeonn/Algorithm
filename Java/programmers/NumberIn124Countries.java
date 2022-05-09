// 124 나라의 숫자 (프로그래머스 LEVEL2)

import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        Map<Integer, String> matchMap = new HashMap<>();
        matchMap.put(1, "1");
        matchMap.put(2, "2");
        matchMap.put(0, "4");
        
        while(n > 0) {
            int remainder = n % 3;
            n = n / 3;
            
            if(remainder == 0) n--;         
            answer = matchMap.get(remainder) + answer;
        }
        return answer;
    }
}