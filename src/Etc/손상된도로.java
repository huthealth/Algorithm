package Etc;

import java.util.LinkedList;
import java.util.Queue;
/*
public class 손상된도로 {

    public int solution(String road, int n) {

        int canRepair = n;
        int maxLen = 0;
        Queue<Integer> repairIndex = new LinkedList<>();
        for(int i =0; i<road.length();i++){
            if(road.charAt(i) == '0') repairIndex.add(i);
        }

        int lo = 0;
        int hi = 0;
        int nowLen = 0;

        while(true) {
            if(canRepair < 0) {
                lo = repairIndex.poll() + 1;
                canRepair++;
            }
            else if( hi == road.length()) {
                nowLen = hi - lo;
                if(maxLen < nowLen) maxLen = nowLen;
                break;
            }
            else {
                if(road.charAt(hi) =='0') canRepair--;
                hi++;
            }
            if(canRepair == -1) {
                nowLen = hi - lo -1;
                if(maxLen < nowLen) maxLen = nowLen;
            }
        }

        return maxLen;
    }

    public static void main(String... args){
        손상된도로 son = new 손상된도로();
        String s1 = "111011110011111011111100011111";
        String s2 = "00110";
        int n1= 3, n2=5;
        System.out.println(son.solution(s1,n1));
        System.out.println(son.solution(s2,n2));
    }
}

*/

class 손상된도로 {
    public int solution(String road, int n){
        int answer = 0;
        int lo = 0;
        int hi = 0;
        Queue<Integer> brokenRoad = new LinkedList<>();
        for(int i = 0; i<road.length();i++){
            if(road.charAt(i) == '0') brokenRoad.add(i);
        }

        int ansLen = 0;
        int repairNum = 0;
        while(lo <= hi) {
            if( repairNum == n+1 ) {
                if (hi - lo > ansLen) ansLen = hi - 1 - lo;
                repairNum--;
                lo = brokenRoad.poll() + 1;
            }
            else if( hi == road.length()) {
                if(hi - lo > ansLen) ansLen = hi - lo;
                break;
            }
            else {
                if(road.charAt(hi) == '0') repairNum++;
                hi++;
            }
        }

        return ansLen;
    }
    public static void main(String... args){
        손상된도로 son = new 손상된도로();
        String s1 = "111011110011111011111100011111";
        String s2 = "00110";
        int n1= 3, n2=5;
        System.out.println(son.solution(s1,n1));
        System.out.println(son.solution(s2,n2));
    }
}