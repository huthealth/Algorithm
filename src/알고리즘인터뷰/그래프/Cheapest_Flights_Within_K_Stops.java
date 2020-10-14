package 알고리즘인터뷰.그래프;

import java.util.Arrays;
import java.util.PriorityQueue;


//성공한 다익스트라
// 빠름
// 더 빠른 방법 -> 인접행렬이 아닌 인접리스트 사용하기
// 도착지 처음 도착한 시점이 도착지에 가장 적은 돈으로 도착한 경우이므로 종료
// pq에 넣는 조건 :  연결되있고 stop+1 이 k보다 작을경우 모두 넣는 것
// pq에 넣는 틀린 조건 : 다음 행선지의 값을 저장해놓고 그 값보다 클 경우 pq에 넣지 않으면 틀림
// 왜냐하면 값이 큰 경우가 나중에 총 합이 더 적을 수 있기 때문
class Solution {
    static class Now{
        int city;
        int price;
        int stop;
        Now(int c, int p, int s){
            city = c;
            price = p;
            stop = s;
        }
    }
    static final int MAX_VALUE= 9999999;
    int minValue = 9999999;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] prices = new int[n][n];

        for(int i = 0 ; i<n; i++) Arrays.fill(prices[i],MAX_VALUE);
        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            prices[from][to] = price;
        }
        int[] ary = new int[n];
        Arrays.fill(ary,MAX_VALUE);
        PriorityQueue<Now> pq= new PriorityQueue<>((n1,n2)->{return Integer.compare(n1.price,n2.price);});
        int[] visited = new int[n];
        int answer = MAX_VALUE;

        pq.add(new Now(src,0,-1));
        ary[src] = 0;
        while(!pq.isEmpty()){
            Now now = pq.poll();
            if(now.city == dst) return now.price;

            for(int i = 0; i< n; i++) {

                if(prices[now.city][i] != MAX_VALUE && now.stop+1 <= K) {
                    pq.add(new Now(i,now.price + prices[now.city][i],now.stop+1));
                }
            }
        }
        return -1;
    }
}

//빠른 DFS
// 도착지 도착시 minPrice 갱신, dfs 메소드 안에서 minPrice보다 큰 값이거나 stop+1이 K보다 높을 경우 정지
class DFS2 {
    static final int MAX_VALUE = 9999999;
    int minPrice = 9999999;
    int DEST;
    int K;
    int N;
    int[][] prices;
    int[] visited;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        prices = new int[n][n];
        DEST = dst;
        this.K = K;
        N = n;
        visited = new int[n];
        for (int i = 0; i < n; i++) Arrays.fill(prices[i], MAX_VALUE);
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            prices[from][to] = price;
        }


        dfs(src,0,-1);
        if(minPrice == MAX_VALUE) return -1;
        return minPrice;
    }

    private void dfs(int now, int price ,int stop) {
        if(now == DEST) {
            if(stop <= K) minPrice = Math.min(minPrice,price);
        }

        for(int i = 0; i< N; i++) {
            if(visited[i] == 1 || stop + 1 > K|| now == i || prices[now][i] == MAX_VALUE || price + prices[now][i] > minPrice) continue;
            visited[i] = 1;
            dfs(i,price + prices[now][i],stop+1);
            visited[i] = 0;
        }
    }
}

//느린 dfs
public class Cheapest_Flights_Within_K_Stops {

    static final int MAX_VALUE = 9999999;
    int minPrice = 9999999;
    int DEST;
    int K;
    int N;
    int[][] prices;
    int[] visited;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        prices = new int[n][n];
        DEST = dst;
        this.K = K;
        N = n;
        visited = new int[n];
        for (int i = 0; i < n; i++) Arrays.fill(prices[i], MAX_VALUE);
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            prices[from][to] = price;
        }


        dfs(src,0,-1);
        if(minPrice == MAX_VALUE) return -1;
        return minPrice;
    }

    private void dfs(int now, int price ,int stop) {
        if(now == DEST) {
            if(stop <= K) minPrice = Math.min(minPrice,price);
        }

        for(int i = 0; i< N; i++) {
            if(visited[i] == 1 || stop + 1 > K|| now == i || prices[now][i] == MAX_VALUE) continue;
            visited[i] = 1;
            dfs(i,price + prices[now][i],stop+1);
        }
    }
}

/*

실패한 다익스트라
public class Cheapest_Flights_Within_K_Stops {
    static class Now{
        int city;
        int price;
        int stop;
        Now(int c, int p, int s){
            city = c;
            price = p;
            stop = s;
        }
    }
    static final int MAX_VALUE= 9999999;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] prices = new int[n][n];

        for(int i = 0 ; i<n; i++) Arrays.fill(prices[i],MAX_VALUE);
        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            prices[from][to] = price;
        }
        int[] ary = new int[n];
        Arrays.fill(ary,MAX_VALUE);
        PriorityQueue<Now> pq= new PriorityQueue<>((n1,n2)->{return Integer.compare(n1.price,n2.price);});
        int[] visited = new int[n];
        int answer = MAX_VALUE;

        pq.add(new Now(src,0,-1));
        ary[src] = 0;
        while(!pq.isEmpty()){
            Now now = pq.poll();

            if(visited[now.city] == 1 || now.stop >= K) continue;
            System.out.println(now.city+" "+now.price+" "+now.stop);
            visited[now.city] = 1;
            for(int i = 0; i< n; i++) {
                if(visited[i] == 1|| now.stop+1 > K) continue;
                if(ary[i] > now.price + prices[now.city][i]){
                    ary[i] = now.price + prices[now.city][i];
                    pq.add(new Now(i,ary[i],now.stop+1));
                }
            }
        }
        if(ary[dst] == MAX_VALUE) return -1;
        return ary[dst];
    }
}
*/
