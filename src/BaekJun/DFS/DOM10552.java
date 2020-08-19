package BaekJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DOM10552 {
    /*
    private static class Person {
        int like;
        int hate;

        public Person(int l, int h) {
            like = l;
            hate = h;
        }
    }

     */

    static int N;
    static int M;
    static int P;
    static int[] visited;
    static int[] channels; // hate - like
   // static Person[] people;
    static boolean isCycled = false;
    static int countOfChange = 0;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        P = Integer.parseInt(inputs[2]);

        //people = new Person[N];
        visited = new int[M + 1];
        channels = new int[M+1];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            int like = Integer.parseInt(inputs[0]);
            int hate = Integer.parseInt(inputs[1]);
            if(channels[hate] == 0) channels[hate] = like;
        }


        visited[P] = 1;
        if(channels[P] != 0) {
            P = channels[P];
            countOfChange++;
            dfs(P);
        }

        if (isCycled) {
            System.out.println(-1);
            return;
        }
        System.out.println(countOfChange);
    }

    private static void dfs(int now) {

        int next = channels[now];
        if(next != 0) {
            if (visited[next] == 0) {
                visited[next] = 1;
                countOfChange++;
                dfs(next);
            } else {
                isCycled = true;
            }
        }
    }
}
        /*
        for (int i = 0; i < N; i++) {
            if (people[i].hate == now) {
                P = people[i].like;
                if (visited[P] == 0) {
                    visited[P] = 1;
                    countOfChange++;
                    dfs(P);
                } else {
                    isCycled = true;
                }
                break;
            }
        }

         */

