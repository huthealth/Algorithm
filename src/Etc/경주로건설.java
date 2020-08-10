import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*

public class 경주로건설 {
    private static int N;
    private static int[][] cache;
    private static int[][] map;
    private static final int INF = 9999999;
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,-1,0,1};

    public int solution(int[][] board) {
        N = board.length;
        map = board;
        cache = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            Arrays.fill(cache[i],INF);
        }

        cache[0][0] = 0;
        int answer = INF;
        answer = Math.min(answer,getMinCost(0,0,0,-1));
        return answer;
    }

    private int getMinCost(int y, int x, int cost, int dir) {
        if(y == N-1 && x == N-1) return cost;

        if(cache[y][x] <= cost ) return INF;

        for(int i = 0; i <4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && ny < N && nx >=0 && nx < N && cache[ny][nx] > cost) {
                cache[ny][nx] = ;
                if(dir == -1 || dir == i)  ret = Math.min(ret,getMinCost(ny,nx,i) + 100);
                else ret = Math.min(ret,getMinCost(ny,nx,i) + 500);
                visited[ny][nx] = 0;
            }
        }
        return ret;
    }
}


/*
bfs + visited
틀림 -> 맞음
틀린 이유 : 먼저 도착한다고 cost 적은것 아님
고친 부분 : visited 배열을 cache로 바꿔 도착한 곳의 cost가 현재 cost보다 작으면 종료


public class 경주로건설 {
    private static class Entity{
        int y;
        int x;
        int dir;
        int total;
        public Entity(int y, int x, int dir,int total) {
            this.y= y;
            this.x = x;
            this.dir = dir;
            this.total = total;
        }
    }
    private static int N;
    private static int[][] cache;
    private static int[][] map;
    private static final int INF = 999999;
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,-1,0,1};

    public int solution(int[][] board) {

        int answer = INF;
        map = board;
        N = board.length;
        cache = new int[N][N];

        for(int i = 0 ; i<N;i++){
            Arrays.fill(cache,INF);
        }

        cache[0][0] = 0;

        Queue<Entity> q = new LinkedList<>();
        q.add(new Entity(0,0,-1,0));
        while(!q.isEmpty()) {
            Entity now = q.poll();
            if(now.y == N-1 && now.x == N-1){
                answer = Math.min(answer,now.total);
                continue;
            }
            for(int i = 0; i <4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny >=0 && ny < N && nx >=0 && nx < N &&map[ny][nx] == 0 &&cache[ny][nx] > now.total) {

                    if(now.dir == -1 || now.dir == i)  {
                        cache[ny][nx] = now.total + 100;
                        q.add(new Entity(ny,nx,i,now.total+100));
                    }
                    else{
                        cache[ny][nx] = now.total + 100;
                        q.add(new Entity(ny,nx,i,now.total+600));
                    }
                }
            }
        }
        return answer;
    }
}
/*

public class 경주로건설 {
    private  static int count = 1;
    private static int N;
    private static int[][][] cache;
    private static int[][] visited;
    private static int[][] map;
    private static final int INF = 1000000;
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,-1,0,1};

    public int solution(int[][] board) {
        N = board.length;
        map = board;
        cache = new int[N][N][4];
        for(int i = 0 ; i< N; i++){
            for(int j = 0; j<N;j++){
                Arrays.fill(cache[i][j],INF);
            }
        }
        visited = new int[N][N];
        visited[0][0] = 1;
        int answer = getMinCost(0,0,-1);
        return answer;
    }

    private int getMinCost(int y, int x, int dir) {
        if(y == N-1 && x == N-1) return  0;
        if(dir != -1 && cache[y][x][dir] != INF){
            return cache[y][x][dir];
        }

        for(int i = 0; i <4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >=0 && ny < N && nx >=0 && nx < N && map[ny][nx] == 0 && visited[ny][nx] ==0) {
                visited[ny][nx] = 1;
                if(dir == -1) {
                    cache[y][x][0] = Math.min(cache[y][x][0],getMinCost(ny,nx,i) + 100);
                    visited[ny][nx] = 0;
                }
                else if(dir == i)  cache[y][x][dir] = Math.min(cache[y][x][dir],getMinCost(ny,nx,i) + 100);
                else cache[y][x][dir] = Math.min(cache[y][x][dir],getMinCost(ny,nx,i) + 600);
                visited[ny][nx] = 0;
            }
        }
        if(dir == -1) return cache[y][x][0] ;
        return cache[y][x][dir];
    }

    public static void main(String... args){
        경주로건설 a = new 경주로건설();
        int[][] board = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
        System.out.println(a.solution(board));

    }
}


 */