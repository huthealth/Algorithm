package Etc;/*
import java.util.HashSet;
import java.util.Set;

public class Kakao3 {
    public Set<String> gemSet = new HashSet<>();
    public String[] ary;
    public int N;
    public int totalGem;
    public final int INF =9999999;
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        N = gems.length;
        ary = gems;
        for(String gem : gems) gemSet.add(gem);
        totalGem = gemSet.size();
        int start = 0;
        int end = 0;
        int len = INF;
        for(int i =0;i<gems.length;i++){
            Set<String> s = new HashSet<>();
            int ans = countGem(i,s);
            if(len > ans - i){
                start = i;
                end = ans;
                len = ans - i;
            }
        }
        answer[0] = start+1;
        answer[1] = end+1;
        return answer;
    }
    public int countGem(int now, Set<String> s){
        if(now == N-1 ) {
            s.add(ary[now]);
            if(s.size() ==totalGem) return now;
            return INF;
        }
        s.add(ary[now]);
        if(s.size() == totalGem) return now;
        return countGem(now+1,s);
    }
    public static void main(String... args){
        Kakao3 k = new Kakao3();
        String[] s =	{"AA","AB", "AB", "AC", "AA", "AC"};
        int[] answer = k.solution(s);
        System.out.println(answer[0] + " "+answer[1]);

        //System.out.println(k.solution(s));
    }
}
*/

//투 포인터 사용

import java.util.HashMap;
import java.util.Map;

public class Kakao3 {

    public int[] solution(String[] gems) {
        Map<String,Integer> bucket = new HashMap<>();
        for (int i = 0; i < gems.length; i++) bucket.put(gems[i],0);
        int gemTotal = bucket.size();

        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;

        int lo = 0;
        int hi = 0;
        int nowLen = 0;
        int nowLeft = 0;
        int nowRight = 0;
        int count = 0;

        while (true) {
            if (count >= gemTotal) {
                int nowGem = bucket.get(gems[lo]);
                bucket.put(gems[lo], --nowGem);
                if(nowGem ==0) count--;
                lo++;
            }
            else if (hi == gems.length) {
                break;
            }
            else {
                int nowGem = bucket.get(gems[hi]);
                bucket.put(gems[hi], ++nowGem);
                if(nowGem == 1) count++;
                hi++;
            }

            if (count == gemTotal) {
                nowLeft = lo;
                nowRight = hi;
                nowLen = nowRight - nowLeft;
                if (nowLen < len) {
                    len = nowLen;
                    left = nowLeft + 1 ;
                    right = nowRight;
                }
            }
        }

        answer[0] = left ;
        answer[1] = right;

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static void main(String... args) {
        Kakao3 k = new Kakao3();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        k.solution(gems3);
        k.solution(gems4);
    }
}

/*
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Kakao3 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int N = gems.length;
        Set<String> totalGemSet = new HashSet<>();
        for(int i = 0; i<N; i++) {
            totalGemSet.add(gems[i]);
        }
        int totalGem = totalGemSet.size();
        int lo = 0;
        int hi = 0;
        int ansLo = -1;
        int ansHi = -1;
        int ansLen = Integer.MAX_VALUE;
        Set<String> nowGemSet = new HashSet<>();
        Map<String,Integer> nowGemMap = new HashMap<>();
        while(lo <= hi) {
            if(nowGemSet.size() == totalGem){
                if(hi - lo < ansLen){
                    ansLo = lo;
                    ansHi = hi;
                    ansLen = hi - lo;
                }
                if(nowGemMap.get(gems[lo]) == 1){
                    nowGemSet.remove(gems[lo]);
                    nowGemMap.put(gems[lo],0);
                }
                else {
                    nowGemMap.put(gems[lo],nowGemMap.get(gems[lo]) - 1);
                }
                lo++;
            }
            else {
                if( hi == N) break;
                if(nowGemSet.contains(gems[hi])){
                    nowGemMap.put(gems[hi],nowGemMap.get(gems[hi]) + 1);
                }
                else {
                    nowGemSet.add(gems[hi]);
                    nowGemMap.put(gems[hi], 1);
                }
                hi++;
            }
        }
        //int i = nowGemMap.get("abc");
        //System.out.println(i);
        answer[0] = ansLo + 1;
        answer[1] = ansHi;
        System.out.println(answer[0]+ " "+ answer[1]);
        return answer;
    }
    public static void main(String... args) {
        Kakao3 k = new Kakao3();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        k.solution(gems);
        k.solution(gems2);
        k.solution(gems3);
        k.solution(gems4);
    }
}

 */