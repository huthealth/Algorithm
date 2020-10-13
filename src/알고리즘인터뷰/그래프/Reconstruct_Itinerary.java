package 알고리즘인터뷰.그래프;

import java.util.*;
import java.util.concurrent.RecursiveAction;

/*
public class Reconstruct_Itinerary {
    List<String> answer;
    int[] visited;
    int N;
    List<List<String>> tickets;
    public List<String> findItinerary(List<List<String>> tickets) {
        N = tickets.size()+1;
        this.tickets = tickets;
        visited = new int[N];

        List<String> ans = new ArrayList<>();
        ans.add("JFK");
        dfs("JFK",ans);

        return answer;
    }


    public void dfs(String now, List<String> nowPath) {
        if (nowPath.size() == N) {
            if (answer == null) {
                answer = new ArrayList<>(nowPath);
                return;
            }
            for (int i = 0; i < N; i++) {
                if (answer.get(i).compareTo(nowPath.get(i)) > 0) {
                    answer = new ArrayList<>(nowPath);
                    return;
                } else if (answer.get(i).compareTo(nowPath.get(i)) < 0) {
                    return;
                }
            }
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!tickets.get(i).get(0).equals(now) || visited[i] == 1) continue;
            visited[i] = 1;
            String next = tickets.get(i).get(1);
            nowPath.add(next);
            dfs(next, nowPath);
            visited[i] = 0;
            nowPath.remove(nowPath.size() - 1);
        }
    }
}

 */
public class Reconstruct_Itinerary {
    List<String> answer;
    Map<String, PriorityQueue<String>> paths = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); i++) {

            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            paths.putIfAbsent(from, new PriorityQueue<>());
            paths.get(from).add(to);
        }

        dfs("JFK");
        return answer;
    }

    private void dfs(String now) {


        while (paths.get(now) != null && !paths.get(now).isEmpty()) {
            dfs(paths.get(now).poll());
        }
        answer.add(0,now);
    }

    public static void main(String[] args) {
        Reconstruct_Itinerary a = new Reconstruct_Itinerary();
        String[][] ar = {{"MUC", "LHR"},{"JFK", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}};
        List<List<String>> arr = new ArrayList<>();
        for(String[] s : ar){
            arr.add(new ArrayList<>());
            arr.get(arr.size()-1).add(s[0]);
            arr.get(arr.size()-1).add(s[1]);
        }
        a.findItinerary(arr);
    }

}