package BaekJun.분할정복;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class 별찍기10_2447 {
    static char[][] ary;
    static char[] draw = {' ','*'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt( br.readLine() );
        ary = new char[N+1][N+1];
        for(int i =1 ; i<= N; i++) {
            for(int j = 1; j<= N ; j++) ary[i][j] = ' ';
        }
        dac(1,N,1,N,N,1);
        for(int i = 1 ; i<= N ; i++) {
            for(int j = 1 ;j<=N; j++) {
                bw.write(ary[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();

    }

    private static void dac(int rs, int re, int cs, int ce, int n, int star) {
        //if(star == 0) return;
        if(n == 1) {
            ary[rs][cs] = draw[star];
            return;
        }

        int nextN = n/3;
        if(star == 1) {
            dac(rs, rs + nextN - 1, cs, cs + nextN - 1, nextN, 1);
            dac(rs, rs + nextN - 1, cs + nextN, cs + 2 * nextN - 1, nextN, 1);
            dac(rs, rs + nextN - 1, cs + 2 * nextN, cs + 3 * nextN - 1, nextN, 1);

            dac(rs + nextN, rs + 2 * nextN - 1, cs, cs + nextN - 1, nextN, 1);
            //dac(rs + nextN, rs + 2 * nextN - 1, cs + nextN, cs + 2 * nextN - 1, nextN, 0);
            dac(rs + nextN, rs + 2 * nextN - 1, cs + 2 * nextN, cs + 3 * nextN - 1, nextN, 1);

            dac(rs + 2 * nextN, rs + 3 * nextN - 1, cs, cs + nextN - 1, nextN, 1);
            dac(rs + 2 * nextN, rs + 3 * nextN - 1, cs + nextN, cs + 2 * nextN - 1, nextN, 1);
            dac(rs + 2 * nextN, rs + 3 * nextN - 1, cs + 2 * nextN, cs + 3 * nextN - 1, nextN, 1);
        }

    }
}
