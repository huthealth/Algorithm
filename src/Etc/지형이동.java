package Etc;/*

import java.util.LinkedList;
import java.util.Queue;

public class 지형이동 {
    private static class Entity{

        private int y;
        private int x;
        private int h;
        private Entity(int y, int x, int h){
            this.y =y;
            this.x = x;
            this.h = h;
        }
    }

    public int[] dx = {0,-1,0,1};
    public int[] dy = {-1,0,1,0};
    public int[][] cache;
    public int[][] map;
    public int mapBoundary = 0;
    public int N;
    public int H;
    public int solution(int[][] land, int height) {
        int answer = 0;
        N = land.length;
        H = height;
        cache = new int[N][N];
        map = new int[N][N];
        for(int i =0;i<N;i++) {
            for(int j =0; j<N;j++){
                cache[i][j] = -1;
                map[i][j] = -1;
            }
        }
        Queue<Entity> queue = new LinkedList<>();
        queue.add(new Entity(0,0,land[0][0]));
        cache[0][0] =0;
        map[0][0] = 0;
        while(!queue.isEmpty()) {
            Entity e = queue.poll();
            int nowY = e.y;
            int nowX = e.x;
            int nowH = e.h;

            for(int i = 0; i<4;i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if(!(nextY >=0 && nextX >=0 && nextY < N && nextX < N)) continue;
                int nextH = land[nextY][nextX];
                int dist;
                if(cache[nextY][nextX] == -1) {
                    if (Math.abs(nextH - nowH) > height) {
                        cache[nextY][nextX] = Math.abs(nextH - nowH);
                        map[nextY][nextX] = ++mapBoundary;
                    } else {
                        cache[nextY][nextX] = 0;
                        map[nextY][nextX] = mapBoundary;
                    }
                    queue.add(new Entity(nextY, nextX, land[nextY][nextX]));
                }
                else {
                    if(Math.abs(nextH - nowH) > height) {
                        dist = Math.abs(nextH - nowH);
                    }
                    else {
                        dist = 0;
                    }
                    if( cache[nextY][nextX] > dist && (map[nextY][nextX] != map[nowY][nowX])) cache[nextY][nextX] = dist;
                }
            }

        }
        for(int i =0;i<N;i++) {
            for(int j =0; j<N;j++){
                System.out.print(map[i][j] + " ");
                answer += cache[i][j];
            }
            System.out.println();
        }
        return answer;

    }
}

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class 지형이동 {

    public class UnionFind {
        public int[] size;
        public int[] id;
        public int numberOfComponents;

        public UnionFind(int size){
            this.size = new int[size];
            this.id = new int[size];
            numberOfComponents = size;
            for(int i = 0 ;i < numberOfComponents; i++) {
                this.size[i] = 1;
                id[i] = i;
            }
        }

        public int find(int p) {
            int root = p;

            while(root != id[root]) {
                root = id[root];
            }

            /*
            int nextRoot = p ;
            while(nextRoot != id[nextRoot]){
                nextRoot = id[nextRoot];
                id[nextRoot] = root;
            }
        */
            while(root != p){
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public boolean isConnected(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            return pRoot == qRoot;
        }

        public boolean unify(int p, int q) {
            if(isConnected(p,q)) return false;

            int pRoot = find(p);
            int qRoot = find(q);

            if(size[pRoot] > size[qRoot]) {
                id[qRoot] = id[pRoot];
                size[pRoot] += size[qRoot];
            }
            else{
                id[pRoot] = id[qRoot];
                size[qRoot] += size[pRoot];
            }

            numberOfComponents--;
            return true;
        }
    }

    public class Line{
        public Integer from;
        public Integer to;
        public Integer len;
        public Line(int f, int t, int l){
            from = f;
            to = t;
            len = l;
        }
    }

    public int N;
    public int H;
    public int solution(int[][] land, int height) {
        int answer = 0;
        N = land.length;
        H = height;


        PriorityQueue<Line> pq = new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.len.compareTo(o2.len);
            }
        });


        for(int i =0; i<N;i++){
            for(int j  =0 ;j<N;j++){
                int from = i*N + j;
                if(j+1 < N) {
                    int to = i*N +j +1;
                    pq.add(new Line(from,to,Math.abs(land[i][j+1] - land[i][j])));
                }
                if(i+1 < N) {
                    int to = (i+1)*4 + j;
                    pq.add(new Line(from,to,Math.abs(land[i+1][j] - land[i][j])));
                }
            }
        }

        UnionFind uf = new UnionFind(N*N);
        while(uf.numberOfComponents > 1){
            Line  line= pq.poll();
            int from = line.from;
            int to = line.to;
            int len = line.len;

            boolean connect = uf.unify(from,to);
            if(connect){
                System.out.println("From : "+from +" to : "+to+" len : "+len);
                if(len > height) answer += len;
            }

        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String... args) {
        지형이동 g = new 지형이동();
        int[][] land = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {9, 5, 5, 5, 9}, {9, 9, 5, 5, 9}, {1, 1, 1, 1, 1}};
        // int[][] land = 	{{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int h = 2;
        g.solution(land,h);
    }
}


class UnionFind2{
    private int[] id;
    private int[] size;
    private int numberOfSet;

    public UnionFind2(int sz){
        id  = new int[sz];
        size = new int[sz];
        numberOfSet = sz;

        for(int i =0;i<sz;i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int getNumberOfSet(){
        return numberOfSet;
    }

    public int find(int p) {
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }

        while(root != p) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }
}