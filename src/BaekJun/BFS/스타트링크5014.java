package BaekJun.BFS;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 스타트링크5014 {

    private static int[] visited;
    private static int minClick = -1;
    private static int F,S,G,U,D;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        F = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        G = Integer.parseInt(inputs[2]);
        U = Integer.parseInt(inputs[3]);
        D = Integer.parseInt(inputs[4]);

        visited = new int[F+1];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(S,0));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int click = p.y;
            int floor = p.x;
            if(floor == G) {
                minClick = click;
                break;
            }
            click++;
            if(floor + U <= F && visited[floor+U] == 0){
                visited[floor+U] = 1;
                queue.add(new Point(floor+U, click));
            }
            if(floor - D > 0 && visited[floor- D] == 0) {
                visited[floor- D] = 1;
                queue.add(new Point(floor-D,click));
            }
        }

        if(minClick == -1) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(minClick);
        }

    }
}

/*
dfs는 스택 오버플로우 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 스타트링크5014 {

    private static int[] visited;
    private static int minClick = -1;
    private static int F, S, G, U, D;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        F = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        G = Integer.parseInt(inputs[2]);
        U = Integer.parseInt(inputs[3]);
        D = Integer.parseInt(inputs[4]);

        visited = new int[F + 1];
        visited[S] = 1;
        dfs(S,0);

        if(minClick == -1) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(minClick);
        }
    }

    private static void dfs(int now, int click) {
        if (now == G) {
            minClick = click;
            return;
        }
        if (now + U <= F && visited[now + U] == 0) {
            visited[now + U] = 1;
            dfs(now + U, click + 1);
        }
        if (now - D > 0 && visited[now - D] == 0) {
            visited[now - D] = 1;
            dfs(now - D, click + 1);
        }
    }
}


 */