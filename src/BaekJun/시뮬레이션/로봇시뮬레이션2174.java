package BaekJun.시뮬레이션;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 로봇시뮬레이션2174 {
    private static class Robot{
        int y;
        int x;
        int dir;
        Robot(int y, int x, int dir){
            this.y =y ;
            this.x =x ;
            this.dir =dir;
        }
    }
    private static class Order {
        int robot;
        char order;
        int cnt;
        Order(int r, char o, int c) {
            robot = r;
            order = o;
            cnt = c;
        }
    }

    static int A;
    static int B;
    static int[][] map;
    static Robot[] robots;
    static Order[] orders;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        A = Integer.parseInt(inputs[0]);
        B = Integer.parseInt(inputs[1]);
        map = new int[B+1][A+1];
        Map<String,Integer> dir = new HashMap<>() ;
        dir.put("N",0);
        dir.put("W",1);
        dir.put("S",2);
        dir.put("E",3);
        inputs = br.readLine().split(" ");
        int N  = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        robots = new Robot[N+1];
        for(int i = 0 ; i< N; i++) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = B - Integer.parseInt(inputs[1]) +1;
            int d = dir.get(inputs[2]);
            robots[i+1] = new Robot(y,x,d);
            map[y][x] = i+1;
        }
/*
        System.out.println();
        for(int i = 1; i<= B; i++) {
            for(int j =1 ; j<= A ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();

        }

 */

        for(int i = 0 ; i< M ; i++) {
            inputs = br.readLine().split(" ");
            int robotNum = Integer.parseInt(inputs[0]);
            String nowOrder = inputs[1];
            int cnt = Integer.parseInt(inputs[2]);
            if(!simulation(robotNum,nowOrder,cnt)) return;
/*
            System.out.println();
            for(int ii = 1; ii<= B; ii++) {
                for(int j =1 ; j<= A ; j++) {
                    System.out.print(map[ii][j]+" ");
                }
                System.out.println();

            }

 */

        }
        System.out.println("OK");
    }

    private static boolean simulation(int robotNum, String nowOrder, int cnt) {
        Robot r = robots[robotNum];
        if(nowOrder.equals( "L")) {
            r.dir = (r.dir + cnt) %4;
            return true;
        }
        if(nowOrder.equals("R")) {
            r.dir = (r.dir + 3*cnt) %4;
            return true;
        }
        map[r.y][r.x] = 0;

        for(int i = 0 ; i < cnt; i++) {
            int ny = r.y + dy[r.dir];
            int nx = r.x + dx[r.dir];

            if(ny <1 || ny > B || nx < 1 || nx > A) {
                System.out.println("Robot "+ robotNum +" crashes into the wall");
                return false;
            }
            if(map[ny][nx] != 0) {
                System.out.println("Robot "+robotNum+" crashes into robot " + map[ny][nx]);
                return false;
            }
            r.y = ny;
            r.x =nx;
        }
        map[r.y][r.x] = robotNum;
        return true;
    }

}
