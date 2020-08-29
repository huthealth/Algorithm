package BaekJun.유니온파인드;
 /*
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 문명14868 {
    private static class Entity {
        Point p;
        int day;
        Entity(Point p , int day) {
            this.p = p;
            this.day = day;
        }
    }
    private static class UnionFind{
        private Point[][] ary;
        private int[][] size;

        UnionFind(int n) {
            ary = new Point[n][n];
            size = new int[n][n];
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j<n ; j++) {
                    ary[i][j] = new Point(j,i);
                    size[i][j] = 1;
                }
            }
        }

        public Point find(int y, int x) {
            Point root = ary[y][x];

            while(root.y != ary[root.y][root.x].y || root.x != ary[root.y][root.x].x) root = ary[root.y][root.x];

            while(root.y != ary[y][x].y || root.x != ary[y][x].x) {
                int nextY = ary[y][x].y;
                int nextX = ary[y][x].x;
                ary[y][x].y = root.y;
                ary[y][x].x = root.x;

                y = nextY;
                x = nextX;
            }
            return root;
        }
        public boolean isEqual(Point p, Point q) {
            Point rootP =  find(p.y, p.x);
            Point rootQ = find(q.y, q.x);
            if(rootP.y != rootQ.y || rootP.x != rootQ.x) return false;
            return true;
        }

        public int merge( Point p , Point q) {
            if(isEqual(p,q)){
                Point rootP = find(p.y,p.x);
                return size[rootP.y][rootP.x];
            }

            Point rootP = find(p.y,p.x);
            Point rootQ = find(q.y,q.x);

            if(set.contains(rootP)){
                size[rootP.y][rootP.x] += size[rootQ.y][rootQ.x];
                ary[rootQ.y][rootQ.x] = new Point(rootP.x,rootP.y);
                return size[rootP.y][rootP.x];
            }
            else if(set.contains(rootQ)){
                size[rootQ.y][rootQ.x] += size[rootP.y][rootP.x];
                ary[rootP.y][rootP.x] = new Point(rootQ.x,rootQ.y);
                return size[rootQ.y][rootQ.x];
            }

            else if(size[rootP.y][rootP.x] > size[rootQ.y][rootQ.x]){
                size[rootP.y][rootP.x] += size[rootQ.y][rootQ.x];
                ary[rootQ.y][rootQ.x] =  new Point(rootP.x,rootP.y);
                return size[rootP.y][rootP.x];
            }
            else {
                size[rootQ.y][rootQ.x] += size[rootP.y][rootP.x];
                ary[rootP.y][rootP.x] = new Point(rootQ.x,rootQ.y);
                return size[rootQ.y][rootQ.x];
            }
        }
    }

    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};

    static  int[][] visited;
    static int totalVisited = 0;
    static Set<Point> set = new HashSet<>();
    static Queue<Entity> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        visited = new int[N][N];
        UnionFind uf = new UnionFind(N);

        int day = 0;

        for(int i = 0 ; i< K ;i++) {
            inputs = br.readLine().split(" ");
            int y = Integer.parseInt(inputs[0]);
            int x = Integer.parseInt(inputs[1]);
            visited[y-1][x-1] = 1;
            totalVisited++;
            Point p = new Point(x-1,y-1);

            set.add(p);
            q.add(new Entity(p,0));
        }




        while(!q.isEmpty()) {
            boolean complete = false;
            Entity e = q.poll();
            Point p = e.p;
            int y = p.y;
            int x = p.x;

             System.out.println(e.day+ " : "+ totalVisited);


            for(int i = 0 ; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >=0 && ny < N && nx >=0 && nx < N) {
                    Point np = uf.ary[ny][nx];

                    int size = -1;
                    if(e.day == 0){
                        if(! set.contains(np)){
                            visited[ny][nx] = 1;
                            totalVisited++;
                            q.add(new Entity(np,e.day+1));
                        }
                         size = uf.merge(p,np);
                    }
                    else if(visited[ny][nx] ==0) {
                        visited[ny][nx] = 1;
                        totalVisited++;
                        size = uf.merge(p,np);
                        q.add(new Entity(np,e.day+1));
                    }

                    for(int j = 0 ; j<4; j++){
                        int nny = ny + dy[j];
                        int nnx = nx + dx[j];
                        if(nny >=0 && nny < N && nnx >=0 && nnx < N && visited[nny][nnx] == 1) {
                            Point nnp = uf.ary[nny][nnx];
                            size = uf.merge(np,nnp);
                        }
                    }


                    if(size == totalVisited) {
                        complete = true;

                        break;
                    }
                }
            }

            if(complete){
                day = e.day+1;
                break;
            }

        }

        System.out.println(day);
    }
}
                                         */


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 문명14868 {

    static int[][] map;
    static int[] ary;
    static int[] size;
    static Queue<Point> q;
    static Queue<Point> qq;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int N;
    static int K;

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] inputs = br.readLine().split(" ");

         N = Integer.parseInt(inputs[0]);
         K = Integer.parseInt(inputs[1]);

         int answer = 0;
         map = new int[N][N];
          q = new LinkedList<>();
          qq = new LinkedList<>();

         for(int i = 1 ; i <= K; i++) {
             inputs = br.readLine().split(" ");
             int y = Integer.parseInt(inputs[0]) -1;
             int x = Integer.parseInt(inputs[1]) -1;
             q.add(new Point(x,y));
             map[y][x] = i;

         }
         ary = new int[K+1];
         size = new int[K+1];

         for(int i = 1 ; i< K+1; i++) {
             ary[i] = i;
             size[i] = 1;
         }


        while(true){
            bfs_union();
            if(K == 1) {
                System.out.println(answer);
                break;
            }
            bfs_propagation();
            answer++;
        }

     }

     static void bfs_union() {
        while(!q.isEmpty()){
            Point p = q.poll();
            qq.add(p);
            int country = map[p.y][p.x];
            for(int i = 0 ; i< 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >=0 && ny < N && nx >=0 && nx < N) {
                    int nCountry = map[ny][nx];
                   if(nCountry != 0 && ary[country] != ary[nCountry]) {
                       if(unify(ary[country],ary[nCountry])) K--;
                   }
                }
            }
        }
     }

     static void bfs_propagation() {
         while (!qq.isEmpty()) {
             Point p = qq.poll();
             int country = map[p.y][p.x];
             for (int i = 0; i < 4; i++) {
                 int ny = p.y + dy[i];
                 int nx = p.x + dx[i];

                 if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                     int nCountry = map[ny][nx];
                     if(nCountry == 0) {
                         map[ny][nx] = country;
                         q.add(new Point(nx,ny));
                     }
                     /*
                     else {
                        if(unify(ary[country],ary[nCountry])) K--;
                     }

                      */
                 }
             }
         }
     }

     static int find(int p) {
         int root = ary[p];
         while(root != ary[root]) root = ary[root];
         while(root != ary[p]) {
             int next = ary[p];
             ary[p] = root;
             p = next;
         }
         return root;
     }

     static boolean unify(int p, int q){
         if(isConnected(p,q)) return false;

         int rootP = find(p);
         int rootQ = find(q);

         if (size[rootP] > size[rootQ]) {
            ary[rootQ] = rootP;
            size[rootP] += size[rootQ];

         }
         else {
             ary[rootP] = ary[rootQ];
             size[rootQ] += ary[rootP];
         }
         return true;
     }

    private static boolean isConnected(int p, int q) {
         return find(p) == find(q);
    }

}