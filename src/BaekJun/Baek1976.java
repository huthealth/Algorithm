package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1976 {

    private static class UnionFind{
        private int[] ary;
        private int[] size;

        private UnionFind(int sz) {
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

        private void unify(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if(isConnected(p,q)) return;

            if(size[root1] > size[root2]) {
                ary[root2] = ary[root1];
                size[root1] += size[root2];
            }
            else {
                ary[root1] = ary[root2];
                size[root2] += size[root1];
            }
        }
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] travel = new int[M];
        UnionFind uf = new UnionFind(N);

        String[] input;
        for(int i = 0; i<N;i++) {
            input = br.readLine().split(" ");
            for(int j = 0;j<N;j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for(int i = 0;i<M;i++) travel[i] = Integer.parseInt(input[i]) -1;
        for(int i =0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] == 1) uf.unify(i,j);
            }
        }
        int root = uf.find(travel[0]);
        for(int i = 1;i<M;i++) {
            if(root != uf.find(travel[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
