package Etc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 캠핑 {
    class Pos{
        int y;
        int x;
        Pos(int y, int x) {
            this.y = y;
            this.x =x;
        }
        @Override
        public int hashCode()
        {
            String hash = Integer.toString(y) + Integer.toString(x);
            return hash.hashCode();
        }
        @Override
        public boolean equals(Object o) {
            return this.x == ((Pos)o).x && this.y == ((Pos)o).y;
        }
    }
    public int solution(int n, int[][] data) {
        int answer = 0;
        Map<String, List<String>> pair = new HashMap<>();
        for(int i = 0;i<n-1;i++) {
            for(int j = i+1;j<n;j++) {
                int x1,x2,y1,y2;
                y1 = data[i][0];
                x1 = data[i][1];
                y2 = data[j][0];
                x2 = data[j][1];
                if(y1 == y2 || x2 == x1) continue;
                String nail1 = "";
                String nail2 = "";
                //nail1 = y1;
            }
        }
        return answer;
    }
}
