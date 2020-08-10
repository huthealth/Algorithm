package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek13305 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        long[] city = new long[N];
        long[] road = new long[N-1];
        input = br.readLine();
        String[] firstLine = input.split(" ");
        for(int i = 0; i<N-1;i++) {
            road[i] =   Long.parseLong(firstLine[i]);
        }
        input = br.readLine();
        String[] secondLine = input.split(" ");
        for(int i = 0; i<N;i++) {
            city[i] =   Long.parseLong(secondLine[i]);
        }
        long cost = 0;
        for(int i = 0;i<N-1;i++) {
            long nowCost = city[0];
            for(int j = 1; j<=i ; j++){
                if(nowCost > city[j]) nowCost = city[j];
            }
            cost += nowCost * road[i];
            //System.out.println("더한값 : "+ cost + "최소가격 : " + nowCost + "길이 : "  + city[i]);
        }
        System.out.println(cost);
    }
}
