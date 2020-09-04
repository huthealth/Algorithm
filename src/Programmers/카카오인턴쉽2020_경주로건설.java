package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오인턴쉽2020_경주로건설 {
    public class Block {
        int y;
        int x;
        int dir;
        int cost;
        Block(int y, int x, int dir, int cost) {
            this.y =y;
            this.x =x;
            this.dir =dir;
            this.cost = cost;
        }
    }
    int[] dy = {0,0,-1,1};
    int[] dx = {-1,1,0,0};
    int[][] visited;
    int N;
    public int solution(int[][] board) {
        int answer = 0;

        N = board.length;
        Queue<Block> q = new LinkedList<>();
        visited = new int[N][N];
        for(int i = 0 ; i<N; i++) Arrays.fill(visited[i],-1);
        q.add(new Block(0,0,-1,0));

        while(!q.isEmpty()) {

            Block b = q.poll();
            System.out.println("현재 위치"+b.y +":"+b.x+":"+b.cost);
            for(int i = 0 ; i<4 ;i++) {
                int ny = b.y + dy[i];
                int nx = b.x + dx[i];
                if(ny >=0 && ny < N && nx >=0 && nx < N) {
                    int nCost = 0;
                    if(b.dir == -1) {
                        visited[ny][nx] = 100;
                        q.add(new Block(ny,nx,i,100));
                        continue;
                    }
                    if(i == b.dir) nCost = b.cost + 100;
                    else nCost = b.cost + 500;
                    if(visited[ny][nx] != -1 && visited[ny][nx] < nCost) continue;
                    visited[ny][nx] = nCost;
                    q.add(new Block(ny,nx,i,nCost));
                }
            }
        }

        answer = visited[N-1][N-1];
        return answer;
    }

    public static void main(String[] args) {
        카카오인턴쉽2020_경주로건설 kakao = new 카카오인턴쉽2020_경주로건설();
        int[][] map = {{0,0,0},{0,0,0},{0,0,0}};
        kakao.solution(map);
    }
}
