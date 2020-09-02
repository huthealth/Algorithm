package BaekJun.유니온파인드;

import com.sun.org.apache.xerces.internal.xni.parser.XMLErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 공항10775 {

    static int[] ary;
    static int[] size;


    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        ary = new int[G+1];
        size = new int[G+1];
        int[] planes = new int[P];
        for(int i = 0 ; i< P; i++) planes[i] = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<G+1; i++) {
            ary[i] = i;
            size[i] = 1;
        }
        int answer = 0;
        for(int i = 0 ; i<P; i++) {
            int g = planes[i];
            int nextPort = find(g);
            if(nextPort == 0) break;
            merge(g,nextPort-1);
            answer++;
        }

        System.out.println(answer);

    }

    static int find(int p) {
        int root = ary[p];
        while(root != ary[root]) root = ary[root];
        while(root != ary[p]) {
            int next = ary[p];
            ary[p] = root;
            p = next;
        }
        return root;
    }

    static void merge(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return ;


        if(rootP < rootQ) {
            ary[rootQ] = rootP;
        }
        else{
            ary[rootP] = rootQ;
        }
        /*
        if(size[rootP] > size[rootQ]) {
            size[rootP] += size[rootQ];
            ary[rootQ] = rootP;
        }
        else {
            size[rootQ] += size[rootP];
            ary[rootP] = rootQ;
        }

         */
    }
}
