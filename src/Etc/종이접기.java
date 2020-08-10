package Etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 종이접기 {
    public List<Integer> foldingBucket = new ArrayList<>();
    public int N;
    //int[] answer;
    //int index =0;
    public void folding(int now, int leftRight){
        if(now == N) {
            foldingBucket.add(leftRight);
            //answer[index++] = leftRight;
            return;
        }

        folding(now+1,0);
        //answer[index++] = leftRight;
        foldingBucket.add(leftRight);
        folding(now+1,1);
    }

    public int[] solution(int n) {
        int[] answer = {};
        N = n;
        int len = (int)Math.pow(2,n) - 1;
        answer = new int[len];
        folding(1,0);




        answer = new int[foldingBucket.size()];
        for(int i =0; i<foldingBucket.size();i++) {
            answer[i] = foldingBucket.get(i);
        }

        return answer;
    }
}
