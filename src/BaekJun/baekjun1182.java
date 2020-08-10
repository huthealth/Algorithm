package BaekJun;

import java.util.Scanner;

public class baekjun1182{
    public static int N;
    public static int[] ary;
    public static int T;
    public static void main(String... args){
        int answer =0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T =sc.nextInt();
        ary = new int[N];
        for(int i =0;i<N;i++) ary[i] = sc.nextInt();
        for(int i=1;i<1<<N;i++){
            int sum =0;
            for(int j=1,cnt=0; cnt<N;j = 1<<cnt,cnt++){
                if((j & i) != 0 ) sum+=ary[cnt];
            }
            if(T == sum) answer++;
        }
        System.out.println(answer);

    }
}