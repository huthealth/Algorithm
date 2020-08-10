package AlgoSpot;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
public class 단어제한끝말잇기 {
    private static final String FAIL = "IMPOSSIBLE";
    private static int[][] adj;
    private static String[] words;
    private static boolean[] visited;
    private static int N;
    private static boolean success;
    private static List<String> wordGame;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0; i < c ; i++) {
            N = Integer.parseInt(br.readLine());
            adj = new int[N][N];
            visited = new boolean[N];
            words = new String[N];
            for(int j = 0 ; j < N; j++) words[j] = br.readLine();
            wordGame = new ArrayList<>(N);
            success = false;
            makeGraph();
            dfsAll();
            if(!success) {
                System.out.println(FAIL);
            }
            else {
                for(String word : wordGame) System.out.print(word+" ");
                System.out.println();
            }
        }
    }

    private static void dfs(int here, int wordLeft) {

        if(wordLeft == 0) {
            success = true;
            wordGame.add(0,words[here]);
            return;
        }
        for(int i = 0 ; i < N; i++) {
            if(success) {
                wordGame.add(0,words[here]);
                return;
            }
            if(visited[i] == false && adj[here][i] == 1) {
                visited[i] = true;
                dfs(i,wordLeft-1);
                visited[i] = false;
            }
        }
        if(success) {
            wordGame.add(0, words[here]);
        }
    }

    private static void dfsAll() {
        for(int i = 0; i< N; i++) {
            if(success) break;
            visited[i] = true;
            dfs(i,N-1);
            visited[i] = false;
        }
    }


    private static void makeGraph() {
        for(int i = 0; i < N;i++) {
            char lastChar = words[i].charAt(words[i].length()-1);
            for(int j = 0; j< N;j++) {
                if(i !=j  && words[j].charAt(0) == lastChar) {
                    adj[i][j] = 1;
                }
            }
        }
    }
}


 */
public class 단어제한끝말잇기 {
    private static int[][] adj;
    private static List<List<List<String>>> graph;

    private static int[] indegree;
    private static int[] outdegree;
    private static String[] words;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< c ; i++) {
            int n = Integer.parseInt(br.readLine());
            words = new String[n];
            for(int j = 0 ; j< n; j++) {
                words[j] = br.readLine();
            }
            String ret = solve();
            System.out.println(ret);
        }
    }

    public static void makeGraph() {

        graph = new ArrayList<>(26);
        for(int i = 0 ; i < 26; i++) {
            graph.add( new ArrayList<>(26));
            for(int j = 0 ; j< 26; j++) {
                graph.get(i).add(new ArrayList<>());
            }
        }

        adj = new int[26][26];
        indegree = new int[26];
        outdegree = new int[26];

        for(int i = 0; i < words.length; i++) {
            int a = words[i].charAt(0) - 'a';
            int b = words[i].charAt(words[i].length()-1) - 'a';
            graph.get(a).get(b).add(words[i]);
            adj[a][b]++;
            outdegree[a]++;
            indegree[b]++;
        }
    }

    public static List<Integer> getEulerTrailOrCircuit() {
        List<Integer> circuit = new ArrayList<>();
        for(int i = 0 ; i < 26; i++) {
            if(outdegree[i] == indegree[i] + 1) {
                getEulerCircuit(i,circuit);
                return circuit;
            }
        }

        for(int i = 0 ; i < 26; i++) {
            if(outdegree[i] > 0) {
                getEulerCircuit(i,circuit);
                return circuit;
            }
        }
        return circuit;
    }

    public static void getEulerCircuit(int here, List<Integer> circuit) {
        for(int next = 0; next < 26; next++) {
            while(adj[here][next] > 0) {
                adj[here][next]--;
                getEulerCircuit(next,circuit);
            }
        }
        circuit.add(0,here);
    }

    public static boolean checkEuler() {
        int plus1 = 0;
        int minus1 = 0;
        for(int i = 0 ; i < 26 ; i++) {
            int delta = outdegree[i] - indegree[i];
            if(delta < -1 || delta > 1) return false;
            if(delta == 1) plus1++;
            if(delta == -1) minus1++;
        }

        return (plus1 == 1 && minus1 ==1) || (plus1 == 0 && minus1 == 0);
    }

    public static String solve() {
        makeGraph();
        if(!checkEuler()) return "IMPOSSIBLE";
        List<Integer> circuit = getEulerTrailOrCircuit();
        if(circuit.size() != words.length + 1) return "IMPOSSIBLE";

        String ret = "";
        for(int i =1 ; i < circuit.size(); i++) {
            int a = circuit.get(i-1);
            int b = circuit.get(i);
            if(ret != "") ret += " ";
            ret += graph.get(a).get(b).get(0);
            graph.get(a).get(b).remove(0);
        }
        return ret;
    }

}