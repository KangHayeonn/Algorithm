// N으로 표현 (프로그래머스 LEVEL3)

// dp (bottom-up 방식)

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        int num = N;
        
        // 갯수를 기반으로 set배열의 0번째 인덱스에 넣어줌 (5, 55, 555, ...)
        Set<Integer>[] setArr = new HashSet[9];
        for(int i=1; i<9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(num);
            num = N + (num*10);
        }

        for(int i=1; i<9; i++) {
            for(int j=1; j<i; j++) {
                for(Integer x : setArr[j]) {
                    for(Integer y : setArr[i-j]) {
                        
                        // 덧셈
                        setArr[i].add(x + y);
                        
                        // 뺄셈 (두가지)
                        setArr[i].add(x - y); setArr[i].add(y - x);
                        
                        // 곱셈
                        setArr[i].add(x * y);
                        
                        // 나눗셈 (분모가 0이 아닐경우 두가지)
                        if(y != 0) setArr[i].add(x / y);
                        if(x != 0) setArr[i].add(y / x);

                    }
                }
            }
        }
        
        for(int i=1; i<9; i++) {
            if(setArr[i].contains(number)) {
                answer = i;
                break; // 이 부분 중요 (이게 있어야 최소값으로 answer에 저장됨)
            }
        }

        return (answer!=0) ? answer : -1;
    }
}