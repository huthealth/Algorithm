package Etc;

public class Kakao4 {
    public int[][] map;
    public int[] dy = {1,0,0};
    public int[] dx = {0,1,-1};
    public int[][] visited;
    public int[][] cache;
    public int N;
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;

        visited = new int[N+1][N+1];
        cache = new int[N][N];
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                cache[i][j] = -1;
            }
        }
        map = board;
        answer = makeRoad(0,0,-1,0);
        return answer;
    }

    public int makeRoad(int y,int x, int direction, int money){
        if(y == N-1 && x == N-1) return money;

        if(cache[y][x] != -1 ) return cache[y][x];
        cache[y][x] =Integer.MAX_VALUE;
        //int ret =Integer.MAX_VALUE;
        for(int i =0;i<3;i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextX >=0 && nextY >= 0 &&nextY <N && nextX<N && visited[nextX][nextY] == 0 &&map[nextY][nextX] != 1){
                visited[nextX][nextY] = 1;
                if(direction == -1){
                    cache[y][x] = Math.min(cache[y][x],makeRoad(nextY,nextX,i,money+100));
                }
                else if(i == direction){
                    cache[y][x] = Math.min(cache[y][x],makeRoad(nextY,nextX,i,money+100));
                }
                else{
                    cache[y][x] = Math.min(cache[y][x],makeRoad(nextY,nextX,i,money+600));
                }
                visited[nextX][nextY] = 0;
            }
        }
        return  cache[y][x];
    }
    public static void main(String... args){
        Kakao4 k = new Kakao4();
        int[][] b= {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(k.solution(b));
    }
}
