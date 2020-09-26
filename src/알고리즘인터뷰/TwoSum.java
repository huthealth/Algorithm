package 알고리즘인터뷰;

import java.util.*;

public class TwoSum {
    private class Num{
        Integer index;
        Integer value;
        Num(int i, int v){
            index = i;
            value = v;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Num[] numbers = new Num[nums.length];
        for(int i =0 ; i< nums.length; i++) {
            numbers[i] = new Num(i,nums[i]);
        }

        Arrays.sort(numbers, (o1, o2) -> o1.value.compareTo(o2.value));
        int lo = 0;
        int hi = numbers.length-1;
        while(lo < hi) {
            int sum  = numbers[lo].value + numbers[hi].value;
            if(sum == target) {
                answer[0] = numbers[lo].index;
                answer[1] = numbers[hi].index;
                break;
            }
            if(sum < target) lo++;
            else hi--;
        }
        return answer;
    }
}
