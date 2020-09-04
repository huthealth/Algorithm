package BaekJun.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 다이어트1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        long lo = 1;
        long hi = 1;  //nowWeight
        List<Long> weights = new ArrayList<>();
        while(true) {
            long g = hi * hi - lo * lo;
            if(hi - lo == 1 && g > G) break;
            if( g < G) hi++;
            else if ( g == G) {
                weights.add(hi);
                hi++;
            }
            else lo++;
        }
        if(weights.isEmpty()) System.out.println(-1);
        else {
            for(Long l : weights) System.out.println(l);
        }

    }
}
