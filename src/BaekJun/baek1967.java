package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek1967 {
    static List<List<Integer>> connectedNode = new ArrayList<>();
    static int[] visited;
    static Map<String, Integer> nodeLenMap = new HashMap<>();
    static int N;
    static int dNode;
    static int maxLen = 0;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);

        for (int i = 0; i < N + 1; i++) {
            connectedNode.add(new ArrayList<>());
        }
        visited = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            String[] str = br.readLine().split(" ");
            int parent = Integer.parseInt(str[0]);
            String nodeToNode,nodeToNode2;
            int child = Integer.parseInt(str[1]);
            int len = Integer.parseInt(str[2]);
            nodeToNode = str[0] + str[1];
            nodeToNode2 =  str[1] + str[0];
            nodeLenMap.put(nodeToNode, len);
            nodeLenMap.put(nodeToNode2, len);
            connectedNode.get(parent).add(child);
            connectedNode.get(child).add(parent);
        }


        visited[1] = 1;
        dfs(1, 0);
        Arrays.fill(visited, 0);
        visited[dNode] = 1;
        dfs(dNode, 0);
        System.out.println(maxLen);
    }

    static void dfs(int now, int length) {
       // System.out.println("현재 : " + now + " 길이 : " + length);
        if(maxLen < length) {
            dNode = now;
            maxLen = length;
        }

        for (int i = 0; i < connectedNode.get(now).size(); i++) {
            int nextNode = connectedNode.get(now).get(i);
            if (visited[nextNode] != 0) continue;
            visited[nextNode] = 1;
            String nodeToNode = Integer.toString(now) + Integer.toString(nextNode);
            dfs(nextNode, length + nodeLenMap.get(nodeToNode));
        }

    }
}

