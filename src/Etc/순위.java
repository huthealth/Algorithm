package Etc;

public class 순위 {
    public int[][] graph;
    public int solution(int n, int[][] results) {
        int answer = 0;
         graph = new int[n+1][n+1];

        for(int i =0;i<results.length;i++){
            graph[results[i][0]][results[i][1]] = 1;
            graph[results[i][1]][results[i][0]] = -1;
        }

        for(int i=1;i<graph.length;i++){
            for(int j =1;j<graph.length;j++){
                if(graph[i][j] == 1) findLoser(i,j);
                else if(graph[i][j] == -1) findWinner(i,j);
            }
        }

        int count =0;
        for(int i =1;i<graph.length;i++){
            for(int j =1;j<graph.length;j++){
                if(graph[i][j] == 0) count++;
            }
            if(count == 1) answer++;
            count = 0;
        }
        return answer;
    }

    public void findLoser(int winner, int loser){
        for(int i=1;i<graph.length;i++){
            if( graph[loser][i] == 1) {
                graph[winner][i] = 1;
                graph[i][winner] = -1;
            }
        }
    }

    public  void findWinner(int loser, int winner){
        for(int i =1;i<graph.length;i++){
            if(graph[winner][i] == -1){
                graph[loser][i] =  -1;
                graph[i][loser] = 1;
            }
        }
    }
}
