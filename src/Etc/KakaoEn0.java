package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KakaoEn0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String input1 = br.readLine();
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int x1 = Integer.parseInt(input1[0]);
        int x2 = Integer.parseInt(input1[1]);
        int initSpeed = Integer.parseInt(input2[0]);
        int accel = Integer.parseInt(input2[1]);
        int d = Integer.parseInt(input2[2]);
        int dist = Math.abs(x1 - x2);
        int finalSpeed = initSpeed + accel * dist;
        if(finalSpeed >= d) System.out.println(1);
        else System.out.println(0);

    }
}
