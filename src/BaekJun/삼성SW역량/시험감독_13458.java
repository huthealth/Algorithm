package BaekJun.삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시험감독_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        String[] inputs2 = br.readLine().split(" ");
        int B = Integer.parseInt(inputs2[0]);
        int C = Integer.parseInt(inputs2[1]);
        int[] rooms = new int[N];
        for(int i = 0 ; i <N ; i++) {
            rooms[i] = Integer.parseInt(inputs[i]) - B;
        }
        int answer = N ;

        for(int i = 0 ; i < N; i++ ) {
            if(rooms[i] < 0 ) continue;
            int secondViewers =rooms[i]/C;
            if( rooms[i]%C != 0 ) secondViewers++;
            answer += secondViewers;
        }
        System.out.println(answer);
    }
}
