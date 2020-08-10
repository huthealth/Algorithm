package BaekJun;//A → B

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek16953 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int answer = 0;
        boolean fail = false;
        while( B > 0) {
            if (B == A) break;
            String bString = Integer.toString(B);
            if (bString.endsWith("1") && bString.length()>1) {
                B = Integer.parseInt(bString.substring(0, bString.length() - 1));
                answer++;
            } else if (B % 2 == 0) {
                B /= 2;
                answer++;
            } else {
                fail = true;
                break;
            }
        }
        if(fail) answer = -1;
        else answer++;
        System.out.println(answer);
    }
}
