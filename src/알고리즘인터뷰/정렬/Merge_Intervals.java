package 알고리즘인터뷰.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    private class Num{
        Integer from;
        Integer to;
        Num(int f, int t){
            from  = f;
            to = t;
        }
    }
    public int[][] merge(int[][] intervals) {
        Num[] nums = new Num[intervals.length];
        for(int i = 0 ; i<intervals.length;i++){
            nums[i] = new Num(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(nums,(n1,n2)->n1.from.compareTo(n2.from));
        List<Integer> mergeIndexs = new ArrayList<>();
        for(int i = 0 ; i< nums.length-1; i++){
            if(nums[i].to >= nums[i+1].from) {
                mergeIndexs.add(i);
                nums[i+1].from = nums[i].from;
                nums[i].from = 1;
                nums[i].to = 0;
            }
        }

        List<Num> answer = new ArrayList<>();
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i].from ==1 && nums[i].to == 0) continue;
            answer.add(new Num(nums[i].from,nums[i].to));
        }

        int[][] ans = new int[answer.size()][2];
        for(int i = 0 ; i<ans.length;i++){
            ans[i][0] = answer.get(i).from;
            ans[i][0] = answer.get(i).to;
        }

        return ans;



    }
}
