package Etc;

import java.util.*;

public class Programmers42897 {
    public static int[] house;
    public static int[][] cache;
    public static int N;

    public static  int getMoney(int leftHouses,int now,int[] money){
        if(leftHouses <=2){
            return money[now];
        }
        if(cache[leftHouses][now] != -1) return cache[leftHouses][now];

        int countNow=0,count1=0,count2=0;
        house[now] =1;
        countNow = 1;
        if(house[(now+1)%N] == 0) {
            count1 =1;
            house[(now+1)%N] =1;
        }
        if(house[(now+N-1)%N] ==0) {
            count2 = 1;
            house[(now+N-1)%N] = 1;
        }

        cache[leftHouses][now] =0;
        for(int i =0;i<N;i++) {
            if(house[i] ==0){
                cache[leftHouses][now] = Math.max(cache[leftHouses][now],getMoney(leftHouses-countNow-count1-count2,i,money));
            }
        }
        house[now] = 0;
        if(count1 ==1) house[(now+1)%N] = 0;
        if(count2 ==1) house[(now+N-1)%N] = 0;
        cache[leftHouses][now] +=money[now];
        return cache[leftHouses][now];
    }
    public static int solution(int[] money) {
        int answer = 0;
        N = money.length;
        house = new int[N];
        cache = new int[N+1][N];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<N;j++) cache[i][j] = -1;
        }

        for(int i=0;i<N;i++){
            answer = Math.max(answer,getMoney(N,i,money));
            Arrays.fill(house,0);
            System.out.println(answer);
        }
        return answer;
    }

    public static void main(String... args){
        int[] money = {100,20,30,400,50,60};
        System.out.println("정답은"+solution(money));
    }
}
