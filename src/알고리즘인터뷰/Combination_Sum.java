package 알고리즘인터뷰;

import java.util.ArrayList;
import java.util.List;
/*
public class Combination_Sum {
    private List<List<Integer>> answer = new ArrayList<>();
    private int T;
    private int N;
    private int[] C;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        T = target;
        N = candidates.length;
        C = candidates;
        List<Integer> ans = new ArrayList<>();
        findCombination(ans, 0,0);
        for(List<Integer> list : answer) {
            for(Integer i : list) System.out.println(i);
        }
        return answer;
    }

    private void findCombination(List<Integer> ans, int total, int now) {
        if( total == T ) {
            answer.add(ans);
            return;
        }

        while( now < N && total <= T ) {
            ans.add(C[now]);
            total += C[now];
            for(int i = now+1; i<=N; i++) {
                findCombination(new ArrayList<>(ans),total,i);
            }
        }
    }

    public static void main(String[] args) {
        Combination_Sum c=  new Combination_Sum();
        int[] a = {2,3,6,7};
        c.combinationSum(a,7);
    }
}


 */
/*
public class Combination_Sum {
    private List<List<Integer>> answer = new ArrayList<>();
    private int T;
    private int N;
    private List<List<Integer>> cList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        T = target;
        N = candidates.length;
        for(int i = 0; i < candidates.length; i++) {
            int total = candidates[i];
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates[i]);
            while(total <= target){
                cList.add(new ArrayList<>(temp));
                total += candidates[i];
                temp.add(candidates[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        findCom(ans,0,0);



        return answer;
    }

    private void findCom(List<Integer> ans, int now, int total) {

        System.out.println();
        for(int i = 0 ; i< ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
        if (total == T) {

            answer.add(new ArrayList<>(ans));
            return;
        }

        for (int i = now; i < cList.size(); i++) {
            int temp = 0;
            for (int j = 0; j < cList.get(i).size(); j++) {
                int num = cList.get(i).get(j);
                ans.add(num);
                temp += num;
            }
            if (total + temp <= T) {
                findCom(ans, i + 1, total + temp);
            }
            for (int j = 0; j < cList.get(i).size(); j++) {
                Integer num = cList.get(i).get(j);
                ans.remove(num);
            }
        }


    }

    public static void main(String[] args) {
        Combination_Sum c=  new Combination_Sum();
        int[] a = {2,3,6,7};
        c.combinationSum(a,7);
    }

}

 */

public class Combination_Sum {
    List<List<Integer>> answer = new ArrayList<>();
    int T;
    int N;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        T =  target;
        N = candidates.length;
        this.candidates = candidates;

        findSum(new ArrayList<Integer>(), 0,0);
        return answer;
    }

    private void findSum(ArrayList<Integer> ans, int sum,int now) {
        if(sum == T){
            answer.add(new ArrayList<>(ans));
            return;
        }
        if(sum > T) return;

        for(int i = now; i < N; i++) {
            ans.add(candidates[i]);
            sum += candidates[i];
            findSum(ans,sum ,i);
            sum -= candidates[i];
            ans.remove(ans.size()-1);
        }
    }
}