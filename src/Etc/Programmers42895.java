package Etc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Programmers42895 {
    static Set<Integer>[] cache  = new Set[9];
    static int N;

    public static int calculate(int first, int second, int count){
        if(count == 0)
            return first + second;
        if(count == 1)
            return first - second;
        if(count == 2)
            return first * second;
        else
            return first / second;
    }

    public static boolean findNumber(int total, int firstSet, int secondSet){
        if(firstSet == total)
            return false;

        Iterator<Integer> iter1 = cache[firstSet].iterator();

        while(iter1.hasNext()) {
            Iterator<Integer> iter2 = cache[secondSet].iterator();
            int value, first, second;
            first = iter1.next();
            while (iter2.hasNext()) {
                second = iter2.next();
                for(int i=0;i<4;i++) {
                    value = calculate(first, second, i);

                    if (value == N)
                        return true;

                    if (value > 0)
                        cache[total].add(value);
                }
            }
        }
        return findNumber(total,firstSet+1,secondSet-1);
    }

    public static int solution(int n,int number){
        N = number;
        int appendN =0 ;
        for(int i =1;i<9;i++){
            appendN += (int)(n*Math.pow(10,i-1));
            cache[i] = new HashSet<>();
            cache[i].add(appendN);
            if(appendN == number)
                return i;
        }
        for(int i =2;i<=8;i++){
            boolean found = findNumber(i,1,i-1);
            if(found)
                return i;
        }
        return -1;
    }

    public static void main(String... args){
        System.out.println(solution(5,12));
    }
}
