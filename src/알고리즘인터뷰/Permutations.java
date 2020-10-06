package 알고리즘인터뷰;

import java.util.*;

public class Permutations {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> numbers = new ArrayList<>();
        for(Integer i : nums) numbers.add(i);
        List<Integer> ans = new ArrayList<>();

        findGroup(numbers, ans);

        return answer;
    }

    private void findGroup(List<Integer> numbers, List<Integer> ans) {
        if(numbers.isEmpty()) {
            answer.add(ans);
            return;
        }

        for(int i = 0 ; i < numbers.size() ; i++) {
            Integer num = numbers.get(i);
            List<Integer> nowNumbers = new ArrayList<>(numbers);
            nowNumbers.remove(num);
            List<Integer> temp = new ArrayList<>(ans);
            temp.add(num);
            findGroup(nowNumbers,temp);

        }
    }

}