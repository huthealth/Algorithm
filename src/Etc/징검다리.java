package Etc;

import java.util.Arrays;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        int mid = (left+right)/2;
        Arrays.sort(rocks);
        while(left <= right){
            int sum = 0;
            int prev= 0;
            for(int i =0;i<rocks.length;i++){
                if(rocks[i] - prev >= mid ){
                    prev = rocks[i];
                }
                else{
                    sum++;
                }
            }
            if(distance - prev >= mid) prev = distance;
            else sum++;

            if( sum > n || prev != distance) right = mid -1;
            else {
                answer = mid;
                left = mid +1;
            }
            mid = (left + right) /2;
        }
        return answer;
    }
}
