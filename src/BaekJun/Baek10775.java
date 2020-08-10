package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10775 {
    static int[] gate;
    static int[] landed;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        gate = new int[G+1];
        for(int i =1;i<=G;i++) gate[i] = i;
        landed = new int[P];
        for(int i = 0; i<P;i++) {
            landed[i] = Integer.parseInt(br.readLine());
        }
        for(int i =0;i<P;i++) {
            int gateNum = landed[i];
            if(gateNum == gate[gateNum]) {
                answer++;
                unify(gateNum-1,gateNum);
            }
            else {
                int next = find(gateNum);
                if(next == 0) {
                    System.out.println(answer);
                    return;
                }
                answer++;
                unify(next-1,next); //gateNum 대신 next 해도 됨?
            }
        }
        System.out.println(answer);
    }
    private static int find(int p) {
        int root = p;
        while(root != gate[root]) root = gate[root];
        while(root != p) {
            int next = gate[p];
            gate[p] = root;
            p = next;
        }
        return root;
    }
    private static boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }
    private static void unify(int p, int q) {
        if(isConnected(p,q)) return;
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot < qRoot) gate[qRoot] = pRoot;
        else gate[pRoot] = qRoot;
    }
}
