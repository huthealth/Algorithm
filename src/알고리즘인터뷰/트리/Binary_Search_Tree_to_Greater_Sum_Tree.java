package 알고리즘인터뷰.트리;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Binary_Search_Tree_to_Greater_Sum_Tree {
    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode bstToGst(TreeNode root) {
        postOrder(root);
        map.put(list.get(0),list.get(0));
        for(int i = 1; i< list.size(); i++) {
            int nowVal = list.get(i);
            map.put(nowVal,nowVal + map.get(list.get(i-1)));
        }
        makeGT(root);
        return root;
    }

    private void postOrder(TreeNode node) {
        if(node == null) return;
        postOrder(node.right);
        list.add(node.val);
        postOrder(node.left);
    }

    private void makeGT(TreeNode node) {
        if(node == null) return;
        node.val = map.get(node.val);
        makeGT(node.left);
        makeGT(node.right);
    }
}
