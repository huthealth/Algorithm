package Programmers;

public class 멀리뛰기 {
    long[] cache;
    static final int mod = 1234567;
    int n;
    public long solution(int n) {
        this.n = n;
        cache = new long[n+1];
        long answer = 0;
        if(n == 1) return 1;
        dp(2);
        dp(1);
        for(long l : cache) System.out.println(l);
        return answer;
    }

    long dp(int now) {
        // System.out.println(now);
        if(now > n) return 0;
        if(now == n ) return 1;
        if(cache[now] != 0) return cache[now];

        cache[now] += dp(now+1) % mod;
        cache[now] += dp(now+2) % mod;
        return cache[now];
    }

    public static void main(String[] args) {
        멀리뛰기 a = new 멀리뛰기();
        a.solution(4);
    }
}