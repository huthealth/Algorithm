package 알고리즘인터뷰;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {
    List<List<Integer>> answer = new ArrayList<>();
    int N;
    int K;
    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K =k ;

        List<Integer> ans = new ArrayList<>();
        //for(int i = 1; i<=n ; i++)
        pickNum(ans,1);
        return answer;
    }

    private void pickNum(List<Integer> ans, int start) {
        if(ans.size() == K) {
            answer.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start; i <= N; i++) {
            ans.add(i);
            pickNum(ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
}

/*
public class Combinations {
    List<List<Integer>> answer = new ArrayList<>();
    Set<Set<Integer>> set = new HashSet<>();
    int N,K;
    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        recur(s,ans,0);
    }

    private void recur(Set<Integer> s, List<Integer> ans, int now) {
        if(now == K && !set.contains(s)){
            set.add(new HashSet<>(s));
            answer.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 1 ; i<= N; i++){
            if(s.contains(i)) continue;
            s.add(i);
            ans.add(i);
            recur(s,ans,now+1);
            s.remove(i);
            ans.remove(ans.size()-1);
        }

    }
}


 */