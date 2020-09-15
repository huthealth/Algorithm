package BaekJun.시뮬레이션;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.Map;

public class 낚시왕17143 {
    private static class Shark {
        int size;
        int speed;
        int dir;
        Shark(int size, int speed, int dir){
            this.size = size;
            this.speed = speed;
            this.dir = dir;
        }
    }

    static Shark[][] nextMap;
    static Shark[][] nowMap;
    static int R;
    static int C;
    static int M;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,1,-1};
    static Map<Integer,Integer> dirMap= new HashMap<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        M = Integer.parseInt(inputs[2]);

        nextMap = new Shark[R][C];
        nowMap = new Shark[R][C];
        dirMap.put(0,1);
        dirMap.put(1,0);
        dirMap.put(2,3);
        dirMap.put(3,2);
        for(int i = 0 ; i< M ;i++) {
            inputs = br.readLine().split(" ");
            int y = Integer.parseInt(inputs[0]) -1;
            int x = Integer.parseInt(inputs[1]) -1;
            int speed = Integer.parseInt(inputs[2]);
            int dir = Integer.parseInt(inputs[3]) - 1;
            int size = Integer.parseInt(inputs[4]);
            nowMap[y][x] = new Shark(size,speed,dir);
        }

        /*
        System.out.println();
        for(int i = 0 ; i < R ;i++) {
            for( int j = 0 ; j< C ;j++) {
                if(nowMap[i][j] == null) System.out.print(0+" ");
                else System.out.print(nowMap[i][j].size + " ");
            }
            System.out.println();
        }

         */


        for(int person = 0; person < C; person++) {

            for(int i =0 ; i< R; i++) {
                if(nowMap[i][person] != null) {
                    answer += nowMap[i][person].size;
                    nowMap[i][person] = null;
                    break;
                }
            }

            /*
            System.out.println(person+1 +"초");
            System.out.println();
            for(int i = 0 ; i < R ;i++) {
                for( int j = 0 ; j< C ;j++) {
                    if(nowMap[i][j] == null) System.out.print(0+" ");
                    else System.out.print(nowMap[i][j].size + " ");
                }
                System.out.println();
            }

             */


            for(int i = 0 ; i< R ; i++) {
                for(int j = 0 ; j< C ; j++) {
                    if(nowMap[i][j] == null) continue;
                    Shark s = nowMap[i][j];
                    int y = i;
                    int x = j;
                    int leftMove = s.speed;
                    while(true) {
                        if(x + dx[s.dir] * leftMove < 0 ){// y + dy[s.dir] * leftMove < 1) {
                            s.dir = dirMap.get(s.dir);
                            leftMove -= (x );
                            x = 0;
                        }
                        else if(y + dy[s.dir] * leftMove < 0 ) {
                            s.dir = dirMap.get(s.dir);
                            leftMove -= ( y );
                            y = 0;
                        }
                        else if (x + dx[s.dir] * leftMove >= C) {
                            s.dir = dirMap.get(s.dir);
                            leftMove =leftMove -  ( C - x ) + 1;
                            x = C-1;
                        }
                        else if (y + dy[s.dir] * leftMove >= R) {
                            s.dir = dirMap.get(s.dir);
                            leftMove = leftMove -  ( R - y ) + 1;
                            y = R-1;
                        }
                        else {
                            x = x + dx[s.dir] * leftMove;
                            y = y + dy[s.dir] * leftMove;
                            break;
                        }
                    }
                    if(nextMap[y][x] == null || (nextMap[y][x].size < s.size) ){
                        nextMap[y][x] = s;
                    }
                }
            }


            for(int i = 0 ; i < R ;i++) {
                for( int j = 0 ; j< C ;j++) {
                    nowMap[i][j] = nextMap[i][j];
                    nextMap[i][j] = null;
                }
            }

            /*
            System.out.println();
            for(int i = 0 ; i < R ;i++) {
                for( int j = 0 ; j< C ;j++) {
                    if(nowMap[i][j] == null) System.out.print(0+" ");
                    else System.out.print(nowMap[i][j].size + " ");
                }
                System.out.println();
            }

             */
        }
        System.out.println(answer);
    }
}
