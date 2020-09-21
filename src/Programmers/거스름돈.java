package Programmers;

import java.util.Arrays;
import java.util.Comparator;


/*
public class 거스름돈 {
    int N;
    int[] money;
    int[][] cache;
    static final int mod = 1000000007;

    public int solution(int n, int[] money) {
        int answer = 0;
        N = money.length;
        cache = new int[n+1][money.length];
        for(int i = 0 ; i<= n; i++) Arrays.fill(cache[i],-1);
        this.money = money;
//        for(int i = 0 ; i< N; i++){
//            if(n-money[i] < 0) continue;
            answer = (answer +countMoney(n,0)) % mod;
//        }
        return answer;
    }

    private int countMoney(int left, int choice) {
        if(left == 0) return 1;

        if(cache[left][choice] != -1) return cache[left][choice];

        cache[left][choice] = 0;
        for(int i = choice; i<N; i++){
            if(left - money[i] < 0) continue;
           cache[left][choice] = (cache[left][choice] + countMoney(left - money[i], i)) % mod;
        }
        return cache[left][choice];
    }

    public static void main(String[] args) {
        거스름돈 a = new 거스름돈();
        int[] ary = {1,2,5};
        System.out.println(a.solution(5,ary));

    }
}

 */
/*
bottom-up 방식

public class 거스름돈 {

    static final int mod = 1000000007;

    public int solution(int n, int[] money) {
        int answer = 0;
        int[][] cache = new int[money.length + 1][n + 1];
        int[] money2 = new int[money.length+1];
        for(int i =1 ; i<money2.length; i++) money2[i] = money[i-1];

        for (int i = 0; i <= money.length; i++) cache[i][0] = 1;

        for (int choice = 1; choice <= money.length; choice++) {
            for (int change = 1; change <= n; change++) {
               if(change < money2[choice]) cache[choice][change] = cache[choice-1][change];
               //else if(change == money2[choice]) cache[choice][change] = cache[choice-1][change] + 1;
               else cache[choice][change] =  (cache[choice-1][change] + cache[choice][change - money2[choice]]) % mod;
            }
        }

        return cache[money.length][n];
    }

    public static void main(String[] args) {
        거스름돈 a = new 거스름돈();
        int[] ary = {1, 2, 5};
        System.out.println(a.solution(5, ary));

    }
}


 */
public class 거스름돈 {
    int cnt = 0;
    int[][] cache;
    int[] money;
    static final int mod = 1000000007;
    public int solution(int n, int[] money) {
        int answer = 0;
        cache = new int[money.length+1][n+1];
        for(int i = 0 ; i<= money.length; i++) Arrays.fill(cache[i],-1);
        this.money = new int[money.length+1];
        for(int i = 1; i < money.length+1; i++) this.money[i] = money[i-1];
        answer = dp(money.length, n);
        return answer;
    }

    private int dp(int choice, int change) {
        cnt++;
        if(change == 0 ){
            return 1;
        }
        if(choice == 0) return 0;

        if(cache[choice][change] != -1) return cache[choice][change];

        if(money[choice] > change) {
            cache[choice][change] = dp(choice-1,change);
        }
        else {
            cache[choice][change] = dp(choice-1,change) + dp(choice,change - money[choice]);
        }
        return cache[choice][change];
    }
    public static void main(String[] args) {
        거스름돈 a = new 거스름돈();
        int[] ary = {1, 2, 5};
        int[] ary2 = {1,2,5,8,13,15,17,23,25,29};
        System.out.println(a.solution(1000, ary2));
        System.out.println(a.cnt);


    }

}