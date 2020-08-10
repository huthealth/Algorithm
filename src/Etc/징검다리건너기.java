package Etc;/*
시간초과
public class 징검다리건너기 {
    public int K;
    public int N;
    public int[] S;
    public int people =0;
    public int solution(int[] stones, int k) {
        S =stones;
        N = S.length;
        K = k;
        int answer = 0;
        while(true){
            if(!crossBride(0,K)) break;
        }

        return people;
    }
    public boolean crossBride(int now, int jump){
        if(jump == 0) return false;
        if(now == N){
            people++;
            return true;
        }
        if(S[now] ==0){
            return crossBride(now+1,jump-1);
        }
        S[now]--;
        return crossBride(now+1,K);
    }
}
*/

class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 0;
        for(int stone : stones){
            if(right < stone) right = stone;
        }
        int mid = (left + right) /2 ;

        while(left <= right){
            int count = 0;
            for(int i =0;i<stones.length;i++){
                if(count > k) break;
                if(stones[i] < mid) count++;
                else count = 0;
            }
            if(count > k) right = mid -1;
            else{
                answer = mid;
                left = mid +1;
            }
        }
        return answer;
    }
}