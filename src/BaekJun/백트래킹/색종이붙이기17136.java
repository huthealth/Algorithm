package BaekJun.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이붙이기17136 {
    private static int N = 0;
    private static int answer = 999999999;
    private static int[][] map = new int[10][10];
    private static int[] papaers = {0,5,5,5,5,5};

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i<10; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j = 0 ; j<10; j++){
                map[i][j] = Integer.parseInt(inputs[j]);
                if(map[i][j] == 1) N++;
            }
        }


        if(N == 0) {
            System.out.println(0);
            return;
        }
        dfs(0,0);
        if(answer == 999999999) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(int countOfOnes, int countOfPaper) {
       // System.out.println(countOfOnes + " " + countOfPaper);
        if(countOfOnes == N) {
            answer = Math.min(answer,countOfPaper);
            return;
        }

        for(int i = 0 ; i< 10; i++){
            for(int j = 0 ; j<10; j++) {
                if(map[i][j] == 0) continue;
                int minLen = 1;
                for(int k = 2; k<=5; k++) {
                    if(i+k > 10 || j+k > 10) break;
                    if(check(i,j,k)) minLen = k;
                    else break;
                }

                for(int k = minLen; k > 0 ; k-- ){
                    if(papaers[k] <= 0) continue;
                    int used = k*k;
                    putPaper(i,j,k);
                    papaers[k]--;
                    dfs(countOfOnes + used, countOfPaper+1);
                    deletePaper(i,j,k);
                    papaers[k]++;
                }
                return;
            }
        }
    }

    private static boolean check(int y, int x, int k) {
        for(int i = y; i < y+k; i++) {
            for(int j = x; j < x+k ;j++){
                if(map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void deletePaper(int y, int x, int k) {
        for(int i = y; i < y+k; i++) {
            for(int j = x; j < x+k; j++){
                map[i][j] = 1;
            }
        }
    }

    private static void putPaper(int y, int x, int k) {
        for(int i = y; i < y+k; i++) {
            for(int j = x; j < x+k; j++){
                map[i][j] = 0;
            }
        }
    }
}
