package BaekJun.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내려가기2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[N][3];
        int[][] maxWindow = new int[2][3];
        int[][] minWindow = new int[2][3];
        int max,min;
        for(int i = 0; i< N; i++) {
            String[] inputs = br.readLine().split(" ");
            ary[i][0] = Integer.parseInt(inputs[0]);
            ary[i][1] = Integer.parseInt(inputs[1]);
            ary[i][2] = Integer.parseInt(inputs[2]);
        }
        for(int i = 0 ; i<3; i++) {
            maxWindow[0][i] = maxWindow[1][i] = minWindow[0][i] = minWindow[1][i]= ary[0][i];
        }
        for(int i = 1; i<N; i++) {
            maxWindow[1][0] = ary[i][0] + Math.max(maxWindow[0][0],maxWindow[0][1]);
            maxWindow[1][1] = ary[i][1] + Math.max(maxWindow[0][0],Math.max(maxWindow[0][1],maxWindow[0][2]));
            maxWindow[1][2] = ary[i][2] + Math.max(maxWindow[0][1],maxWindow[0][2]);
            maxWindow[0][0] = maxWindow[1][0];
            maxWindow[0][1] = maxWindow[1][1];
            maxWindow[0][2] = maxWindow[1][2];

            minWindow[1][0] = ary[i][0] + Math.min(minWindow[0][0],minWindow[0][1]);
            minWindow[1][1] = ary[i][1] + Math.min(minWindow[0][0],Math.min(minWindow[0][1],minWindow[0][2]));
            minWindow[1][2] = ary[i][2] + Math.min(minWindow[0][1],minWindow[0][2]);
            minWindow[0][0] = minWindow[1][0];
            minWindow[0][1] = minWindow[1][1];
            minWindow[0][2] = minWindow[1][2];
        }

        max = -1;
        min = Integer.MAX_VALUE;
        for(int i = 0 ; i<3; i++) {
            if(max < maxWindow[1][i]) max = maxWindow[1][i];
            if(min > minWindow[1][i]) min = minWindow[1][i];
        }
        System.out.println(max+" "+ min);
    }
}
