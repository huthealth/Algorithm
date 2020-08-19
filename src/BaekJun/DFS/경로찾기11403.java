package BaekJun.DFS;

/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class 경로찾기11403 {
    static boolean cycle;
    static int[][] graph;
    static int[][] answer;
    static int[] visited;
    static int[] finished;
    static int N;
    static List<Integer> list = new ArrayList<>();

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i = 0 ; i< N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j = 0 ; j<N ;j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        answer = new int[N][N];
        //for(int i = 0 ; i<N;i++) {
        //    answer[i][i] = 1;
       // }

        finished = new int[N];

visited = new int[N];
        for(int i =0 ; i< N ;i++) {
            if (visited[i] == 0) {
                list.clear();
                cycle = false;
                visited[i] = 1;
                dfs(i);
                for (int j = 0; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        answer[list.get(j)][list.get(k)] = 1;
                    }
                }

            }
        }
        for(int i = 0 ; i<N;i++) {
            for(int j = 0; j<N;j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int now) {
        list.add(now);
        for(int next = 0; next < N ; next++) {
            if(visited[next] ==0 && graph[now][next] == 1) {
                visited[next] = 1;
                dfs(next);
            }
            else {
                if(graph[now][next] == 1 && finished[next] == 1) {
                    list.add(next);
                }
                else if(graph[now][next] == 1 && finished[next] == 0){
                    for(int j = 0; j< list.size(); j++) {
                        for(int k = 0; k <list.size(); k++) {
                            answer[list.get(j)][list.get(k)] = 1;
                        }
                    }
                }
            }
        }
        finished[now] = 1;
    }
}

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 경로찾기11403 {
    static int[][] graph;
    static int[][] answer;
    static int[] visited;
    static int N;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        answer = new int[N][N];

        visited = new int[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, 0);
           // visited[i] = 1;
            dfs(i);
            for(int j = 0 ; j< N ;j++) {
                if(visited[j] == 1) answer[i][j] = 1;
            }
        }

        for(int i = 0 ; i<N;i++) {
            for(int j = 0; j<N;j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void dfs(int now) {
        for(int next = 0 ; next< N ; next++) {
            if(visited[next] ==0 && graph[now][next] == 1) {
                visited[next] = 1;
                dfs(next);
            }
        }
    }
}
