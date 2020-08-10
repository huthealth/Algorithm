package Etc;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 쿼드트리뒤집기 {
    public String flipImage(String s, int index){
        String[] image = new String[4];
        String ret;
        int now = index;
        for(int i =0; i<4; i++){
            if(s.charAt(now) == 'b' || s.charAt(now) == 'w' ) image[i] = Character.toString(s.charAt(now));
            else image[i] = flipImage(s, now+1);
            now += image[i].length();
        }

        ret = "x" + image[2] + image[3] + image[0] + image[1];
        return ret;
    }
    public static void main(String... args) {
/*
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        쿼드트리뒤집기 a = new 쿼드트리뒤집기();

        for(int i =0;i<C;i++){
            String s = sc.next();
            if(s.length() == 1) System.out.println("정답은 : " + s);
            else System.out.println("정답은 : " + a.flipImage(s,1)+" 입니다.");
        }
        */

    }
}
