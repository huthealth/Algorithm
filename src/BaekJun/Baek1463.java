package BaekJun;

import java.util.Arrays;
import java.util.Scanner;

public class Baek1463 {
    static int[] cache;
    final static int INF = 999999999;

    static int countNum(int num){
        if(num <=1){
            if(num == 1) return 0;
            return INF;
        }

        if(cache[num] != -1) return cache[num];
        cache[num] = INF;

        if( num %3 ==0) cache[num] = Math.min(cache[num], countNum(num/3) +1);
        if(num %2 == 0) cache[num] = Math.min(cache[num], countNum(num/2) +1);
        cache[num] = Math.min(cache[num], countNum(num-1) +1);

        return cache[num];
    }

    public static void main(String... args){
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cache = new int[N+1];
        Arrays.fill(cache,-1);
        System.out.println(countNum(N));
    }
}
