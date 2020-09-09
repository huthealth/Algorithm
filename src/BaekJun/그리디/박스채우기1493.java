/*
그리디 + 분할정복
가장 큰 큐브부터 사용해 채우고 채워진 나머지 3부분을 재귀적으로 푼다
 */


package BaekJun.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 박스채우기1493 {
    private static class Box {
        Integer len;
        Integer cnt;
        Box(int l, int c) {
            len = l;
            cnt = c;
        }
    }

    static Box[] boxes;
    static boolean isPossible = true;
    static int answer = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int L,W,H;
        L = Integer.parseInt(inputs[0]);
        W = Integer.parseInt(inputs[1]);
        H = Integer.parseInt(inputs[2]);
        N = Integer.parseInt(br.readLine());
         boxes = new Box[N];

        for(int i = 0 ; i<N; i++) {
            inputs = br.readLine().split(" ");
            int len = Integer.parseInt(inputs[0]);
            int cnt = Integer.parseInt(inputs[1]);
            len = (int)Math.pow(2,len);
            boxes[i] = new Box(len,cnt);
        }
        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.len.compareTo(o1.len);
            }
        });
        dac(L,W,H);
        if(isPossible) System.out.println(answer);
        else System.out.println(-1);


    }

    private static void dac(int l, int w, int h) {
        if(!isPossible) return;
        if(l == 0 || w == 0 || h == 0) return;

        for(int i = 0 ; i< N; i++) {
            if(l < boxes[i].len || w < boxes[i].len || h < boxes[i].len || boxes[i].cnt <= 0) continue;
            answer++;
            boxes[i].cnt--;
            dac(boxes[i].len,w-boxes[i].len,h);
            dac(l-boxes[i].len,w,h);
            dac(boxes[i].len,boxes[i].len,h-boxes[i].len);
            return;
        }
        isPossible = false;
    }
}
