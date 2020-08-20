package BaekJun.BFS;

import sun.util.resources.cldr.yav.CalendarData_yav_CM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DSLR9019 {
    private static class CalNumber{
        int n;
        String s;
        int d1;
        int d2;
        int d3;
        int d4;
        public CalNumber(int n, int d1, int d2, int d3, int d4,String s){
            this.n = n;
            this.s =s;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
            this.d4 = d4;
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t< T ;t++) {
            String[] inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);
            int[] visited = new int[10000];
            CalNumber calA = getCalNumber(A,"");
            Queue<CalNumber> q = new LinkedList<>();
            q.offer(calA);
            visited[A] = 1;
            while(!q.isEmpty()) {
                CalNumber c = q.poll();
                if(c.n == B) {
                    System.out.println(c.s);
                    break;
                }

                //D
                CalNumber afterCal = getCalNumber(2*c.n %10000,c.s +'D');

                if(visited[afterCal.n] == 0) {
                    visited[afterCal.n] = 1;
                    q.offer(afterCal);
                }

                //S
                if(c.n == 0) afterCal = getCalNumber(9999,c.s +'S');
                else afterCal = getCalNumber(c.n-1,c.s + 'S');
                if(visited[afterCal.n] == 0) {
                    visited[afterCal.n] = 1;
                    q.offer(afterCal);
                }

                //R
                afterCal = getCalNumber(c.d4 * 1000 + c.d1 * 100 + c.d2 * 10 + c.d3,c.s + 'R');
                if(visited[afterCal.n] == 0 ) {
                    visited[afterCal.n] = 1;
                    q.offer(afterCal);
                }
                //L
                afterCal = getCalNumber(c.d2 * 1000 + c.d3 * 100 + c.d4 * 10 + c.d1,c.s + 'L');
                if(visited[afterCal.n] == 0 ) {
                    visited[afterCal.n] = 1;
                    q.offer(afterCal);
                }

            }
        }
    }

    private static CalNumber getCalNumber(Integer number, String cal) {
        int beforeCal = number;
        int n1,n2,n3,n4;
        String s1,s2,s3,s4;
        n1 = number/ 1000;
        number -= n1*1000;
        n2 = number/100;
        number -=n2*100;
        n3 = number/10;
        number -= n3*10;
        n4 = number;

        return new CalNumber(beforeCal,n1,n2,n3,n4,cal);
    }
}
