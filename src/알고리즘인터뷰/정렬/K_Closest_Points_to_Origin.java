package 알고리즘인터뷰.정렬;

import java.util.Arrays;
import java.util.regex.Matcher;

public class K_Closest_Points_to_Origin {
    static class Point{
        int dist;
        int index;
        Point(int i, int d){
            index = i;
            dist = d;
        }

    }
    public int[][] kClosest(int[][] points, int K) {
        Point[] pAry = new Point[points.length];
        for(int i = 0 ; i< points.length; i++) {
            int dist = (int)(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            pAry[i] = new Point(i,dist);
        }
        Arrays.sort(pAry,(p1,p2)->Integer.compare(p1.dist,p2.dist));

        int[][] answer=  new int[K][2];

        for(int i = 0 ; i< K; i++){
            answer[i][0] = points[pAry[i].index][0];
            answer[i][1] = points[pAry[i].index][1];
        }



        return answer;
    }
}
