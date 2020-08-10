import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
public class 컬러링북 {

    private static class Pixel {
        int y;
        int x;
        int id;
        Pixel(int y,int x,int id){
            this.y = y;
            this.x = x;
            this.id = id;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {

        int[][] visited = new int[m][n];
        Map<Integer,Integer> numberOfArea = new HashMap<>();
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        Queue<Pixel> queue = new LinkedList<>();

        int id = 0;
        if(picture[0][0] == 0) queue.add(new Pixel(0,0,-1));
        else {
            numberOfArea.put(id,1);
            queue.add(new Pixel(0,0,id++));
        }
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            Pixel nowPixel = queue.poll();
            int nowY = nowPixel.y;
            int nowX = nowPixel.x;
            int nowColor = picture[nowY][nowX];
            int nowId = nowPixel.id;
            visited[nowY][nowX] = 1;
            for(int i =0;i<4;i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                int nextColor;
                if(nextY >=0 && nextY < m && nextX >=0 && nextX < n && visited[nextY][nextX] ==0) {
                    nextColor = picture[nextY][nextX];

                    if(nextColor == 0) {
                        queue.add(new Pixel(nextY,nextY,-1));
                    }
                    else {
                        if(nowColor == nextColor) {
                            int nowAreaCount = numberOfArea.get(nowId);
                            numberOfArea.put(nowId, nowAreaCount+1);
                            queue.add(new Pixel(nextY,nextX,nowId));
                        }
                        else {
                            if(numberOfArea.)
                        }
                    }
                }
            }
        }




        int[] answer = new int[2];
        return answer;
    }
}
*/
