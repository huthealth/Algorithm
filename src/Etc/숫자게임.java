package Etc;

import java.util.Arrays;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int score = 0;
        int N = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int indexA,indexB;
        indexA = indexB = 0;
        while(indexA <N && indexB < N) {
            if(A[indexA] < B[indexB]) {
                score++;
                indexA++;
                indexB++;
            }
            else indexB++;
        }
        return score;
    }
}
