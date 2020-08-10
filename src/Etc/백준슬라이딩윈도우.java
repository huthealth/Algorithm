package Etc;//https://www.acmicpc.net/problem/2075


import java.util.Arrays;
import java.util.Scanner;

public class 백준슬라이딩윈도우 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] ary = new int[N*N];
        for(int i =0;i<N*N;i++) {
            ary[i] = sc.nextInt();
        }
        Arrays.sort(ary);
        int answer = ary[N*N -N];
        System.out.println(answer);
    }
}
