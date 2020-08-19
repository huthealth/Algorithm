package BaekJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MT10265 {
    static int groupNum = 1;
    static int[] extraGroup;
    static int[] cycleGroup;
    static int[] group;
    static int[] people;
    static int[] visited;
    static int[] finished;
    static int[][] cache;
    static int N;
    static int K;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");
        visited = new int[N+1];
        finished = new int[N+1];
        people = new int[N+1];
        group = new int[N+1];
        cycleGroup = new int[N+1];
        extraGroup = new int[N+1];
        for(int i = 1 ; i<=N; i++) {
            people[i] = Integer.parseInt(inputs[i-1]);
        }

        for(int i = 1 ; i<=N ;i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i);

            }
        }
        for(int i =1; i<=N; i++) {
            extraGroup[group[i]]++;
        }





        cache = new int[groupNum+1][K+1];
        for(int i = 0; i<= groupNum; i++) Arrays.fill(cache[i],-1);
        int answer = dp(1,K);



/*
        int groupCnt = 0;
        int total = 0;
        int total2= 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i<=N; i++) {
            if(cycleGroup[i] != 0 && cycleGroup[i] <= K) {
                groupCnt = cycleGroup[i];
                if(extraGroup[i] < K) {
                    groupCnt = extraGroup[i];
                }
                else {
                    groupCnt = K;
                }
                list.add(groupCnt);
            }
        }

        int[] cache = new int[list.size()];



        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });


        for(int i = 0; i< list.size(); i++) {
            if(total + list.get(i) > K) break;
            total += list.get(i);
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            if(total2 + list.get(i) > K) break;
            total2 += list.get(i);
        }
        total = Math.max(total,total2);

 */

        System.out.println(answer);
    }

    private static int dp(int groupNumber, int busSpace) {
        if(groupNumber == groupNum || busSpace == 0) return 0;
        if(cache[groupNumber][busSpace] != -1) return cache[groupNumber][busSpace];

        cache[groupNumber][busSpace] = dp(groupNumber+1,busSpace);
        for(int i = cycleGroup[groupNumber]; i <= Math.min(K,extraGroup[groupNumber]); i++) {
            if( busSpace - i >= 0) cache[groupNumber][busSpace] = Math.max(cache[groupNumber][busSpace],dp(groupNumber+1,busSpace-i) +i) ;
        }
        return cache[groupNumber][busSpace];
    }

    private static void dfs(int now) {
        int next = people[now];
        if(visited[next] == 0) {
            visited[next] = 1;
            group[now] = groupNum;
            dfs(next);
        }
        else {
            if(finished[next] == 1 ) {
                group[now] = group[next];
            }
            else {
                group[now] = groupNum;
                int count = 1;
                for(int start = next; start != now; start = people[start]) count++;
                cycleGroup[groupNum] = count;
                groupNum++;
            }
        }
        finished[now] = 1;
        //return groupNum;
    }
}
