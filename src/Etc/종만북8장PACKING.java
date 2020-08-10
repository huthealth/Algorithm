package Etc;

import java.util.Arrays;
import java.util.Scanner;

public class 종만북8장PACKING {
    static String[] name;
    static Integer[] weight;
    static Integer[] want;
    static Integer[] picked;

    static int[][] cache;
    static int N;
    static int W;
    static int numOfPick;
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int C = Integer.parseInt(sc.nextLine());
        for(int i = 0 ;i<C;i++) {

            String[] nw = sc.nextLine().split(" ");
            N = Integer.parseInt(nw[0]);
            W = Integer.parseInt(nw[1]);

            name = new String[N];
            weight = new Integer[N];
            want = new Integer[N];
            picked = new Integer[N];
            cache = new int[N][W+1];

            for(int j = 0; j<N;j++){
                String[] str = sc.nextLine().split(" ");
                name[j] = str[0];
                weight[j] = Integer.parseInt(str[1]);
                want[j] = Integer.parseInt(str[2]);
            }


            for(int j = 0; j<N;j++) Arrays.fill(cache[j],-1);

            numOfPick = 0;
            int maxWant = packing(0,W);
            System.out.println(packing(0,W)+" "+numOfPick);
            for(int j  =0;j<N;j++) {
                if(picked[j] == 1) System.out.println(name[j]);
            }

        }
    }
    static int packing(int now, int w) {
        if(now == N) return 0;
        if(cache[now][w] != -1) return cache[now][w];

        int nowW = weight[now];
        int pick = -1;
        int noPick;
        noPick = packing(now+1,w);
        if( w - nowW >= 0) pick = packing(now+1,w - nowW) + want[now];
        if(noPick > pick) cache[now][w] = noPick;
        else {
            cache[now][w] = pick;
            numOfPick++;
            picked[now] = 1;
        }
        return cache[now][w];
    }
}
