package 알고리즘인터뷰.그래프;


//dfs
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] visited;
    boolean[] isNotCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0 ; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i< prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        visited = new boolean[numCourses];
        isNotCycle = new boolean[numCourses];

        for(int i = 0 ; i < numCourses;i++) {
            if(!visited[i]){
                if(!dfs(i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int now) {
        if(visited[now]) return isNotCycle[now];
        visited[now] = true;

        for(int i = 0 ; i< adj.get(now).size();i++) {
            if(dfs(adj.get(now).get(i))) continue;
            return false;
        }

        return isNotCycle[now] = true;

    }
}

// bfs
class Bfs {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int i = 0 ; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            for(int next : adj.get(now)){
                if(--inDegree[next] == 0 ) queue.add(next);
                if(inDegree[next] < 0) return false;
            }
        }
        return true;

    }
}