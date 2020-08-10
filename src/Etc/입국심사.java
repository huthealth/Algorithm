package Etc;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = 0;
        for(int time : times){
            if( time > right) right = time;
        }
        right *= n;
        long middle = (left + right) / 2;

        while(left < right){
            int sum = 0;
            for(int i = 0;i<times.length;i++){
                sum += middle/times[i];
            }
            if(sum < n) {
                left = middle +1;
            }
            else {
                right = middle - 1;
                answer = middle;
            }
        }
        return answer;
    }
}
