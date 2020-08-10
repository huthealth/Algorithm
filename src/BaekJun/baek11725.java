package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
// 입력이 루트(1)부터 연결된 노드 순으로 진행되면 가능한 코드
// 실패하는걸 보니 예제만 위처럼 입력받고 나머지는 무작위인듯
public class BaekJun.baek11725 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        int[] tree = new int[N+1];
        Arrays.fill(tree,0);
        tree[1] = -1;
        for(int i  = 0 ;i<N-1;i++) {
            String[] str = br.readLine().split(" ");
            int node1 = Integer.parseInt( str[0] );
            int node2 = Integer.parseInt( str[1] );
            if(tree[node1] == 0) {
                tree[node1] = node2;
            }
            else {
                tree[node2] = node1;
            }
        }

        for(int i = 2; i<=N;i++) {
            System.out.println(tree[i]);
        }

    }
}
*/
public class baek11725 {
    static int[] visited;
    static int[] parent;
    static List<List<Integer>> connected;
    static int N;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        visited = new int[N + 1];
        parent = new int[N + 1];
        connected = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            connected.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String[] str = br.readLine().split(" ");
            int node1 = Integer.parseInt(str[0]);
            int node2 = Integer.parseInt(str[1]);
            connected.get(node1).add(node2);
            connected.get(node2).add(node1);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = 1;
            for (int i = 0; i < connected.get(node).size(); i++) {
                int connectedNode = connected.get(node).get(i);
                if (visited[connectedNode] == 1) {
                    parent[node] = connectedNode;
                } else {
                    queue.add(connectedNode);
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}