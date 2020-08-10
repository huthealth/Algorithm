/*
시간초과
arraylist 접근하는 시간때문에 인듯
array그냥 사용하기
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class 예산 {

    public List<Integer> budgetList;
    public int left,middle,right;
    public int solution(int[] budgets, int M) {

        budgetList = new ArrayList<>();
        for(int budget : budgets) {
            budgetList.add(budget);
        }
        Collections.sort(budgetList);
        //left = budgetList.get(0);
        left = 0;
        right = budgetList.get(budgetList.size()-1);
        middle = (left + right) /2;

        int answer = 0;
        while(left <= right){
            int nowBudget =0;

            for(int i =0;i<budgetList.size();i++){
                if(middle > budgetList.get(i)) nowBudget += budgetList.get(i);
                else nowBudget += middle;
            }

            if(nowBudget > M){
                right = middle - 1;
            }
            else{
                answer = middle;
                left = middle+1;
            }
            middle = (left + right)/2;
        }
        return answer;
    }
    public static void main(String... args){
        int[] a = 	{120, 110, 140, 150,300,267,120,50,105,90,30,15,80,12,55,90,10,99,15,45,32,66,15,10,40,30,29,48,239,300,321,90};
        int m = 640;
        예산 b = new 예산();
        System.out.println(b.solution(a,m));
    }
}
*/