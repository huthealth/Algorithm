package BaekJun.유니온파인드;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 군사이동11085 {
    private static class Bridge {
        int to;
        int len;
        Bridge(int t, int l) {
            to = t;
            len = l;
        }
    }
    static List<List<Bridge>> bridges;
    static int N;
    static int W;
    static int C;
    static int V;
    static int[] cache;
    static int[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        W = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");

        C = Integer.parseInt(inputs[0]);
        V = Integer.parseInt(inputs[1]);
        bridges = new ArrayList<>(N + 1);
        cache = new int[N];
        visited = new int[N];
        for (int i = 0; i <= N; i++) {
            bridges.add(new ArrayList<>());
        }
        for (int i = 0; i < W; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int len = Integer.parseInt(inputs[2]);

            bridges.get(a).add(new Bridge(b, len));
            bridges.get(b).add(new Bridge(a, len));
        }

        Arrays.fill(cache, -1);
        visited[C] = 1;
        for (Bridge b : bridges.get(C)) {
            visited[b.to] = 1;
            answer = Math.max(answer,dp(b.to, b.len));
            visited[b.to] = 0;

        }


        for (int i = 0; i < N; i++) System.out.println(cache[i]);
        System.out.println(answer);


    }

    private static int dp(int now, int len) {
        if(now == V) return len;

        if(cache[now] != -1) return cache[now];

        cache[now] = 0;

        for(Bridge b : bridges.get(now)) {
            if(visited[b.to] == 1) continue;
            visited[b.to] = 1;
            int ret = dp(b.to,b.len);
            if(ret ==0) {
                visited[b.to] = 0;
                continue;
            }
            cache[now] = Math.max(cache[now],Math.min(ret, len));
            visited[b.to] = 0;
        }
        return cache[now];

    }
}
 */

import com.sun.management.MissionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 군사이동11085 {
    public static class Bridge {
        int from;
        int to;
        Integer len;

        public Bridge(int f, int t, Integer l) {
            from = f;
            to = t;
            len = l;
        }
    }

        static int[] ary;
        static int[] size;

        static List<Bridge> bridgeList = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = br.readLine().split(" ");
            int p = Integer.parseInt(inputs[0]);
            int w = Integer.parseInt(inputs[1]);
            inputs = br.readLine().split(" ");
            int c = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            for (int i = 0; i < w; i++) {
                inputs = br.readLine().split(" ");
                int from = Integer.parseInt(inputs[0]);
                int to = Integer.parseInt(inputs[1]);
                int len = Integer.parseInt(inputs[2]);
                bridgeList.add(new Bridge(from, to, len));
            }

            Collections.sort(bridgeList, new Comparator<Bridge>() {
                @Override
                public int compare(Bridge o1, Bridge o2) {
                    return o2.len.compareTo(o1.len);
                }
            });

            ary = new int[p + 1];
            size = new int[p+1];
            for (int i = 0; i < p + 1; i++) {
                ary[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < w; i++) {
                Bridge b = bridgeList.get(i);
                merge(b.from, b.to);
                if (isConnected(c, v)) {
                    System.out.println(b.len);
                    return;
                }
            }
        }


    static int find(int p ) {
        int root = ary[p];
        while(root != ary[root]) root = ary[root];
        while(root != ary[p]) {
            int next = ary[p];
            ary[p] = root;
            p = next;
        }
        return root;
    }
    static boolean isConnected(int p, int q) {
            return find(p) == find(q);
    }
    static void merge(int p, int q) {
            if(isConnected(p,q)) return;

            int rootP = find(p);
            int rootQ = find(q);
            if(size[rootP] > size[rootQ]) {
                size[rootP] += size[rootQ];
                ary[rootQ] = rootP;
            }
            else {
                size[rootQ] += size[rootP];
                ary[rootP] = rootQ;
            }
    }
}
