package Programmers;

import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));

        long total = 0;
        for(int i  = 0 ; i < works.length; i++) {
            total += works[i];
            pq.add(works[i]);
        }
        if(total <= n) return 0;

        for(int i = 0 ; i< n; i++) {
            int w = pq.poll();
            //if(--w == 0 )continue;
            pq.add(--w);
        }
        for(int i = 0 ; i < pq.size(); i++) {
            int w = pq.poll();
            answer += (long)Math.pow(w,2);
        }

        return answer;
    }

    public static void main(String[] args) {
        야근지수 a = new 야근지수();
        int[] ary = {4,3,3};
        a.solution(4,ary    );
    }
}
