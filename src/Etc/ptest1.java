package Etc;

import java.util.HashSet;
import java.util.Set;

public class ptest1 {
    public int solution(int p) {
        int answer = 0;
        while (true) {
            p = p + 1;
            if (checkYear(p)) return p;
        }

    }
    public boolean checkYear(int p){
        Set<Character> set = new HashSet<>();
        String year = Integer.toString(p);
        for(int i =0;i<year.length();i++){
            if(set.contains(year.charAt(i))) return false;
            set.add(year.charAt(i));
        }
        return true;
    }

}
