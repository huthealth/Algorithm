package Etc;

import java.util.HashMap;
import java.util.Map;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        double score = 0.0;
        int answer=0;
        int union =0;
        int intersect =0;
        /*
        String[] str11 = str1.split("[^a-zA-Z]");
        String[] str22 = str2.split("[^a-zA-Z]");
        str1 = "";
        str2 ="";
        for(int i =0;i<str11.length;i++) str1 += str11[i];
        for(int i=0;i<str22.length;i++) str2 += str22[i];
        */
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i =0;i<str1.length()-1;i++){
            String token = str1.substring(i,i+2);
            if(Character.isLetter(token.charAt(0)) &&Character.isLetter(token.charAt(1)))
                map1.put(token,map1.getOrDefault(token,0)+1);
        }
        for(int i =0;i<str2.length()-1;i++){
            String token = str2.substring(i,i+2);
            if(Character.isLetter(token.charAt(0)) &&Character.isLetter(token.charAt(1)))
                map2.put(token,map2.getOrDefault(token,0)+1);
        }
        if(map1.size() == 0 && map2.size()==0) return 1;
        for(String key : map1.keySet()){
            intersect += Math.min(map1.get(key),map2.getOrDefault(key,0));
        }
        for(String key : map1.keySet()){
            union += Math.max(map1.get(key),map2.getOrDefault(key,0));
        }
        for(String key : map2.keySet()){
            if(map1.containsKey(key)) continue;
            union += map2.get(key);
        }
        score = (double)intersect/union;
        score *= 65536;
        answer = (int)score;
        return answer;
    }
    public static void main(String... args){
        뉴스클러스터링 a = new 뉴스클러스터링();
        String s1 = "FRANCE";
        String s2 = "french";
        String s3 = "a+b+cD+%$#@!!11";
        s3 = s3.toLowerCase();
        System.out.println(s3);
    }
}
