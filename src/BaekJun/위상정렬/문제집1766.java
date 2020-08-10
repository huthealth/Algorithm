package BaekJun.위상정렬;



//mergesort + 위상정렬 이용하려고했는데 틀림..
/*


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제집1766 {
    private static int[] visited;
    private static List<List<Integer>> adj;
    private static List<Integer> orders;// = new ArrayList<>();
    //private static List<Integer> order = new ArrayList<>();
    private static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        adj = new ArrayList<>(N+1);
        for(int i = 0; i <= N ; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new int[N+1];
        for(int i = 0 ; i < M; i++) {
            tokens = br.readLine().split(" ");
            int student1 = Integer.parseInt(tokens[0]);
            int student2 = Integer.parseInt(tokens[1]);
            adj.get(student1).add(student2);
        }

        tSort();
        for(Integer i : orders) System.out.print(i + " ");
    }

    private static void tSort() {
        List<Integer> order = new ArrayList<>();
        for(int i = 1 ; i <= N; i++) {
            if(visited[i] == 0 && !adj.get(i).isEmpty()) {
                List<Integer> tempOrder;
                visited[i] = 1;
                tempOrder = dfs(i);
                order = merge(order,tempOrder);
            }
        }
        for(int i = 1 ; i <= N; i++) {
            if(visited[i] == 0 ) {
                List<Integer> tempOrder;
                visited[i] = 1;
                tempOrder = dfs(i);
                order = merge(order,tempOrder);
            }
        }
        orders = order;
    }

    private static List<Integer> dfs(int here) {
        List<Integer> nowOrder = new ArrayList<>();
        for (int i = 0; i < adj.get(here).size(); i++) {
            int next = adj.get(here).get(i);
            if (visited[next] == 0) {
                visited[next] = 1;
                List<Integer> tempOrder = dfs(next);
                nowOrder = merge(nowOrder, tempOrder);
            }
        }

        nowOrder.add(0, here);
        return nowOrder;
    }

    private static List<Integer> merge(List<Integer> nowOrder, List<Integer> tempOrder) {
        List<Integer> retOrder = new ArrayList<>();
        if(nowOrder.isEmpty()) {
            for(Integer i : tempOrder) retOrder.add(i);
            return retOrder;
        }

        int nowLen = nowOrder.size();
        int tempLen = tempOrder.size();
        int len = Math.min(nowLen,tempLen);
        int nowIndex = 0;
        int tempIndex = 0;
        while(nowIndex < nowLen && tempIndex < tempLen) {
            if(nowOrder.get(nowIndex) > tempOrder.get(tempIndex)) {
                retOrder.add(tempOrder.get(tempIndex));
                tempIndex++;
            }
            else {
                retOrder.add(nowOrder.get(nowIndex));
                nowIndex++;
            }
        }

        while(nowIndex < nowLen) retOrder.add(nowOrder.get(nowIndex++));
        while(tempIndex < tempLen) retOrder.add(tempOrder.get(tempIndex++));

        return retOrder;
    }


}


 */
/*
package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 문제집1766 {
    private static int[] visited;
    private static List<List<Integer>> adj;
    private static List<Integer> order = new ArrayList<>();
    private static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        adj = new ArrayList<>(N+1);
        for(int i = 0; i <= N ; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new int[N+1];
        for(int i = 0 ; i < M; i++) {
            tokens = br.readLine().split(" ");
            int student1 = Integer.parseInt(tokens[0]);
            int student2 = Integer.parseInt(tokens[1]);
            adj.get(student1).add(student2);
        }
        for(int i =0; i < adj.size(); i++) {
            Collections.sort(adj.get(i), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
        }

        tSort();
        for(Integer student : order) System.out.print(student + " ");

    }

    private static void tSort() {
        for(int i = N ; i >=1; i--) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
            }
        }
    }

    private static void dfs(int here) {
        for(int i = 0; i < adj.get(here).size(); i++) {
            int next = adj.get(here).get(i);
            if(visited[next] == 0) {
                visited[next] = 1;
                dfs(next);
            }
        }
        order.add(0,here);
    }
}


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 문제집1766 {
    private static List<List<Integer>> adj;
    private static int[] indgree;
    private static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        adj = new ArrayList<>(N+1);
        indgree = new int[N+1];
        for(int i = 0; i <= N ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++) {
            tokens = br.readLine().split(" ");
            int num1 = Integer.parseInt(tokens[0]);
            int num2 = Integer.parseInt(tokens[1]);
            adj.get(num1).add(num2);
            indgree[num2]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i =1 ; i<= N; i++) {
            if(indgree[i] == 0) pq.add(i);
        }
        while(!pq.isEmpty()) {
            int now = pq.poll();
            for(Integer next : adj.get(now)) {
                indgree[next]--;
                if(indgree[next] == 0) pq.add(next);
            }

            System.out.print(now+" ");
        }

    }
}