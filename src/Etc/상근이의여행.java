package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상근이의여행 {
    private static class UnionFind {
        int[] id;
        int[] size;
        int numOfElement;
        private UnionFind(int sz) {
            id = new int[sz];
            size = new int[sz];
            numOfElement = sz;
            for(int i = 0 ;i < sz; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }
        private int find(int p) {
            int root = p;
            while(root != id[root]) root = id[root];
            while(root != p) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }
        private boolean unify(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return false;
            if(size[rootP] > size[rootQ]) {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            else {
                id[rootP] = rootQ;
                size[rootQ] = size[rootP];
            }
            numOfElement--;
            return true;
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt( br.readLine());
        for(int i = 0 ; i< T ;i++) {
            int plane = 0;
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt( input[0]);
            int M = Integer.parseInt( input[1]);
            UnionFind uf = new UnionFind(N);
            for(int j = 0; j<M; j++) {
                input = br.readLine().split(" ");
                if(uf.numOfElement == 1) continue;
                int from = Integer.parseInt( input[0]) - 1;
                int to = Integer.parseInt( input[1]) - 1;
                if(uf.unify(from,to)) plane++;
            }
            System.out.println(plane);
        }

    }
}
