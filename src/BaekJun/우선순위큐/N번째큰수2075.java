package BaekJun.우선순위큐;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N번째큰수2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers=new  int[N*N];
        int cnt =0;
        for(int i = 0; i< N; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j = 0 ; j<N; j++) {
                numbers[cnt++] = Integer.parseInt(inputs[j]);
            }
        }
        Arrays.sort(numbers);
        System.out.println(numbers[N*N-N]);
    }
}
