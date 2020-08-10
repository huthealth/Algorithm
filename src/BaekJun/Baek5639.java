package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Baek5639 {
    private static class Tree {
        private static class TreeNode {
            TreeNode leftChild,rightChild;
            Integer value;
            TreeNode(int value) {
                this.value = value;
                leftChild = rightChild = null;
            }
        }
        TreeNode root;
        Tree(){
            root = null;
        }
        TreeNode insert(TreeNode root, Integer value) {
            if(root == null) {
                root = new TreeNode(value);
            }
            else if(root.value > value) {
                root.leftChild = insert(root.leftChild, value);
            }
            else {
                root.rightChild = insert(root.rightChild, value);
            }
            return root;
        }

        void postOrder(TreeNode node) {
            if(node.leftChild != null) postOrder(node.leftChild);
            if(node.rightChild != null) postOrder(node.rightChild);
            System.out.println(node.value);
        }
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Tree tree = new Tree();
        while( (input = br.readLine()) != null) {
            Integer value = Integer.parseInt(input);
            tree.root = tree.insert(tree.root,value);
        }
        tree.postOrder(tree.root);
    }
}
