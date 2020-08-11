package Programmers;

public class 일24의나라 {
    private static int[] oneTwoFour = {1,2,4};
    public String solution(int n) {
        String answer = "";
        while(n > 0) {
            --n;
            int mod = n % 3;
            n /= 3;
            answer = oneTwoFour[mod] + answer;
        }
        return answer;
    }
}
