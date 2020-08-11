package Programmers;

public class 가장큰정사각형찾기 {
    public int solution(int [][]board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        if(row < 2 || col < 2) {
            for(int y = 0; y < row; y++) {
                for(int x = 0; x < col; x++) {
                    if(board[y][x] == 1) return 1;
                }
            }
            return 0;
        }

        for(int y = 1; y < row; y++) {
            for(int x = 1; x< col; x++) {
                //System.out.println(y+ " "+x);
                if(board[y][x] == 0) continue;
                int leftUp = board[y-1][x-1];
                int left = board[y][x-1];
                int up = board[y-1][x];
                board[y][x] = Math.min(leftUp,Math.min(left,up)) + 1;
                if(answer < board[y][x]) answer = board[y][x];
            }
        }
        return answer * answer;
    }
}
