package Etc;

import java.io.*;
class KakaoEn3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        double[] cookieAry = new double[N];
        double lo = 0;
        double hi = 0;
        double mid = 0;
        double answer = 0;
        for(int i =0;i<N;i++){
            cookieAry[i] = Double.parseDouble(br.readLine());
            if(hi < cookieAry[i]) hi = cookieAry[i];
        }

        mid = (lo + hi) / 2;

        while(lo <= hi){
            int count = 0;
            for(int i =0;i<N;i++){
                count += cookieAry[i] / mid;
            }
            if(count < M){
                hi = mid - 0.01;
            }
            else {
                answer = mid;
                lo = mid + 0.01;
            }
            mid = (lo + hi) / 2;
        }
        System.out.printf("%.2f",answer);
    }
}