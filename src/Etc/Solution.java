package Etc;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int N;
    public int[][] map;
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        map = board;
        answer = tetris();
        return answer;
    }
    public int findBlock(int y, int x){
        if(y-1 >=0 && x+2<N && map[y][x] == map[y-1][x] && map[y][x] == map[y][x+1] && map[y][x] == map[y][x+2] && map[y-1][x+1] == -1 && map[y-1][x+2] ==-1){
            map[y][x] =map[y][x+1] = map[y][x+2] = map[y-1][x] = map[y-1][x+1] = map[y-1][x+2] =0;
            return 1;
        }
        if(y-2 >=0 && x+1 <N && map[y][x] == map[y][x+1] &&map[y][x] == map[y-1][x+1] && map[y][x] ==map[y-2][x+1] && map[y-1][x] == -1 && map[y-2][x] == -1){
            map[y][x] = map[y][x+1] = map[y-1][x] = map[y-1][x+1] = map[y-2][x] = map[y-2][x+1] = 0;
            return 1;
        }
        if(y-2 >=0 &&x+1 < N&& map[y][x] ==map[y][x+1] && map[y][x] ==map[y-1][x] && map[y][x] == map[y-2][x] && map[y-1][x+1] == -1 && map[y-2][x+1] == -1){
            map[y][x] = map[y][x+1] = map[y-1][x] = map[y-1][x+1] = map[y-2][x] = map[y-2][x+1] = 0;
            return 1;
        }
        if(y-1>=0 && x+2 <N && map[y][x] == map[y][x+1] && map[y][x] ==map[y][x+2] && map[y][x] ==map[y-1][x+2] && map[y-1][x] == -1 && map[y-1][x+1] == -1){
            map[y][x] =map[y][x+1] = map[y][x+2] = map[y-1][x] = map[y-1][x+1] = map[y-1][x+2] =0;
            return 1;
        }
        if(y-1 >=0 && x+2<N && map[y][x] == map[y][x+1] && map[y][x] == map[y][x+2] && map[y][x] == map[y-1][x+1] && map[y-1][x] == -1 && map[y-1][x+2] == -1){
            map[y][x] =map[y][x+1] = map[y][x+2] = map[y-1][x] = map[y-1][x+1] = map[y-1][x+2] =0;
            return 1;
        }
        return 0;
    }

    public void dropBlock(int x){
        int i;
        for(i=0;i<N;i++){
            if(map[i][x] != 0) break;
        }
        if( i != 0) map[i-1][x] = -1;
    }

    public boolean checkEnd(){
        for(int i =0;i<N;i++){
            if(map[0][i] ==0) return false;
        }
        return true;
    }

    public int tetris(){
        int deleteBlock =0;
        while(true){
            if(checkEnd()) break;
            for(int  i=0;i<N;i++){
                dropBlock(i);
                for(int j =N-1;j>=0;j--){
                    for(int k=0;k<N;k++){
                        if(map[j][k] != 0 && map[j][k] != -1)
                            deleteBlock +=findBlock(j,k);
                    }
                }
            }
        }
        return deleteBlock;
    }
    public static void main(String... args){
        int[][] phone = {{3,1},{0,0}};

       // System.out.println(stack.pop());
       // System.out.println(stack.pop());
       // System.out.println(stack.pop());
    }
}