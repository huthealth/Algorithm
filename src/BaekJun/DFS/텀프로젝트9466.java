package BaekJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 텀프로젝트9466 {
    static int answer = 0;
    static int[] people;
    static int[] visited;
    static int[] finished;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++) {
            answer = 0;
            int N = Integer.parseInt(br.readLine());
            people = new int[N+1];
            visited = new int[N+1];
            finished = new int[N+1];
            String[] inputs = br.readLine().split(" ");
            for(int j = 1; j <= N ;j++) {
                people[j] = Integer.parseInt(inputs[j-1]);
            }
            for(int j = 1; j<= N; j++) {
                if(visited[j] == 0) {
                    visited[j] = 1;
                    dfs(j);
                }

            }
            System.out.println(N - answer);
        }
    }

    private static void dfs(int now) {
        visited[now] = 1;
        int next = people[now];
        if(visited[next] == 0) {
            dfs(next);
        }
        else{
            if(finished[next] == 0) {
                for(int start = next; start != now; start = people[start]){
                    answer++;
                }
                answer++;
            }
        }
        finished[now] = 1;
    }
}
