package AlgoSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 변화하는중간값 {
    private static final long MOD = 20090711;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < c ; i++) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);
            long[] randoms = new long[n];
            randoms[0] = 1983;
            for(int j = 1 ; j<n; j++) {
                randoms[j] = ( randoms[j-1] * a + b) % MOD;
            }
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return o2.compareTo(o1);
                }
            });
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            long answer = 1983;
            maxHeap.add(randoms[0]);
            for(int j = 1; j < n ; j++) {
                if(j %2== 0) maxHeap.add(randoms[j]);
                else minHeap.add(randoms[j]);
                long leftMax = maxHeap.peek();
                long rightMin = minHeap.peek();
                if(leftMax > rightMin) {
                    maxHeap.poll();
                    minHeap.poll();
                    maxHeap.add(rightMin);
                    minHeap.add(leftMax);
                }
                answer = (answer + maxHeap.peek()) % MOD;
            }
            System.out.println(answer);
        }
    }
}
