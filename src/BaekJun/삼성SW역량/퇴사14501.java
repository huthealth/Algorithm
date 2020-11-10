package BaekJun.삼성SW역량;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사14501 {
    static class Consult{
        int period;
        int price;
        Consult(int period, int price){
            this.period = period;
            this.price = price;
        }
    }

    static int N;
    static int maxPrice = 0;
    static Consult[] consults;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt( br.readLine());
        consults = new Consult[N+1];
        for(int i = 0 ; i< N ; i++){
            String[] inputs = br.readLine().split(" ");
            int period = Integer.parseInt(inputs[0]);
            int price = Integer.parseInt(inputs[1]);
            consults[i+1] = new Consult(period,price);
        }

        for(int i = 1 ; i <= N ; i++){
            getMaxPrice(i,0);
        }
        System.out.println(maxPrice);
    }

    private static void getMaxPrice(int now, int price) {
        if(now >= N+1) {
            maxPrice = Math.max(maxPrice,price);
            return;
        }

        int next = now + consults[now].period;
        if(next > N+1) {
            getMaxPrice(next,price);
            return;
        }

        for(int i =next; i <= N+1 ; i++) {
                getMaxPrice(i,price + consults[now].price);
        }

    }

}


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 퇴사14501 {
    static class Consult {
        int period;
        int price;

        Consult(int period, int price) {
            this.period = period;
            this.price = price;
        }
    }

    static int N;
    static int maxPrice = 0;
    static Consult[] consults;
    static int[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        consults = new Consult[N + 1];
        cache = new int[N+1];
        Arrays.fill(cache,-1);

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int period = Integer.parseInt(inputs[0]);
            int price = Integer.parseInt(inputs[1]);
            consults[i + 1] = new Consult(period, price);
        }

        for(int i = 1 ; i <=N ; i++) {
            maxPrice = Math.max(maxPrice, getMaxPrice(i));
        }
        System.out.println(maxPrice);
    }

    private static int getMaxPrice(int now) {
        if(now >= N+1) return 0;

        if(cache[now] != -1) return cache[now];

        cache[now] = 0;
        int next = now + consults[now].period;
        if(next > N+1) return cache[now] = 0;

        for(int i = next; i <= N+1; i++) {
            cache[now] = Math.max(cache[now],getMaxPrice(i) + consults[now].price);
        }
        return cache[now];
    }
}