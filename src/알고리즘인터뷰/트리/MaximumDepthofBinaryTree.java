package 알고리즘인터뷰.트리;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return findMaxDepth(root, 1);
    }

    private int findMaxDepth(TreeNode node, int now){
        int maxDepth = now;
        if(node.left != null) {
            maxDepth = findMaxDepth(node.left, now+1);
        }
        if(node.right != null) {
            maxDepth = Math.max(maxDepth, findMaxDepth(node.right, now+1));
        }
        return maxDepth;
    }
}
