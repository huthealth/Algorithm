package BaekJun.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 사회망서비스2533 {

    static int[] visited;
    static long[][] cache;
    static List<List<Integer>> list = new ArrayList<>();
    static List<List<Integer>> tree = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        visited = new int[N+1];

        for(int i  = 0; i <= N; i++){
            list.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }
        for(int i = 0 ; i< N-1; i++) {
            String[] inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        visited[1]= 1;
        makeTree(1);
        cache = new long[2][N+1];

//        Arrays.fill(visited,0);
        for(int i = 0 ; i<2; i++) Arrays.fill(cache[i],-1);
//        visited[1] = 1;
        long ans1 = getMaxPeople(1,1);
        Arrays.fill(visited,0);
//        visited[1]= 1;
        // for(int i = 0 ; i<2; i++) Arrays.fill(cache[i],-1);
        long ans2 = getMaxPeople(1,0);


        System.out.println(Math.min(ans1,ans2));

       /* for(int i = 1; i<tree.size(); i++){
            System.out.print(i+ " ");
            for(Integer node : tree.get(i)) System.out.print(node+ " ");
            System.out.println();
        }

        */

    }

    private static void makeTree(int node) {
        for(int i = 0 ; i< list.get(node).size(); i++) {
            int child = list.get(node).get(i);
            if (visited[child] == 1) continue;
            tree.get(node).add(child);
            visited[child] = 1;
            makeTree(child);
        }
    }

    private static long getMaxPeople(int now, int check) {
        if(cache[check][now] != -1) return cache[check][now];

        cache[check][now] = 0;

        for(int i = 0 ; i< tree.get(now).size(); i++) {
            long temp = 0;

            if(check == 0) {
                temp = getMaxPeople(tree.get(now).get(i), 1);
            }
            else {
                temp = getMaxPeople(tree.get(now).get(i),0);
                temp = Math.min(temp,getMaxPeople(tree.get(now).get(i), 1));
            }
            cache[check][now]  += temp;
        }

        if(check == 1) cache[check][now] += 1;
        return cache[check][now];
    }

}

/*
private static long getMaxPeople(int now, int check) {
        if(cache[check][now] != -1) return cache[check][now];

        cache[check][now] = 0;

        for(int i = 0 ; i< tree.get(now).size(); i++) {
            long temp = 0;
            if(visited[list.get(now).get(i)] == 1) continue;
            visited[list.get(now).get(i)] = 1;

            if(check == 0) {
                temp = getMaxPeople(list.get(now).get(i), 1);
            }
            else {
                temp = getMaxPeople(list.get(now).get(i),0);
                temp = Math.min(temp,getMaxPeople(list.get(now).get(i), 1));
            }
            visited[list.get(now).get(i)] = 0;
            cache[check][now]  += temp;
        }

        if(check == 1) cache[check][now] += 1;
        return cache[check][now];
    }
 */