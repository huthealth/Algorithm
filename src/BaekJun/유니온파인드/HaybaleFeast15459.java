package BaekJun.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HaybaleFeast15459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        long F = Long.parseLong(inputs[1]);
        long[] aryF = new long[N];
        long[] aryS =new long[N];
        for(int i = 0 ; i<N ; i++) {
            inputs= br.readLine().split(" ");
            aryF[i] = Long.parseLong(inputs[0]);
            aryS[i] = Long.parseLong(inputs[1]);
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });


        int lo = 0;
        int hi = 0;
        long totalF = 0;
        long minS = Long.MAX_VALUE;
        while(lo < N) {
            if(totalF < F) {
                if(hi == N) break;
                totalF += aryF[hi];
                pq.add(aryS[hi]);
                hi++;
            }
            else {
                minS = Math.min(minS,pq.peek());
                totalF -= aryF[lo];
                pq.remove(aryS[lo]);
                lo++;
            }
        }
        System.out.println(minS);
    }
}
