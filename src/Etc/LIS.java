package Etc;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {
    public static int[] cache = new int[100];
    public static int[] ary;
    public static int L;
    public static int getMaxLength(int now){
        if(now == L-1) return 1;

        if(cache[now] != -1) return cache[now];
        cache[now] = 1;
        for(int i = 1; i< L-now; i++) {
            if(ary[now] < ary[now+i]) {
                cache[now] = Math.max(cache[now], getMaxLength(now+i)+1);
            }
        }
        return cache[now];
    }
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for(int i  =0; i<C;i++) {
            L = sc.nextInt();
            ary = new int[L];
            cache = new int[L];
            Arrays.fill(cache,-1);
            for(int j =0; j<L ;j++) {
                ary[j] = sc.nextInt();
            }

            int answer = 0;
            for(int j = 0;j<L;j++) {
                answer = Math.max(answer,getMaxLength(j));
            }
            System.out.println(answer);
        }
    }
}
