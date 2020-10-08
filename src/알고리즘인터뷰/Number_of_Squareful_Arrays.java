package 알고리즘인터뷰;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
public class Number_of_Squareful_Arrays {
    int answer = 0;
    int[] nums;
    int[] visited;


    public int numSquarefulPerms(int[] A) {
        this.nums = A;
        visited = new int[nums.length];

        premuteUnique2(new ArrayList<>());
        return answer;
    }

    private void premuteUnique2(List<Integer> ans){
        if(ans.size() == nums.length){
            for(int i = 0 ; i< ans.size()-1;i++){
                int sum = ans.get(i) + ans.get(i+1);
                double sqrtSum = Math.sqrt(sum);
                if(sqrtSum - (int)sqrtSum > 0) return;
            }
            answer++;

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

    public static void main(String[] args) {
        Number_of_Squareful_Arrays t = new Number_of_Squareful_Arrays();
        int[] ary = {1,17,8};
        System.out.println(t.numSquarefulPerms(ary));
    }
}
*/

public class Number_of_Squareful_Arrays {
    int answer = 0;
    int[] nums;
    int[] visited;

    public int numSquarefulPerms(int[] A) {
        this.nums = A;
        visited = new int[nums.length];

        premuteUnique2(new ArrayList<>());
        return answer;
    }

    private void premuteUnique2(List<Integer> ans){
        if(ans.size() == nums.length){
            answer++;
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< nums.length; i++) {
            if(visited[i] == 1 || set.contains(nums[i])) continue;
            visited[i] = 1;
            set.add(nums[i]);
            ans.add(nums[i]);
            if(ans.size() >=2){
                int a = ans.get(ans.size()-1);
                int b = ans.get(ans.size() -2);
                int sum = a+b;
                double sqrtSum = Math.sqrt(sum);
                if(sqrtSum - (int)sqrtSum > 0) {
                    ans.remove(ans.size()-1);
                    visited[i] = 0;
                    continue;
                }
            }
            premuteUnique2(ans);
            ans.remove(ans.size()-1);
            visited[i] = 0;
        }
    }
}