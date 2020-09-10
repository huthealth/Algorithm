package 알고리즘인터뷰;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        String str = "eat";
        Map<String,List<String>> map = new HashMap<>();

        /*
        for(int i = 0 ; i< strs.length ; i++) {
            int temp = 0;
            for(int j = 0 ; j< strs[i].length(); j++) {
                temp = temp | (1<<(strs[i].charAt(j)-'a'));
            }
            if(!map.containsKey(temp)) map.put(temp,new ArrayList<>());
            map.get(temp).add(strs[i]);
        }


         */
        int[] alphabets = new int[27];
        for(int i = 0 ; i< strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                alphabets[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(alphabets);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
            Arrays.fill(alphabets, 0);
        }
        List<List<String>> answer = new ArrayList<>();
        for(String s : map.keySet()) {
            answer.add(map.get(s));
        }
        return answer;
    }
}
