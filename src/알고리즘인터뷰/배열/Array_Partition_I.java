package 알고리즘인터뷰.배열;

import java.util.Arrays;

class Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i< nums.length-1; i+=2){
            total += Math.min(nums[i],nums[i+1]);
        }
        return total;
    }
}