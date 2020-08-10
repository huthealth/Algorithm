package Etc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class T4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] readLine = input.split(" ");
        int N = Integer.parseInt(readLine[0]);
        int G = Integer.parseInt(readLine[1]);
        int M = Integer.parseInt(readLine[2]);

        int[] road = new int[N + 1];

        input = br.readLine();
        readLine = input.split(" ");
        List<Integer> gasStation = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int location = Integer.parseInt(readLine[i]);
            gasStation.add(location);
        }

        input = br.readLine();
        readLine = input.split(" ");
        for (int i = 0; i < M; i++) {
            road[gasStation.get(i)] = Integer.parseInt(readLine[i]);
        }
        int now;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            G--;
            if (G < 0) {
                System.out.println(-1);
                return;
            }
            if (road[i] != 0) pq.add(-road[i]);
            if (G == 0 && i != N) {
                if (pq.isEmpty()) continue;
                G += -pq.poll();
                count++;
            }
        }
        System.out.println(count);
    }
}
