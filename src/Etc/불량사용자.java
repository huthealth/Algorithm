package Etc;

import java.util.*;
import java.util.regex.Pattern;

public class 불량사용자 {
    public int B;
    public List<String>[] ary;
    public Set<Set<String>> totalSet;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        B = banned_id.length;
        HashSet<String> set = new HashSet<>();

        for(int i =0; i<user_id.length;i++) set.add(user_id[i]);
         ary = new ArrayList[banned_id.length];

        for(int i =0;i<banned_id.length;i++){
            banned_id[i] = banned_id[i].replaceAll("\\*",".");
        }
        for(int i =0;i<banned_id.length;i++){
            for(int j =0;j<user_id.length;j++){
                if(user_id[j].matches(banned_id[i])) ary[i].add(user_id[j]);
            }
        }

        countSet(0,new HashSet<String>());
        return answer;
    }
    public void countSet(int now, Set<String> s){
        if(now == B){
            Set<String> set = new HashSet<>();
            for(String str : s) set.add(str);
            totalSet.add(set);
            return;
        }
        for(int i =0;i<ary[now].size();i++){
            int size = s.size();
            s.add(ary[now].get(i));
            if(size ==s.size()) continue;
            countSet(now+1,s);
            s.remove(ary[now].get(i));
        }
    }
    public static void main(String... args){
        //String s = "";
        //System.out.println(s.length());
        String id= "fr*d*";
        String reg = id.replace("*", "[\\w\\d]");
        System.out.println(id);
        //String[] users = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        //String[] ban = {"*rodo", "*rodo", "******"};
        //System.out.println(b.solution(users,ban));


    }
}
