package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Baek1774 {

    private static class UnionFind {
        int[] id;
        int[] size;
        int numOfElement;

        private UnionFind(int sz) {
            id = new int[sz];
            size = new int[sz];
            numOfElement = sz;
            for (int i = 0; i < sz; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }

        private int find(int p) {
            int root = p;
            while (root != id[root]) root = id[root];
            while (root != p) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        private boolean unify(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            if (size[rootP] > size[rootQ]) {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                id[rootP] = rootQ;
                size[rootQ] = size[rootP];
            }
            numOfElement--;
            return true;
        }
    }

    private static class Pos {
        int y;
        int x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private static class Line {
        int from;
        int to;
        Double dist;
        Line(int f, int t, double d) {
            from =f;
            to = t;
            dist = d;
        }
    }

    private static Pos[] posAry;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        UnionFind uf = new UnionFind(N);
        posAry = new Pos[N];
        List<Line> lineList = new ArrayList<>();
        for(int i = 0;i <N;i++) {
            input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            posAry[i] = new Pos(y,x);
        }
        for(int i = 0 ; i< M;i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            uf.unify(from,to);
        }
        for(int i = 0;i<N;i++) {
            for(int j = i+1;j<N; j++) {
                int from = i;
                int to = j;
                double dist = getDist(i,j);
                lineList.add(new Line(from,to,dist));
            }
        }
        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.dist.compareTo(o2.dist);
            }
        });
        double answer = 0.0;
        for(int i =0;i<lineList.size();i++) {
            if(uf.numOfElement == 1) break;
            Line line = lineList.get(i);
            if(uf.unify(line.from,line.to)) {
                answer += line.dist;
            }
        }
        System.out.printf("%.2f",answer);
    }
    private static double getDist(int from, int to) {
        Pos pos1 = posAry[from];
        Pos pos2 = posAry[to];
        double len1 = Math.pow(Math.abs(pos1.y - pos2.y),2);
        double len2 = Math.pow(Math.abs(pos1.x - pos2.x),2);
        return Math.sqrt(len1+len2);
    }
}
