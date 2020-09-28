package 알고리즘인터뷰.트리;


class TreeNode {
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
public class MergeTwoBinaryTrees{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t3 = new TreeNode(0,null,null);
        if(t1 == null && t2 == null) return null;
        if(t1 != null) midOrder(t1,t3);
        if(t2 != null) midOrder(t2,t3);

        return t3;
    }
    public void midOrder(TreeNode t, TreeNode nt){
        nt.val += t.val;
        if(t.left != null) {
            if(nt.left == null) nt.left = new TreeNode(0,null,null);
            midOrder(t.left, nt.left);
        }
        if(t.right != null) {
            if(nt.right == null) nt.right = new TreeNode(0,null,null);
            midOrder(t.right,nt.right);
        }
    }
}
