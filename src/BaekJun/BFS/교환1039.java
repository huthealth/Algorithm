package BaekJun.BFS;

import java.awt.image.BandedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 교환1039 {
    private static class CalNum{
        int num;
        int[] ary;
        int count ;
        CalNum(int n, int[] a, int c){
            num= n;
            ary = a;
            count = c;
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int  len = getLen(N);
        int answer = 0;
        int maxCount = 0;
        CalNum c = getCalNum(N,len);
        Set<Integer> set = new HashSet<>();
        Queue<CalNum> q = new LinkedList<>();
        q.offer(c);
        set.add(c.num);
        while(!q.isEmpty()){
            CalNum nowC = q.poll();
            if(nowC.num > answer) answer = nowC.num;
            maxCount =Math.max(maxCount,nowC.count);

            if(nowC.count == K) continue;
            for(int i =0; i < c.ary.length-1; i++) {
                for(int j = i+1 ; j< c.ary.length; j++) {
                    int[] newAry = new int[c.ary.length];
                    for(int k=0;k<newAry.length;k++) {
                        newAry[k] = c.ary[k];
                    }
                    newAry[i] = c.ary[j];
                    newAry[j] = c.ary[i];
                    if(newAry[0] == 0) continue;
                    int newNum = getNum(newAry);
                    if(set.contains(newNum)) continue;
                    set.add(newNum);
                    q.add(new CalNum(newNum,newAry,nowC.count+1));
                }
            }
        }
        if(maxCount < K ) System.out.println(-1);
        else System.out.println(answer);
    }

    private static int getNum(int[] ary) {
        int len = ary.length;
        int token = (int)Math.pow(10,len-1);
        int ret = 0;
        for(int i = 0 ; i<len; i++) {
            ret += ary[i] * token;
            token /= 10;

        }
        return ret;
    }

    private static CalNum getCalNum(int n, int len) {
        int ret = n;
        int[] ary = new int[len];
        int token = (int)Math.pow(10,len-1);
        for(int i = 0 ; i< len; i++) {
            int num = n / token;
            ary[i] = num;
            n -= num * token;
            token /= 10;
        }
        return new CalNum(ret,ary,0);
    }

    private static int getLen(int n) {
        int token = 1000000;
        int cnt = 7;
        int ret = 1;
        for(int i = 0 ; i<cnt; i++) {
            if(n / token != 0) {
                ret = cnt-i;
                break;
            }
            token /= 10;
        }
        return ret;
    }
}
