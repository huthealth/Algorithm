package BaekJun.위상정렬;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 부등호2529 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] minDegree = new int[k+1];
        int[] maxDegree = new int[k+1];
        char[] max = new char[k+1];
        char[] min = new char[k+1];
        List<List<Integer>> minAdj = new ArrayList<>(k+1);
        List<List<Integer>> maxAdj = new ArrayList<>(k+1);
        for(int i = 0 ; i<=k; i++) {
            minAdj.add(new ArrayList<>());
            maxAdj.add(new ArrayList<>());
        }
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < k ; i++) {
            if("<".equals(inputs[i])) {
                minAdj.get(i).add(i+1);
                maxAdj.get(i+1).add(i);
                minDegree[i+1]++;
                maxDegree[i]++;
            }
            else {
                minAdj.get(i+1).add(i);
                maxAdj.get(i).add(i+1);
                minDegree[i]++;
                maxDegree[i+1]++;
            }
        }

        int maxNum = 9;
        int minNum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //maxBfs
        for(int i = 0 ; i<= k; i++) {
            if(maxDegree[i] == 0) pq.offer(i);
        }
        while(!pq.isEmpty()) {
            int now = pq.poll();
            for(Integer next : maxAdj.get(now)) {
                maxDegree[next]--;
                if(maxDegree[next] == 0) {
                    pq.offer(next);
                }
            }
            max[now] = (char)('0' + maxNum);
            maxNum--;
        }

        for(int i = 0 ; i <= k; i++) {
            if(minDegree[i] == 0) pq.add(i);
        }
        while(!pq.isEmpty()) {
            int now = pq.poll();
            for(Integer next : minAdj.get(now)) {
                minDegree[next]--;
                if(minDegree[next] == 0) {
                    pq.offer(next);
                }
            }
            min[now] = (char)(minNum + '0');
            minNum++;
        }
        System.out.println(max);
        System.out.println(min);
    }
}




























*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 부등호2529 {
    static List<String> answers = new ArrayList<>();
    static int[] visited = new int[10];
    static String[] operation;
    static int len;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        operation = br.readLine().split(" ");

        for(int i = 0 ; i < 10 ; i++) {
            visited[i] = 1;
            String ans = Integer.toString(i);
            findNum(0,i,ans);
            visited[i] = 0;
        }
        answers.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(answers.get(0));
        System.out.println(answers.get(answers.size()-1));
    }

    private static void findNum(int now, int num, String ans) {
        if(now == len) {
            answers.add(ans);
            return;
        }

        for(int i =0; i < 10; i++){
            if(visited[i] ==0) {
                if (operation[now].equals("<") && num < i || operation[now].equals(">") && num > i) {
                    visited[i] = 1;
                    ans += Integer.toString(i);
                    findNum(now + 1, i, ans);
                    ans = ans.substring(0,ans.length()-1);
                    visited[i] = 0;
                }
            }
        }

    }
}





