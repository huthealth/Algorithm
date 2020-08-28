package BaekJun.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 집합의표현1717 {
    private static class UnionFind{
        private int[] ary;
        private int[] size;

        UnionFind(int n) {
            ary = new int[n];
            size = new int[n];
            for(int i = 0 ; i < n ; i++) {
                ary[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            int root = ary[p];

            while(root != ary[root]) root = ary[root];

            while(root != ary[p]) {
                int next = ary[p];
                ary[p] = root;
                p = next;
            }
            return root;
        }
        public boolean isEqual(int p, int q) {
            return find(p) == find(q);
        }

        public void merge(int p , int q) {
            if(isEqual(p,q)) return;

            int rootP = find(p);
            int rootQ = find(q);

            if(size[rootP] > size[rootQ]){
                size[rootP] += size[rootQ];
                ary[rootQ] = rootP;
            }
            else {
                size[rootQ] += size[rootP];
                ary[rootP] = rootQ;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        UnionFind uf = new UnionFind(N+1);
        for(int i = 0 ; i < M ;i++) {
            inputs = br.readLine().split(" ");
            int cal = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);
            if(cal == 0) uf.merge(a,b);
            else {
                if(uf.isEqual(a,b)) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }

}
