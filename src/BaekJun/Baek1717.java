package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1717 {
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
            if (isConnected(p, q)) return;

            if (size[root1] > size[root2]) {
                ary[root2] = ary[root1];
                size[root1] += size[root2];
            } else {
                ary[root1] = ary[root2];
                size[root2] += size[root1];
            }
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        UnionFind uf = new UnionFind(n+1);
        for(int i =0;i<m;i++) {
            input = br.readLine().split(" ");
            int operation = Integer.parseInt(input[0]);
            int num1 = Integer.parseInt(input[1]);
            int num2 = Integer.parseInt(input[2]);
            if(operation == 0) {
                uf.unify(num1, num2);
            }
            else {
                if(uf.isConnected(num1,num2)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
