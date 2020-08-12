package Programmers;

public class 땅따먹기 {
    private int row;
    private int[][] board;
    private int[] colAry = {0,1,2,3};
    private int[][] cache;
    int solution(int[][] land) {
        int answer = 0;

        board = land;
        row = land.length;
        cache = new int[row][4];

        for(int i =0 ; i<4; i++){
            answer = Math.max(answer,getScore(i,0));
        }

        return answer;
    }

    private int getScore(int nowCol, int nowRow) {
        if( nowRow == row-1 ) {
            return board[nowRow][nowCol];
        }

        if(cache[nowRow][nowCol] !=0) return cache[nowRow][nowCol];

        for(int i = 1 ; i < 4 ; i++){
            cache[nowRow][nowCol] = Math.max(cache[nowRow][nowCol], getScore(colAry[(nowCol+i)%4],nowRow+1));
        }
        cache[nowRow][nowCol] += board[nowRow][nowCol];
        return cache[nowRow][nowCol];
    }
    public static void main(String... args){
        땅따먹기 a = new 땅따먹기();
        int[][] ary= 	{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println( a.solution(ary));
    }
}
