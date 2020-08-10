package BaekJun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baek1697 {
    public static int INF = Integer.MAX_VALUE;
    public static int sister;
    public static int[] cache;
    public static void main(String... args) {
        //int[] map = new int[100000];
        cache = new int[100000];
        Arrays.fill(cache,-1);
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        sister = sc.nextInt();
        int time = 0;
        int answer = INF;

        answer = findAndSeek(subin,0);
        System.out.println(answer);
    }
    public static int findAndSeek(int now, int time) {
        //System.out.println(now + " " + time);
        if(now >= 100000 || now < 0 || time > 30) return INF;
        if(now == sister) {
            System.out.println("찾았다! "+time );
            return time;
        }

        if(cache[now] != -1) {
             return INF;
        }

        cache[now] = INF;

        //int answer = INF;
        cache[now]  = Math.min(cache[now] ,findAndSeek(now+1,time+1));
        cache[now]  = Math.min(cache[now] ,findAndSeek(now-1,time+1));
        cache[now]  = Math.min(cache[now] ,findAndSeek(2*now,time+1));
        return cache[now] ;
    }
}
