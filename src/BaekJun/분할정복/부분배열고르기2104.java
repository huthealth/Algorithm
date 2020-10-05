package BaekJun.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 부분배열고르기2104 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i< N ; i++) {
            ary[i] = Integer.parseInt(inputs[i]);
        }



    }
}
