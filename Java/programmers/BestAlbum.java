// 베스트앨범 (프로그래머스 LEVEL3)

// Hash, Map, PriorityQueue

import java.util.*;
import java.util.Map.Entry;

class Solution {
    public static class Type implements Comparable<Type> {
        private int idx;
        private int play;
        public Type(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        @Override
        public int compareTo(Type t) {
            if(t.play == this.play) return this.idx - t.idx;
            else return t.play - this.play;
        }
    }
    public static class Type2 implements Comparable<Type2> {
        private String s;
        private int totalPlay;
        public Type2(String s, int totalPlay) {
            this.s = s;
            this.totalPlay = totalPlay;
        }
        @Override
        public int compareTo(Type2 t) {
            return t.totalPlay - this.totalPlay;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>(); // key: genre, value: count
        Map<String, PriorityQueue<Type>> map = new HashMap<>();
        PriorityQueue<Type> pq2;
        
        for(int i=0; i<genres.length; i++) {
            String s = genres[i];
            if(!map.containsKey(s)) {
                pq2 = new PriorityQueue<>();
                pq2.add(new Type(i, plays[i]));
                map.put(genres[i], pq2);
                totalMap.put(genres[i], plays[i]);
            } else {
                map.get(genres[i]).add(new Type(i, plays[i]));
                totalMap.put(genres[i], totalMap.get(genres[i]) + plays[i]);
            }
        }

        List<Entry<String, Integer>> list = new ArrayList<>(totalMap.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(Entry<String, Integer> entry : list) {
            String key = entry.getKey();
            for(int i=0; i<2; i++) {
                if(map.get(key).isEmpty()) continue;
                result.add(map.get(key).poll().idx);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}