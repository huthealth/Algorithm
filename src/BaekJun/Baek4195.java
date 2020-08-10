package BaekJun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baek4195 {

    private static class UnionFind {
        private int[] size;
        private int[] id;

        public UnionFind(int sz) {
            size = new int[sz];
            id = new int[sz];
            for(int i =0;i<sz;i++){
                size[i] = 1;
                id[i] = i;
            }
        }

        public int find(int p) {
            int root = p;
            while(root != id[root]) root = id[root];

            while(root != p) {
                int next = id[p];
                id[p] = root;
                p = next;
            }

            return root;
        }

        public int getSize(int p) {
            int root = find(p);
            return size[root];
        }

        public boolean isConnected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        public void unify(int p, int q){
            if(isConnected(p,q)) return;

            int rootP = find(p);
            int rootQ = find(q);

            if(size[rootP] > size[rootQ]) {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            else{
                id[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

    }


    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<c;i++){
            int N = Integer.parseInt(sc.nextLine());
            int personId = 0;
            Map<String, Integer> people = new HashMap<>();
            String[] peopleAry = new String[N*2];
            int peopleAryIndex = 0;
            for(int j = 0; j< N; j++) { // map 채우기
                String str = sc.nextLine();
                String[] twoPeople = str.split(" ");
                for(int k = 0 ; k<twoPeople.length; k++){
                    peopleAry[peopleAryIndex++] = twoPeople[k];
                    if(people.containsKey(twoPeople[k])) continue;
                    people.put(twoPeople[k],personId++);
                }
            }

            peopleAryIndex = 0;
            UnionFind uf = new UnionFind(people.size());
            for(int j =0 ; j<N; j++) {
                int from = people.get(peopleAry[peopleAryIndex++]);
                int to = people.get(peopleAry[peopleAryIndex++]);
                uf.unify(from,to);
                System.out.println(uf.getSize(from));
            }
        }
    }


}
