package Etc;

import java.util.*;

public class tuple {
    public int[] solution(String s) {
        List<Integer> ans = new ArrayList<>();
        List<ArrayList<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] answer = {};

        s= s.substring(2,s.length()-2);
        String[] str = s.split("},\\{");
        if(str.length == 1){
            int[] temp = new int[1];
            temp[0] = Integer.parseInt(str[0]);
            return temp;
        }

        for(int i =0; i<str.length;i++){
            System.out.println(str[i]);
            ArrayList<Integer> ary = new ArrayList<>();
            String[] num = str[i].split(",");
            for(int j = 0;j<num.length;j++){
                //System.out.print(num[j]+" ");
                //ary.add(Integer.parseInt(num[j]));
            }
            list.add(ary);
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() > o2.size()) return 1;
                if(o1.size()< o2.size()) return -1;
                return 0;
            }
        });
        for(int i =0;i<list.size();i++){
            for(int j =0;j<list.get(i).size();j++){
                if(set.contains(list.get(i).get(j))) continue;
                set.add(list.get(i).get(j));
                ans.add(list.get(i).get(j));
            }
        }
        answer = new int[ans.size()];
        for(int i =0;i<ans.size();i++) answer[i] = ans.get(i);

        return answer;
    }
    public static void main(String... args){

       tuple t = new tuple();
       String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(t.solution(s));
    }
}
