/*
그냥 소트하고 더해주는 방법 -> 실패
이유 : 더해서 만든 카드덩어리가 기존 카드뭉치들보다 클 경우 순서를 바꿔줘야한다 -> 2번 빼고 1번 넣고 소트 반복해줘야함 -> 시간초과

 해법 : 우선순위큐를 사용하면 두번 빼고 1번 넣고를 반복 시 알아서 최소 크기의 카드뭉치 2개가 나온다.
 */
package BaekJun.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기1715 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0; i<N; i++) {
            pq.offer( Integer.parseInt(br.readLine()) );
        }

        int answer = 0;
        while(pq.size()  > 1) {
            int c1 = pq.poll();
            int c2 = pq.poll();
            int c3 = c1+ c2;
            answer += c3;
            pq.offer(c3);
        }
        System.out.println(answer);

    }
}
