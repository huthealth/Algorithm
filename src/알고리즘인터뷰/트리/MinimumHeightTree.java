package 알고리즘인터뷰.트리;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1 ) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i< n ; i++) adj.add(new HashSet<>());

        for(int i = 0 ; i < n-1 ; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for(int i = 0 ; i< n ; i++) {
            if(adj.get(i).size() == 1) leaves.add(adj.get(i).iterator().next());
        }
        System.out.println(leaves.size());

        while(n>2){
            n -= leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for(int i = 0 ; i< leaves.size(); i++) {
                int next = adj.get(leaves.get(i)).iterator().next();
                adj.get(next).remove(leaves.get(i));
                if(adj.get(next).size() == 1) nextLeaves.add(next);
            }
            leaves = nextLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTree t = new MinimumHeightTree();
        int[][] ary = {{1,0},{1,2},{1,3}};

        t.findMinHeightTrees(4,ary);
    }
}
