package Programmers;

import com.sun.javafx.scene.control.ReadOnlyUnbackedObservableList;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    private class Route {
        Integer start;
        Integer end;
        Route(int s, int e) {
            start = s;
            end  = e;
        }
    }
    public int solution(int[][] routes) {
        int answer = 1;

        Route[] routeAry = new Route[routes.length];

        for(int i = 0 ; i< routes.length ; i++) {
            routeAry[i] = new Route(routes[i][0],routes[i][1]);
        }
        Arrays.sort(routeAry, new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.start.compareTo(o2.start);
            }
        });

        int nowEnd = routeAry[0].end;
        for(int i = 1; i < routeAry.length;i++ ) {
            Route r = routeAry[i];
            if(nowEnd < r.start ) {
                answer++;
                nowEnd = r.end;
            }
        }

        return answer;
    }
}
