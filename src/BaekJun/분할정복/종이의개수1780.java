package BaekJun.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLSyntaxErrorException;

public class 종이의개수1780 {
    static int[] answer = {0,0,0};
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N+1][N+1];
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0 ; j< N ; j++) {
                paper[i+1][j+1] = Integer.parseInt(inputs[j]);
            }
        }

        dac(1,N,1,N,N);
        for(int i = 0; i< 3 ;i++) System.out.println(answer[i]);
    }

    private static void dac(int rs, int re, int cs, int ce, int n) {

        if(n == 1) {
            int num = paper[rs][cs];
            answer[++num]++;
            return;
        }

        boolean isComplete = true;
        int num = paper[rs][cs];
        for(int i = rs; i <= re ; i++ ) {
            for(int j = cs; j <= ce; j++) {
                if(paper[i][j] != num) {
                    isComplete = false;
                    break;
                }
            }
            if(!isComplete) break;
        }

        if(isComplete) {
            answer[++num]++;
            return;
        }

        int nextN = n/3;
        dac(rs,rs+nextN-1,cs,cs+nextN-1,nextN);
        dac(rs,rs+nextN-1,cs+nextN,cs+2*nextN-1,nextN);
        dac(rs,rs+nextN-1,cs+2*nextN,cs+3*nextN-1,nextN);

        dac(rs+nextN,rs+2*nextN-1,cs,cs+nextN-1,nextN);
        dac(rs+nextN,rs+2*nextN-1,cs+nextN,cs+2*nextN-1,nextN);
        dac(rs+nextN,rs+2*nextN-1,cs+2*nextN,cs+3*nextN-1,nextN);

        dac(rs+2*nextN,rs+3*nextN-1,cs,cs+nextN-1,nextN);
        dac(rs+2*nextN,rs+3*nextN-1,cs+nextN,cs+2*nextN-1,nextN);
        dac(rs+2*nextN,rs+3*nextN-1,cs+2*nextN,cs+3*nextN-1,nextN);

    }

}
