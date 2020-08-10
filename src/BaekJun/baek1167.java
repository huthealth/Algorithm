package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*

public class BaekJun.baek1167 {
    static List<List<Integer>> connectedNode = new ArrayList<>();
    static int[] visited;
    static int[] findRoot;
    static Map<String,Integer> nodeLenMap = new HashMap<>();
    static int N;
    static int maxLen = 0;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);

        for(int i =0;i<N+1;i++) {
            connectedNode.add(new ArrayList<>());
        }
        visited = new int[N+1];
        findRoot = new int[N+1];
        for(int i = 0;i < N; i++){
            String[] str = br.readLine().split(" ");
            int y = Integer.parseInt(str[0]);
            findRoot[y]++;
            String nodeToNode = "";
            for(int j = 1;j<str.length-1;j += 2) {
                int x = Integer.parseInt(str[j]);
                findRoot[x]++;
                int len = Integer.parseInt(str[j+1]);
                nodeToNode = str[0] + str[j];
                nodeLenMap.put(nodeToNode,len);
                connectedNode.get(y).add(x);
            }
        }
        for(int i =1;i<=N;i++) {

                visited[i] = 1;
                dfs(i);
                Arrays.fill(visited,0);

        }
        //dfs(1);
        System.out.println(maxLen);
    }
    static int dfs(int now) {
        if(connectedNode.get(now).size() == 1 && now != 1) return 0;

        int ret = -1;
        int ret2 = -1;
        int size = connectedNode.get(now).size();
        if(size == 1 || size == 2) {
            for(int i = 0; i<connectedNode.get(now).size();i++) {
                int nextNode = connectedNode.get(now).get(i);
                if(visited[nextNode] != 0 ) continue;
                visited[nextNode] = 1;
                String nodeToNode = Integer.toString(now) + Integer.toString(nextNode);
                ret = dfs(nextNode) + nodeLenMap.get(nodeToNode);
                if(maxLen < ret) {
                    System.out.println("하나짜리: "+ ret);
                    maxLen = ret;
                }
            }
        }
        else {
            for (int i = 0; i < connectedNode.get(now).size(); i++) {
                int nextNode = connectedNode.get(now).get(i);
                if (visited[nextNode] != 0) continue;
                visited[nextNode] = 1;
                String nodeToNode = Integer.toString(now) + Integer.toString(nextNode);
                if(ret == -1) ret = dfs(nextNode) + nodeLenMap.get(nodeToNode);
                else ret2 = dfs(nextNode) + nodeLenMap.get(nodeToNode);
            }
            if(maxLen < ret + ret2) {
                System.out.println("두개짜리 : "+ ret + " "+ret2);
                maxLen = ret+ret2;
            }
            ret = Math.max(ret,ret2);
        }
        return ret;
    }
}

*/

public class baek1167 {
    static List<List<Integer>> connectedNode = new ArrayList<>();
    static int[] visited;
    static Map<String, Integer> nodeLenMap = new HashMap<>();
    static int N;
    static int maxLen = 0;
    static int dNode = -1;

    public static void main(String... args) throws IOException {
        Exception r = new IOException();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);

        for (int i = 0; i < N + 1; i++) {
            connectedNode.add(new ArrayList<>());
        }
        visited = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int y = Integer.parseInt(str[0]);
            String nodeToNode = "";
            for (int j = 1; j < str.length - 1; j += 2) {
                int x = Integer.parseInt(str[j]);
                int len = Integer.parseInt(str[j + 1]);
                nodeToNode = str[0] + str[j];
                nodeLenMap.put(nodeToNode, len);
                connectedNode.get(y).add(x);
            }
        }
        visited[1]= 1;
        dfs(1,0);
        Arrays.fill(visited,0);
        visited[dNode] = 1;
        dfs(dNode,0);
        System.out.println(maxLen);
    }

    static void dfs(int now, int length) {
        int count = 0;
        for (int i = 0; i < connectedNode.get(now).size(); i++) {
            int nextNode = connectedNode.get(now).get(i);
            if (visited[nextNode] != 0) continue;
            count++;
            visited[nextNode] = 1;
            String nodeToNode = Integer.toString(now) + Integer.toString(nextNode);
            dfs(nextNode, length + nodeLenMap.get(nodeToNode));
        }
        if (count == 0) {
            if (maxLen < length) {
                dNode = now;
                maxLen = length;
            }
        }
    }
}