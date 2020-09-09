package BaekJun.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class RestStop15748 {
    private static class Stop{
        Long dist;
        Long score;
        public Stop(long d, long s){
            dist = d;
            score = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long L,F,B;
        int N;
        L = Long.parseLong(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        F = Long.parseLong(inputs[2]);
        B = Long.parseLong(inputs[3]);

        Stop[] stops = new Stop[N];
        for(int i = 0 ; i<N; i++) {
            inputs = br.readLine().split(" ");
            long dist =  Long.parseLong(inputs[0]);
            long score =  Long.parseLong(inputs[1]);
            stops[i] = new Stop(dist,score);
        }

        Arrays.sort(stops, new Comparator<Stop>() {
            @Override
            public int compare(Stop o1, Stop o2) {
                if(o2.score.equals(o1.score)) {
                    return o1.dist.compareTo(o2.dist);
                }
                return o2.score.compareTo(o1.score);
            }
        });

        long answer = 0;
        long now = 0;
        for(int i = 0 ; i< N ;i++) {
            long next = stops[i].dist;
            if(next < now ) break;
            long timeF = (next - now) * F;
            long timeB = (next - now) * B;
            answer += (timeF - timeB) * stops[i].score;
            now = next;
        }
        System.out.println(answer);
    }
}
