/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node {
    public Integer x;
    public Integer y;
    public Integer value;
    public Node left, right;
    public Node(Integer x, Integer y, Integer value){
        this.x = x;
        this.y = y;
        this.value = value;
        this.left = this.right = null;
    }
}

 class Solution {
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeInfo){
        int[][] answer = new int[2][nodeInfo.length];
        List<Node> tree = new ArrayList<>();
        Node root = null;
        for(int i =0;i<nodeInfo.length;i++){
            tree.add(new Node(nodeInfo[i][0],nodeInfo[i][1],i+1));
        }
        Collections.sort(tree, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y.equals(o2.y)) return o1.x.compareTo(o2.x);
                if(o1.y > o2.y) return -1;
                return 1;
            }
        });
        for(int i =0;i<nodeInfo.length;i++) root = add(root,tree.get(i));
        preOrder(root);
        postOrder(root);
        for(int i =0;i<nodeInfo.length;i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }

    public Node add(Node node, Node newNode){
        if(node == null) node = newNode;
        else{
            if(node.x > newNode.x) node.left = add(node.left,newNode);
            else node.right = add(node.right,newNode);
        }
        return node;
    }
    public void preOrder(Node node){
        if(node ==null) return;
        pre.add(node.value);
        //System.out.println(answer[0][index]);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
       post.add(node.value);
        //System.out.println(answer[1][index]);
    }
}
 */
/*
import java.util.Arrays;
import java.util.Comparator;

class Node{
    public Integer y;
    public Integer x;
    public Integer index;
    public Node left,right;

    public Node(int y,int x,int index){
        this.y = y;
        this.x = x;
        this.index =index;
        left = right = null;
    }
    public Node(Node newNode){
        y = newNode.y;
        x =newNode.x;
        index =newNode.index;
        left = right = null;
    }
}
class Tree{
    public Node root = null;

    public Node insert(Node node, Node newNode){
        if(node == null){
            node = new Node(newNode);
        }
        else if(node.x < newNode.x){
            node.right = insert(node.right, newNode);
        }
        else {
            node.left = insert(node.left, newNode);
        }
        return node;
    }

    public void preOrder(Node root, int[] pre, int index){
        pre[index] = root.index;
        preOrder(root.left,pre,index++);
    }
}
public class 길찾기 {

    public int[][] solution(int[][] nodeinfo) {
        int nodeLen = nodeinfo.length;
        int[][] answer = new int[2][nodeLen];
        int[] pre = new int[nodeLen];
        int[] post = new int[nodeLen];
        answer[0] = pre;
        answer[1] = post;
        Node[] nodeAry = new Node[nodeLen];

        Arrays.sort(nodeAry, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y.equals(o2.y)){
                    return o1.x.compareTo(o2.x);
                }
                if (o1.y.compareTo(o2.y) > 0) return -1;
                if (o1.y.compareTo(o2.y) < 0) return 1;
                return 0;
            }
        });

        Tree t = new Tree();
        for(Node node : nodeAry) t.root = t.insert(t.root,node);
        t.preOrder(t.root,pre,0);



        return answer;
    }
}
*/