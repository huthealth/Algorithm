package Programmers;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class 줄서는방법 {
    public int[] solution(int n, BigInteger k) {
        int[] answer = {};
        int N = n;
        BigInteger bigK = k;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while(ans.size() < N-1) {
            BigInteger temp = BigInteger.valueOf(n-1);
            BigInteger cnt1 =  BigInteger.valueOf(1);
            while(temp.compareTo(BigInteger.valueOf(1)) > 0) {
                cnt1 = cnt1.multiply(temp);
                temp = temp.subtract(BigInteger.valueOf(1));
            }

            BigInteger cnt2 = bigK.divide(cnt1);
            if(!bigK.mod(cnt1).equals(BigInteger.valueOf(0))) cnt2 = cnt2.add(BigInteger.valueOf(1));
            BigInteger cnt3 = BigInteger.valueOf(1);
            for(int i = 1; i<=N; i++) {
                if(!set.contains(i)) {
                    if (cnt2.equals(cnt3)) {
                        set.add(i);
                        ans.add(i);
                        break;
                    }
                    cnt3 = cnt3.add(BigInteger.valueOf(1));
                }
            }
            n--;
            bigK = bigK.subtract( cnt1.multiply(cnt2.subtract(BigInteger.valueOf(1))));
        }
        for(int i = 1; i<=N; i++) {
            if(!set.contains(i)) {
                ans.add(i);
                break;
            }
        }
        answer = new int[ans.size()];
        for(int i = 0 ; i< N; i++) answer[i] = ans.get(i);
        //for(int i : answer) System.out.println(i);

        return answer;
    }

    public static void main(String[] args) {
        줄서는방법 a = new 줄서는방법();
        BigInteger k = new BigInteger("2432902008176640000");
        //System.out.println(Arrays.toString(a.solution(3, 5)));
        System.out.println(Arrays.toString(a.solution(20, k)));
    }
}
