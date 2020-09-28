package 알고리즘인터뷰.트리;

import java.util.HashMap;
import java.util.Map;



public class DiameterofBinaryTree {

        int maxDepth = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null) return 0;
            findMaxDepth(root);
            return maxDepth;
        }

    private int findMaxDepth(TreeNode node) {
            if(node == null) return 0;

            int left = findMaxDepth(node.left);
            int right = findMaxDepth(node.right);
            maxDepth = Math.max(maxDepth,left+right);

            return Math.max(left,right) + 1;



    }


}

