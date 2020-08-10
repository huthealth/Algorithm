package Etc;

public class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int[][][] visited = new int[4][11][11];
        for(int i = 0; i < dirs.length(); i++) {
            int direction = -1;
            int direction2 = -1;
            int nextX = x;
            int beforeX = x;
            int nextY = y;
            int beforeY = y;
            if(dirs.charAt(i) == 'U') {
                direction = 0;
                direction2 = 1;
                nextY  -= 1;
            }
            else if(dirs.charAt(i) == 'D') {
                direction = 1;
                direction2 = 0;
                nextY += 1;
            }
            else if(dirs.charAt(i) == 'R') {
                direction = 2;
                direction2 = 3;
                nextX += 1;
            }
            else {
                direction = 3;
                direction2 = 2;
                nextX -= 1;
            }

            if(nextY >=0 && nextY <= 10 && nextX >=0 && nextX <= 10) {
                if(visited[direction][nextY][nextX] == 0) {
                    visited[direction][nextY][nextX] = 1;
                    visited[direction2][beforeY][beforeX] = 1;
                    answer++;
                }
                x = nextX;
                y = nextY;
            }
            //System.out.println(i+"번째 위치(y,x) : "+ y + " " + x );
        }
        return answer;
    }
}