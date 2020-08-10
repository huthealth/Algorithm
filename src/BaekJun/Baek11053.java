package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek11053 {
    static int[] ary;
    static int[] cache;
    static int length;

    public static int getLength(int now){
        if(now == length-1) return 1;

        if(cache[now] != -1) return cache[now];

        cache[now] = 1;
        for(int i =1;i<length-now;i++){
            if(ary[now] < ary[now+i]) cache[now] = Math.max(cache[now],getLength(now+i)+1);
        }

        return cache[now];
    }

    public static void main(String[] args)throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        //length = sc.nextInt();
        ary = new int[length];
        cache = new int[length];
        for(int i =0;i<length;i++) cache[i] = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<length;i++) ary[i] = Integer.parseInt(st.nextToken());


        int answer = 0;
        for(int i =length-1;i>=0;i--){
            answer = Math.max(answer,getLength(i));
        }
        System.out.println(answer);
    }
}
