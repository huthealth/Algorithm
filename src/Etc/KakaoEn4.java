package Etc;

import java.io.*;
import java.util.*;

class KakaoEn4 {
    static final int INF = Integer.MAX_VALUE;
    static Map<String, List<String>> formationMap;
    static Map<String,Integer> scoreMap;
    static Map<String,Integer> indexMap;
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        formationMap = new HashMap<>();
        scoreMap = new HashMap<>();
        indexMap = new HashMap<>();

        int index = 0;
        for(int i = 0 ; i< M ;i++){
            String[] token = br.readLine().split(" ");
            String from  = token[0];
            String to = token[1];
            int score = Integer.parseInt(token[2]);
            String scoreStr = from+to;
            scoreMap.put(scoreStr,score);
            if(formationMap.containsKey(from)) formationMap.get(from).add(to);
            else {
                formationMap.put(from,new ArrayList<>());
                formationMap.get(from).add(to);
                indexMap.put(from,index++);
            }
        }
        visited = new int[indexMap.size()];

        int C = Integer.parseInt(br.readLine());
        String[][] query = new String[C][2];
        for(int i = 0 ; i<C;i++){
            String[] token = br.readLine().split(" ");
            query[i][0] = token[0];
            query[i][1] = token[1];
        }

        for(int i =0; i < C;i++){
            Arrays.fill(visited,0);
            int answer = INF;
            Integer now = indexMap.get(query[i][0]);
            if(now == null) {
                System.out.println(-1);
                continue;
            }
            visited[now] = 1;
            answer = Math.min(answer, changeFormation(query[i][0],query[i][1]));
            if(answer == INF) System.out.println(-1);
            else System.out.println(answer);
        }
    }

    static int changeFormation(String from, String dest){
        if(from.equals(dest)){
            Character a = 'a';

            return 0;
        }
        int ret = 0;

        List<String> nowList = formationMap.get(from);
        for(int i = 0;i<nowList.size();i++){
            String next = nowList.get(i);
            Integer index = indexMap.get(next);
            if(index == null) {
                String scoreStr = from+next;
                if(scoreMap.containsKey(scoreStr) && next.equals(dest)) {
                    if(ret == 0) return ret = scoreMap.get(scoreStr);
                    else return ret = Math.min(ret, scoreMap.get(scoreStr) + ret);
                }
            }
            else if(visited[index] == 0) {
                visited[index] = 1;
                String scoreStr = from + next;
                if( ret == 0) ret = scoreMap.get(scoreStr) + changeFormation(next,dest);
                ret = Math.min(ret,scoreMap.get(scoreStr) + changeFormation(next,dest));
                visited[index] = 0;
            }
        }
        if(ret == 0)
            ret = INF;
        return ret;
    }
}