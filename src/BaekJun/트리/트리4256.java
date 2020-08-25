package BaekJun.트리;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리4256 {
    private static class Node{
         Node left;
         Node right;
         int value;
        Node(int v){
            value = v;
            left = null;
            right = null;
        }
        void postOrder(Node n){
            if(n.left != null) postOrder(n.left);
            if(n.right != null) postOrder(n.right);
            System.out.print(n.value+" ");
        }

    }
    static int[] preOrder;
    static int[] inOrder;
    static int N;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt( br.readLine());

        for(int t = 0 ; t<T; t++) {
            N = Integer.parseInt( br.readLine());
            preOrder = new int[N];
            inOrder = new int[N];
            String[] inputs = br.readLine().split(" ");
            String[] inputs2 = br.readLine().split(" ");
            for(int i = 0 ; i<N; i++) {
                preOrder[i] = Integer.parseInt(inputs[i]);
                inOrder[i] = Integer.parseInt(inputs2[i]);
            }

            Node root = new Node(-1);
            makeTree(root,0,N-1,0,-1);
            root.postOrder(root);
            System.out.println();
        }
    }

    private static int makeTree(Node root, int start, int end, int now, int leftRight) {
        if(start == end) {
            if(leftRight ==0) root.left = new Node(inOrder[start]);
            else root.right = new Node(inOrder[start]);
            return now+1;
        }
        int rootIndex = -1;
        for(int i = start; i<= end; i++) {
            if(preOrder[now] == inOrder[i]){
                rootIndex = i;
                break;
            }
        }

        if(now == 0) root.value = inOrder[rootIndex];
        else if( leftRight == 0) {
            root.left = new Node(inOrder[rootIndex]);
            root = root.left;
        }
        else {
            root.right = new Node(inOrder[rootIndex]);
            root = root.right;
        }

        int next = now+1;
        if(start <= rootIndex-1) next = makeTree(root,start,rootIndex-1,now+1,0);
        if(rootIndex+1<=end) next = makeTree(root,rootIndex+1,end,next,1);
        return next;
    }

}
