package Etc;

import java.io.*;

public class T2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] firstLine = input.split(" ");
        input = br.readLine();
        String[] secondLine = input.split(" ");
        int N = Integer.parseInt( firstLine[0]);
        int M = Integer.parseInt( firstLine[1]);
        int D = Integer.parseInt( firstLine[2]);
        int answer = 1;
        int[] calender = new int[N];
        for(int i = 0 ; i<M;i++) {
            calender[Integer.parseInt(secondLine[i])] = -1;
        }
        int pointer = 0;
        int count = 0;
        while(pointer < N) {
            pointer++;
            count++;
            if(count == D) {
                count = 0;
                boolean isFail = true;
                for(int i  = 0;i<D;i++) {
                    if(calender[pointer] == -1) pointer--;
                    else {
                        answer++;
                        isFail = false;
                        break;
                    }
                }
                if(isFail) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

}
