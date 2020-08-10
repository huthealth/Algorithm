package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek2263 {
    static List<Integer> preOrderAry;
    static int[] postOrderAry;
    static int[] inOrderAry;
    static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        preOrderAry = new ArrayList<>();
        postOrderAry = new int[N];
        inOrderAry = new int[N];

        String[] str = br.readLine().split(" ");
        for(int i = 0; i<N;i++) {
            inOrderAry[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        for(int i = 0; i<N;i++) {
            postOrderAry[i] = Integer.parseInt(str[i]);
        }
        makePreOrder(0,N-1,0,N-1);
        for(Integer node : preOrderAry) {
            System.out.print(node+ " ");
        }
        System.out.println();
    }

    static void makePreOrder(int inStart, int inEnd,int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return;
        int root = postOrderAry[postEnd];
        preOrderAry.add(root);
        int leftEnd = inStart -1,rightStart = inEnd +1;
        for(int i = inStart;i<=inEnd;i++) {
            if(inOrderAry[i] == root) {
                leftEnd = i-1;
                rightStart = i+1;
                break;
            }
        }
        makePreOrder(inStart,leftEnd,postStart,postStart + (leftEnd-inStart));
        makePreOrder(rightStart,inEnd,postStart+(leftEnd-inStart+1),postEnd-1);
    }
}
