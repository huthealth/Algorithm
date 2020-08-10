package Etc;//https://www.acmicpc.net/problem/2003

import java.util.Scanner;

public class 백준투포인터 {
    public static void main(String... args) {
        int count = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] ary = new int[N];
        for(int i =0; i<N; i++) {
            ary[i] = sc.nextInt();
        }
        int lo = 0;
        int hi = 0;
        while(true) {
            if(sum >= M) {
                sum -= ary[lo];
                lo++;
            }
            else if( hi == N) {
                break;
            }
            else {
                sum += ary[hi];
                hi++;
            }
            if(sum == M) count++;
        }

        System.out.println(count);
    }
}
