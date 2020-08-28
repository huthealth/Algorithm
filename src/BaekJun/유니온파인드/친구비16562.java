/*
1. a,b 중 친구비가 작은 친구를 루트로 정하고 연결해준다
2. 모든 친구 그룹을 만든 후 그룹들의 합을 구한다.
3. 그룹의 합이 K보다 크면 OH NO

실패 이유 : 2번에서 set을 사용했는데 실패 -> path compression을 모두 해주는게 아니라 이렇게 하면 안됨 ( 1 <- 2 <- 3 이런 경우 가능 )
해결 : ary배열을 돌면서 자신의 index번호와 같은 값을 가진 ary[i]가 그룹의 최소 값이므로 이 값들만 더해주면 됨
 */

package BaekJun.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 친구비16562 {
    private static int[] moneys;

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

            /*
            if(size[rootP] > size[rootQ]){
                size[rootP] += size[rootQ];
                ary[rootQ] = rootP;
            }
            else {
                size[rootQ] += size[rootP];
                ary[rootP] = rootQ;
            }
                        */
            if(moneys[rootP] > moneys[rootQ]) {
               // size[rootQ] += size[rootP];
                ary[rootP] = rootQ;
            }
            else {
                //size[rootP] += size[rootQ];
                ary[rootQ] = rootP;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(inputs[2]);

        inputs = br.readLine().split(" ");

        moneys = new int[N+1];
        for(int i = 0 ; i< N; i++) {
            moneys[i+1] = Integer.parseInt(inputs[i]) ;
        }

        UnionFind uf = new UnionFind(N+1);
        for(int i = 0 ; i< M; i++) {
            inputs =  br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            uf.merge(a,b);
        }

        //Set<Integer> set = new HashSet<>();
        long need = 0;
        for(int i = 1 ; i <=N; i++) {
            if(uf.ary[i] != i) continue;
            need += moneys[uf.ary[i]];
        }

        if(need > K) System.out.println("Oh no");
        else System.out.println(need);
    }
}
