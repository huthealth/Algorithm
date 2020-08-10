package AlgoSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 고대어사전 {
    private static int[][] adj;
    private static int[] visited;
    private static String[] words;
    private static List<Integer> order;


    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< c ; i++) {
            int n = Integer.parseInt(br.readLine());
            words = new String[n];
            for(int j = 0 ; j < n ; j++) {
                words[j] = br.readLine();
            }
            adj = new int[26][26];
            visited = new int[26];
            order = new ArrayList<>();
            makeGraph();
            List<Integer> answer =  topologicalSort();
            if(answer == null) System.out.println("INVALID HYPOTHESIS");
            else {
                for (Integer integer : answer) {
                    System.out.print((char) (integer + 97));
                }
                System.out.println();
            }
        }
    }

    private static List<Integer> topologicalSort() {
        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        /*
        for(int i = order.size()-1 ; i>= 0;i--) {
            alphabet.add(order.get(i));
            reverseOrder.add(order.get(i));
        }
         */
        for(int i = 0 ; i < order.size()-1;i++) {
            if(adj[order.get(i+1)][order.get(i)] == 1) return null;
        }
        return order;
    }

    private static void dfs(int here) {
        visited[here] = 1;
        for(int i = 0 ; i < 26; i++) {
            if(adj[here][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
        order.add(0,here);
    }

    private static void makeGraph() {
        for(int i = 0 ; i< words.length-1;i++) {
            int j = i+1;
            int minLen = Math.min(words[i].length(),words[j].length());
            for(int k = 0 ; k< minLen; k++) {
                if(words[i].charAt(k)!= words[j].charAt(k)) {
                    int first = words[i].charAt(k) - 'a';
                    int second  = words[j].charAt(k) - 'a';
                    adj[first][second] = 1;
                    break;
                }
            }
        }
    }
}
