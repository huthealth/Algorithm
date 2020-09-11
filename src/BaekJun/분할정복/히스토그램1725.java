package BaekJun.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 히스토그램1725 {
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt( br.readLine() );
        heights = new int[N];
        for(int i =0 ; i < N ;i++) heights[i] = Integer.parseInt(br.readLine());
        int answer = dac(0,N-1);
        System.out.println(answer);
    }

    private static int dac(int left, int right) {
        if(left == right) return heights[left];
        int mid = (left+right) /2;
        int ret = Math.max(dac(left,mid),dac(mid+1,right));
        int lo = mid;
        int hi = mid+1;
        int nowH = Math.min(heights[lo],heights[hi]);
        ret = Math.max(ret, nowH * 2);
        while(left < lo || hi < right) {
            if(hi < right && (lo == left || heights[hi+1] > heights[lo-1])) {
                hi++;
                nowH = Math.min(nowH,heights[hi]);
            }
            else {
                lo--;
                nowH = Math.min(nowH,heights[lo]);
            }
            ret = Math.max(ret, (hi - lo +1) * nowH);
        }
        return ret;
    }

}
