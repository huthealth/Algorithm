package Programmers;

public class 숫자의표현 {
    public int solution(int n) {
        int count = 1;
        for(int i = 1; i<= n/2; i++){
            if(makeNum(i,n)){
                count++;
            }
        }
        return count;
    }

    public boolean makeNum(int start, int num){
        int total = start;
        boolean isSuccess = false;
        while(total <= num) {
            if(total == num) {
                isSuccess = true;
                break;
            }
            start++;
            total += start;
        }
        return isSuccess;
    }
}
