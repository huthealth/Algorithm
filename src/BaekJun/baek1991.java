package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class baek1991 {
    static class TreeNode {
        String left;
        String right;
        TreeNode(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }
    static Map<String, TreeNode> tree= new HashMap<>();
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);

        for(int i = 0;i<N;i++) {
            String parent,left,right;
            String[] str = br.readLine().split(" ");
            parent = str[0];
            left = str[1];
            right = str[2];
            tree.put(parent, new TreeNode(left,right));
        }
        preOrder("A");
        System.out.println();
        midOrder("A");
        System.out.println();
        postOrder("A");
        System.out.println();

    }
    static void preOrder(String node) {
        System.out.print(node);
        TreeNode parent = tree.get(node);
        if(!parent.left.equals(".")) preOrder(parent.left);
        if(!parent.right.equals(".")) preOrder(parent.right);
    }
    static void postOrder(String node) {
        TreeNode parent = tree.get(node);
        if(!parent.left.equals(".")) postOrder(parent.left);
        if(!parent.right.equals(".")) postOrder(parent.right);
        System.out.print(node);
    }
    static void midOrder(String node) {
        TreeNode parent = tree.get(node);
        if(!parent.left.equals(".")) midOrder(parent.left);
        System.out.print(node);
        if(!parent.right.equals(".")) midOrder(parent.right);
    }
}
