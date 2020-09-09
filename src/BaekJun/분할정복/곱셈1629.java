/*
곱셈을 B번하는데 B가 10^9승을 넘으므로 O(N)으로도 시간초과
 O(logN)으로 풀어야한다고 생각하니 분할정복사용함 알 수 있음 ( ex) 퀵소트, 머지소트)

방법 1 :
총 계산해야하는 횟수 cnt를 2로 나눈 cnt1과 cnt에서 cnt1을 뺀 cnt2 만큼 재귀 돌려줌
( 5번 계산 -> 2번계산 * 3번 계산 )
이때 중복되는 계산이 생긴다. ( 3번 계산 -> 2번계산 * 1번계산인데
5번 계산의 왼쪽(2번 계산) 에서 이미 2번계산 했으므로 그 값을 사용 할 수 있음)
Map 자료구조를 사용해 저장해서 중본 계산을 제거해주면 O(logN)으로 풀 수 있다

방법 2 :
Map을 안쓰는 방법 존재할 거 같아서 찾아봄
찾아보니 cnt를 2로 나눈 결과를 곱하면서 return하면 따로 저장하지 않아도 된다.
대신 cnt가 홀수일 경우 곱하고 A를 한번 더 곱해줘야한다.


 */
package BaekJun.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 곱셈1629 {
    static Map<Long,Long> map = new HashMap<>();
    static long A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        A = Long.parseLong(inputs[0]);
        B = Long.parseLong(inputs[1]);
        C = Long.parseLong(inputs[2]);

        long answer = dac2(B);
        System.out.println(answer);


    }

    private static long dac(long cnt) {
        if(cnt == 1) return A%C;
        if(map.containsKey(cnt)) return map.get(cnt);

        long cnt1 = cnt/2;
        long cnt2 = cnt - cnt1;
        long ret = (dac(cnt1) * dac(cnt2)) % C;
        map.put(cnt,ret);
        return ret;

    }

    private static long dac2(long cnt) {
        if(cnt == 1) return A%C;

        long ret = dac2(cnt/2);
        if(cnt%2 == 1) return ((ret * ret)% C * (A%C)) ;
        return (ret * ret) % C;
    }
}
