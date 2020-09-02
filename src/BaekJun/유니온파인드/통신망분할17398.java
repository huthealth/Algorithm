package BaekJun.유니온파인드;

import sun.security.jca.JCAUtil;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 통신망분할17398 {

    static int totalComponent;
    static int[] ary;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int Q = Integer.parseInt(inputs[2]);

        ary = new int[N+1];
        size = new int[N+1];
        totalComponent = N;

        Point[] before= new Point[M+1];
        Point[] after = new Point[M+1];
        Integer[] cut = new Integer[Q];

        for(int i = 1; i<=N; i++) {
            ary[i] = i;
            size[i] = 1;
        }

        for(int i = 0 ; i< M; i++) {
            inputs = br.readLine().split(" ");
            int p = Integer.parseInt(inputs[0]);
            int q = Integer.parseInt(inputs[1]);
            before[i+1] = new Point(p,q);
            after[i+1] = new Point(p,q);
        }

        for(int i = 0 ; i<Q;i++) {
            int lineNum = Integer.parseInt(br.readLine());
            cut[i] = lineNum;
        }

        for(int i = 0 ; i<Q; i++) {
            after[cut[i]] =null;
        }

        for(int i = 1 ; i<=M;i++) {
            if(after[i] == null) continue;
            merge(after[i].x,after[i].y);
        }

        long answer = 0;

        for(int i = Q-1 ;i>=0 ; i--) {
            int lineNum = cut[i];
            Point p = before[lineNum];
            long group1 = size[find(p.x)];
            long group2 = size[find(p.y)];
            if(merge(p.x,p.y)) {
                answer +=  ( group1 * group2 );
            }
        }

        System.out.println(answer);
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
    static boolean merge(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if(rootp == rootq) return false;

        if(size[rootp] > size[rootq]){
            size[rootp] += size[rootq];
            ary[rootq] = rootp;
        }
        else {
            size[rootq] += size[rootp];
            ary[rootp] = rootq;
        }
        totalComponent--;
        return true;
    }
}
