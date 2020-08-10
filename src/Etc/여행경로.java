package Etc;

import java.util.ArrayList;
import java.util.List;

public class 여행경로 {

    List<String> path = null;
    int[] visited;
    int N;
    String[][] T;
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        T = tickets;
        visited = new int[N];
        String[] answer = {};
        List<String> nowPath = new ArrayList<>();
        findPath(nowPath);
        answer = new String[N+1];
        for(int i =0;i<N+1;i++){
            answer[i] = path.get(i);
        }
        return answer;
    }

    public void findPath(List<String> nowPath){
        if(nowPath.size() == N+1){
            List<String> newPath = new ArrayList<>(nowPath);
            if(path == null){
                path = newPath;
                return;
            }
            for(int i = 0;i<N;i++){
                int a =path.get(i).compareTo(newPath.get(i));
                if(path.get(i).compareTo(newPath.get(i)) > 0){
                    return;
                }
                if(path.get(i).compareTo(newPath.get(i)) < 0){
                    path = newPath;
                    return;
                }
            }
            return;
        }

        String here ="";
        if(nowPath.size() == 0 ) {
            here = "ICN";
            nowPath.add(here);
        }
        else here = nowPath.get(nowPath.size()-1);

        for(int i =0;i<N;i++ ){
            if(T[i][0].equals(here) && visited[i] ==0){
                visited[i] =1;
                nowPath.add(T[i][1]);
                findPath(nowPath);
                nowPath.remove(nowPath.size()-1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String... args) {
        여행경로 a = new 여행경로();
        String[][] s = 	{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        a.solution(s);
    }
}
