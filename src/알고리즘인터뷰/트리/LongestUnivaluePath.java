package 알고리즘인터뷰.트리;



public class LongestUnivaluePath {
    int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        findMaxPath(root, -1);
        return maxPath;
    }
    private int findMaxPath(TreeNode nowNode, int parentVal) {
        if(nowNode == null) return 0;
        int left = findMaxPath(nowNode.left, nowNode.val);
        int right = findMaxPath(nowNode.right, nowNode.val);
        maxPath = Math.max(maxPath, left + right);
        if(nowNode.val != parentVal) return 0;
        return Math.max(left,right) + 1;
    }
}