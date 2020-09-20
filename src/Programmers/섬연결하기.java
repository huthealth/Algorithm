package Programmers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    private class Bridge{
        int from;
        int to;
        Integer cost;
        Bridge(int f, int t, int c){
            from = f;
            to =t;
            cost =c;
        }
    }

    int[] size;
    int[] islands;
    int islandCnt;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Bridge[] bridges = new Bridge[costs.length];
        for(int i = 0 ; i< costs.length; i++) {
            bridges[i]=  new Bridge(costs[i][0],costs[i][1],costs[i][2]);
        }

        Arrays.sort(bridges, new Comparator<Bridge>() {
            @Override
            public int compare(Bridge o1, Bridge o2) {
                return o1.cost.compareTo(o2.cost);
            }
        });

        islands =new int[n+1];
        size = new int[n+1];
        for(int i = 0 ; i <= n; i++) {
            islands[i] = i;
            size[i] = 1;
        }
        islandCnt = n;

        for(int i = 0 ; i < bridges.length; i++ ) {
            if(islandCnt == 1) break;
            if(merge(bridges[i].from,bridges[i].to)) {
                answer += bridges[i].cost;
            }
        }


        return answer;
    }

    private boolean merge(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ ) return false;

        islandCnt--;
        if(size[rootP] > size[rootQ]) {
            islands[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        else {
            islands[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        return true;
    }

    private int find(int p) {
        int root = islands[p];
        while(root != islands[root]) root = islands[root];
        while(root != islands[p]){
            int next = islands[p];
            islands[p] = root;
            p = next;
        }
        return root;
    }
}
