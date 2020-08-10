package BaekJun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Baek2133 {
    public static List<Integer> pattern = new ArrayList<>();
    public static int[] cache;
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache = new int[N+1];
        Arrays.fill(cache,-1);

        pattern.add(2);
        pattern.add(2);
        pattern.add(2);
        for(int i =4; i<=30; i += 2){
            pattern.add(i);
            pattern.add(i);
        }

        System.out.println(tiling(N));
    }

    public static int tiling(int now){
        if(now == 0) return 1;
        if(now < 0) return 0;

        if(cache[now] != -1) return cache[now];
        cache[now] = 0;
        for(int i =0;i< pattern.size();i++) {
            cache[now] +=tiling(now - pattern.get(i));
        }
        return cache[now];
    }
}
