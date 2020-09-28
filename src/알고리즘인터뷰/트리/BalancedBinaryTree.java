package 알고리즘인터뷰.트리;

public class BalancedBinaryTree {
    boolean checkBalance = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedTree(root);
        return checkBalance;
    }

    public int isBalancedTree(TreeNode node) {
        if(node == null) return 0;
        int left = isBalancedTree(node.left);
        int right = isBalancedTree(node.right);
        if( Math.abs(left - right) > 1) checkBalance = false;
        return Math.max(left,right) + 1;
    }
}
