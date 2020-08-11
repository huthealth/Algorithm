package Programmers;

import java.util.Arrays;

public class ThreeN타일 {
    public static final int MOD = 1000000007;
    private long[] cache;

    public int solution(int n) {
        int answer = 0;
        cache = new long[n];
        Arrays.fill(cache,-1);
        answer = (int)tiling(0,n);
        return answer;
    }

    public long tiling(int now,int end){
        if(now == end) return 1;
        if(cache[now] != -1) return cache[now];

        cache[now] = 0;
        int specialCase = 4;
        while(true) {
            if(now + specialCase > end) break;
            cache[now] += (tiling(now+specialCase,end))*2 % MOD;
            specialCase += 2;
        }

        cache[now] += (tiling(now+2,end))*3 % MOD;
        return cache[now] % MOD;
    }

    public static void main(String... args){
        ThreeN타일 t = new ThreeN타일();
        System.out.println(t.solution(5000 ));
    }

}
