package BaekJun.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 중앙값구하기2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt( br.readLine());
        for(int t = 0 ; t < T ; t++) {
            int N = Integer.parseInt(br.readLine());

            List<Integer> answer = new ArrayList<>();
            int[] numbers = new int[N];
            int count = 0;

            while(true){
                String[]  inputs = br.readLine().split(" ");
                for(int i = 0 ; i< 10; i++){
                    if(count == N ) break;
                    numbers[count++] = Integer.parseInt(inputs[i]);
                }
                if(count == N ) break;
            }

            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            for(int i = 1 ; i<=N; i++) {
                minPQ.add(numbers[i-1]);
                int min = minPQ.poll();
                maxPQ.add(min);
                if(i % 2 == 1){
                    int max = maxPQ.poll();
                    minPQ.add(max);
                    answer.add(minPQ.peek());
                }
            }



            System.out.println(answer.size());
            for(int i = 0 ; i < answer.size();i++) {
                if(i != 0 && i % 10 ==0) System.out.println();
                System.out.print(answer.get(i)+" ");
            }
            System.out.println();
        }
    }
}
