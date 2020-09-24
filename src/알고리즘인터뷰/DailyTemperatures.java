package 알고리즘인터뷰;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] answer = new int[T.length];
        Arrays.fill(answer,9999);
        List<List<Integer>> tempCnt = new ArrayList<>(101);
        for(int i = 0 ; i<= 100; i++) {
            tempCnt.add( new LinkedList<>());
        }

        for(int i = 0 ; i< T.length; i++) {
            tempCnt.get(T[i]).add(i);
        }

        for(int i = 0 ; i< T.length; i++) {
            boolean found = false;
            int nowT = T[i];
            tempCnt.get(nowT).remove(0);
            for(int j = nowT+1; j<=100; j++) {
                if(!tempCnt.get(j).isEmpty()) {
                    found = true;
                    answer[i] = Math.min(answer[i],tempCnt.get(j).get(0) - i);
                }
            }
            if(!found) answer[i] = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures t = new DailyTemperatures();
        int[] ary = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(t.dailyTemperatures(ary)));
    }
}
