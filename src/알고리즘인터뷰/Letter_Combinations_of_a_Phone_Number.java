package 알고리즘인터뷰;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
    Map<Character,String> phone = new HashMap<>();
    List<String> answer = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")) return answer;
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");
        StringBuilder ans = new StringBuilder("");
        makeLetter(ans,digits,0);
        return answer;
    }

    private void makeLetter(StringBuilder ans, String digits, int now) {
        if(now == digits.length()){
            answer.add(ans.toString());
            return;
        }

        String nowStr = phone.get(digits.charAt(now));
        for(int i = 0 ; i< nowStr.length(); i++) {
            ans.append( nowStr.charAt(i));
            makeLetter(ans,digits,now+1);
            ans.deleteCharAt(ans.length()-1);
        }
    }
}