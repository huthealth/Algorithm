package 알고리즘인터뷰.분할정복;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = nums.length/2;
        for(int i = 0 ; i< nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>count) return nums[i];
        }
        return -1;
    }
}
