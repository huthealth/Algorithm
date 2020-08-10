package Etc;

import java.util.Arrays;
import java.util.Scanner;

public class JLIS {
    public static int[][] cache;
    public static int[] aryLeft;
    public static int[] aryRight;
    public static int leftLen;
    public static int rightLen;

    public static int getMaxLen(int left, int right) {

        if(cache[left][right] != -1) return cache[left][right];

        if(aryLeft[left] != aryRight[right])cache[left][right] = 2;
        else cache[left][right] = 1;

        int max = Math.max(aryLeft[left], aryRight[right]);
        for(int next = left+1; next<leftLen;next++){
            if(max < aryLeft[next]) {
                cache[left][right] = Math.max(cache[left][right], getMaxLen(next,right) + 1);
            }
        }
        for(int next = right+1; next<rightLen;next++){
            if(max < aryRight[next]) {
                cache[left][right] = Math.max(cache[left][right], getMaxLen(left,next) + 1);
            }
        }

        return cache[left][right];
    }

    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for(int i =0; i<C;i++){
            leftLen = sc.nextInt();
            rightLen = sc.nextInt();
            aryLeft = new int[leftLen];
            aryRight = new int[rightLen];
            int maxLen = Math.max(leftLen,rightLen);
            cache = new int[maxLen][maxLen];

            for(int j = 0; j< maxLen;j++) {
                Arrays.fill(cache[j], -1);
            }
            for( int j =0; j<leftLen;j++) {
                aryLeft[j] = sc.nextInt();
            }
            for(int j=0; j<rightLen;j++){
                aryRight[j] = sc.nextInt();
            }

            int answer = 0;
            int temp = 0;
            for(int  j=0;j<leftLen;j++){
                for(int k=0;k<rightLen;k++){
                    if(aryLeft[j] != aryRight[k]) temp = 2;
                    else temp = 1;
                    //temp = 2;
                    temp += getMaxLen(j,k);
                    answer = Math.max(answer,temp);
                }
            }
            System.out.println(answer);
        }
    }
}
