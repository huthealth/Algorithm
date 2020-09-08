package Programmers;

import java.util.HashSet;
import java.util.Set;

public class 후보키 {
    private Set<Integer> answerSet = new HashSet<>();

    public int solution(String[][] relation) {
        int answer = 0;
        int r,c;
        r = relation.length;
        c = relation[0].length;
        for(int i = 1; i< (1<<c); i++) {
            boolean isKey = true;
            Set<String> tempKeySet = new HashSet<>();
            for(int row = 0; row< r ;row++) {
                String tempKey ="";

                int col = c-1;

                for(int k = 1; k<= i; k = k <<1) {
                    if((k & i) != 0) {
                        tempKey += relation[row][col];
                    }
                    col--;
                }
                if(tempKeySet.contains(tempKey)) {
                    isKey = false;
                    break;
                }
                tempKeySet.add(tempKey);
            }
            if(isKey && checkKey(i)) answerSet.add(i);
        }
        return answerSet.size();
    }

    private boolean checkKey(int newKey) {
        for(Integer key : answerSet) {
            boolean isKey = false;
            for(int i = 1; i<=Math.min(newKey,key); i = i <<1) {
                if((newKey & i) != 0 && (key & i) == 0) {
                    isKey = true;
                    break;
                }
            }
            if(!isKey) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String[][] ary = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        후보키 a = new 후보키();
        System.out.println( a.solution(ary));
    }
}
