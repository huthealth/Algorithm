package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2887 {
    private static class UnionFind{
        private int[] ary;
        private int[] size;
        private int numOfSet;

        private UnionFind(int sz) {
            numOfSet = sz;
            ary = new int[sz];
            size = new int[sz];
            for(int i =0;i<sz;i++){
                ary[i] =i;
                size[i] = 1;
            }
        }

        private int find(int p) {
            int root = p;
            while(root != ary[root]) root = ary[root];
            while(root != ary[p]) {
                int next = ary[p];
                ary[p] = root;
                p = next;
            }
            return root;
        }
        private boolean isConnected(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            return root1 == root2;
        }

        private boolean unify(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (isConnected(p, q)) return false;

            if (size[root1] > size[root2]) {
                ary[root2] = root1;
                size[root1] += size[root2];
            } else {
                ary[root1] = root2;
                size[root2] += size[root1];
            }
            numOfSet--;
            return true;
        }
    }

    private static class Planet {
        int planetNum;
        Integer x;
        Integer y;
        Integer z;
        Planet(int pNum,int x,int y,int z) {
            this.planetNum = pNum;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    private static class Line {
        int from;
        int to;
        Integer dist;
        Line(int f, int t, int d) {
            from = f;
            to = t;
            dist = d;
        }
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        UnionFind uf = new UnionFind(N);
        Planet[] planetAry = new Planet[N];
        List<Line> lineList = new ArrayList<>();
        for(int i = 0; i<N;i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            planetAry[i] = new Planet(i,x,y,z);
        }
        Arrays.sort(planetAry, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x.compareTo(o2.x);
            }
        });
        for(int i = 0; i<N-1;i++) {
            Planet p1 = planetAry[i];
            Planet p2 = planetAry[i+1];
            lineList.add(new Line(p1.planetNum,p2.planetNum,Math.abs(p1.x - p2.x)));
        }
        Arrays.sort(planetAry, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y.compareTo(o2.y);
            }
        });
        for(int i = 0; i<N-1;i++) {
            Planet p1 = planetAry[i];
            Planet p2 = planetAry[i+1];
            lineList.add(new Line(p1.planetNum,p2.planetNum,Math.abs(p1.y - p2.y)));
        }
        Arrays.sort(planetAry, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z.compareTo(o2.z);
            }
        });
        for(int i = 0; i<N-1;i++) {
            Planet p1 = planetAry[i];
            Planet p2 = planetAry[i+1];
            lineList.add(new Line(p1.planetNum,p2.planetNum,Math.abs(p1.z - p2.z)));
        }
        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.dist.compareTo(o2.dist);
            }
        });


        int answer = 0;
        for(int i = 0 ;i< lineList.size();i++) {
            if(uf.numOfSet == 1) break;
            Line line = lineList.get(i);
            if(uf.unify(line.from,line.to)) {
                System.out.println(line.from + " " + line.to + " " + line.dist);
                answer += line.dist;
            }
        }
        System.out.println(answer);

    }

}
