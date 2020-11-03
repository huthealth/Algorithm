package 알고리즘인터뷰.트리;

        import com.sun.javafx.image.IntPixelGetter;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;


public class Network_Zombie {
    boolean[] visited;
    int N;
    int minZombies = Integer.MAX_VALUE;
    List<List<Integer>> adj = new ArrayList<>();
    List<List<Integer>> generations = new ArrayList<>();
    int countZombies(int n , int[][] graph){
        N= n;
        visited = new boolean[n];

        for(int i = 0 ; i< n ; i++) {
            adj.add(new ArrayList<>());
            generations.add(new ArrayList<>());
        }

        for(int i = 0 ; i< graph.length; i++) {
            int parent = graph[i][0];
            int child = graph[i][1];
            adj.get(parent).add(child);
        }

        makeGenerationGraph(0,0);
        findMinZombies(0,0);
        return minZombies;
    }

    private void findMinZombies(int now, int safe) {

        int check = 0;
        for(Integer person : generations.get(now) ) {

            if (visited[person]) continue;
            check = 1;
           int numOfChildren = changeVisitState(person,true);
            findMinZombies(now + 1, safe + numOfChildren);
            changeVisitState(person,false);
        }
        if(check ==0) {
            if(minZombies > N-safe) {
                minZombies  = N - safe;
            }
        }
    }

    private int changeVisitState(Integer person, boolean state ) {
        visited[person] = state;
        if(adj.get(person).isEmpty()) {
            return 1;
        }
        int children = 0;
        for(Integer child : adj.get(person)) {
            children +=changeVisitState(child,state);
        }
        return children+1;
    }

    private void makeGenerationGraph(int now,int gen) {
        List<Integer> children = adj.get(now);
        for(Integer child : children) {
            generations.get(gen).add(child);
            makeGenerationGraph(child,gen+1);
        }
    }

    public static void main(String[] args) {
        Network_Zombie nz=  new Network_Zombie();
        int[][] ary1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};
        int n1 = 19;

        int[][] ary2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9}, {3, 10}, {4, 11}, {4, 12}, {4, 13}};
        int n2 = 14;

        int[][] ary3 = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}};
        int n3 = 10;
        System.out.println(nz.countZombies(n3,ary3));
    }

}
