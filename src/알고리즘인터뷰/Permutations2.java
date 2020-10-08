package 알고리즘인터뷰;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    List<List<Integer>> answer = new ArrayList<>();
    int[] nums;
    int[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        visited = new int[nums.length];

        premuteUnique2(new ArrayList<>());
        return answer;
    }

    private void premuteUnique2(List<Integer> ans){
        if(ans.size() == nums.length){
            answer.add(new ArrayList<>(ans));
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< nums.length; i++) {
            if(visited[i] == 1 || set.contains(nums[i])) continue;
            visited[i] = 1;
            set.add(nums[i]);
            ans.add(nums[i]);
            premuteUnique2(ans);
            ans.remove(ans.size()-1);
            visited[i] = 0;
        }
    }
}