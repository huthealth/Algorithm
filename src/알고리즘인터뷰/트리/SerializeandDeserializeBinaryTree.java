package 알고리즘인터뷰.트리;

import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class SerializeandDeserializeBinaryTree {
/*
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> sb = new ArrayList<>();
    String[] dataAry;
    int[] h = new int[1001];
    public String serialize(TreeNode root) {
        if(root == null) return "";
        sb.add(Integer.toString( root.val));


        makeString(root,0);
        for(int i = 0 ; i<sb.size();i++) System.out.print(sb.get(i)+" ");
        System.out.println();
        for(int i = sb.size()-1; i >=0 ; i--) {
            if(sb.get(i).equals("null")) sb.remove(i);
            else break;
        }


        //for(int i = 0 ; i<sb.size();i++) System.out.print(sb.get(i)+" ");

        StringBuilder ret = new StringBuilder();
        for(int i = 0 ; i< sb.size(); i++) {
            ret.append(sb.get(i));
            ret.append(",");
        }

        ret.deleteCharAt(ret.length()-1);


        return ret.toString();
    }

    private void makeString(TreeNode node, int parent) {

        if(node.left ==null) {
            sb.add(parent+1,"null");

        }
        else {
            sb.add(parent+1,Integer.toString(node.left.val));
        }

        if(node.right == null) {
            sb.add(parent+2,"null");

        }
        else {
            sb.add(parent+2,Integer.toString(node.right.val));
        }
        if(node.left != null) makeString(node.left, sb.size()-1);
        if(node.right != null) makeString(node.right, sb.size()-1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        if(!data.contains(",")) return new TreeNode(Integer.parseInt(data));
        dataAry = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataAry[0]));
        makeTree(root,0,0);
        return root;
    }

    private void makeTree(TreeNode node, int now, int height) {

        int left = now*2 + 1;
        int right = now*2 + 2;

        if(h[height] > 0) {
            h[height]--;
            left -= height*2;
        }
        if(h[height]> 0) {
            h[height]--;
            right -= height*2;
        }
        if(left <= dataAry.length - 1) {
            if(!dataAry[left].equals( "null")) {
                node.left = new TreeNode(Integer.parseInt(dataAry[left]));
                makeTree(node.left, left, height+1);
            }
            else {
                h[height+1]++;
            }
        }
        if(right <= dataAry.length - 1) {
            if(!dataAry[right].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(dataAry[right]));
                makeTree(node.right, right,height+1);
            }
            else{
                h[height+1]++;
            }
        }
    }

 */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        makeString(root,sb);
        return sb.toString();
    }

    private void makeString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        makeString(node.left,sb);
        makeString(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>(Arrays.asList( data.split(",")));
        TreeNode root = makeTree(queue);

        return root;
    }

    private TreeNode makeTree(Queue<String> queue ) {
        if(queue.isEmpty()) return null;
        String val = queue.poll();
        if(val.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left  = makeTree(queue);
        node.right = makeTree(queue);
        return node;
    }


    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
         //TreeNode root = s.deserialize("1,2,3,null,null,4,5");
       //reeNode root = s.deserialize("1,2,3,null,null,4,5,6,7");
       //tring str = s.serialize(root);

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
         ans.add(10);
        System.out.println(ans.get(0));

    }
}
