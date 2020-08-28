package BaekJun.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 소수의곱2014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");

        long[] sosu = new long[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();
       // Set<Long> set = new HashSet<>();
        for(int i = 0 ; i< K; i++) {
            sosu[i] = Integer.parseInt(inputs[i]);
            pq.add(sosu[i]);
        }
        long answer = 0;
        int count = 0;
        long before = 0;
        while(true){
            long now = pq.poll();

           // if(before == now) continue;
            count++;
         //   System.out.println(now + " " + count);
            if(count == N){
                answer = now;
                break;
            }
            for(int i = 0 ; i< K; i++){
                long next = now * sosu[i];
                //if(next > Integer.MAX_VALUE || set.contains(next)) continue;
                //set.add(next);
                pq.offer(now * sosu[i]);
                if(now % sosu[i] == 0) break;
            }
            //before = now;
        }
        System.out.println(answer);

    }
}
