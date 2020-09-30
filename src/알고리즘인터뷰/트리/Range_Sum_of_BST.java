package 알고리즘인터뷰.트리;



public class Range_Sum_of_BST {
    int total = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        addVal(root,L,R);
        int ret = addVal2(root,L,R);
        return ret;
    }

    private void addVal(TreeNode node,int L, int R) {
        if(node == null) return;
        if(node.val < L){
            addVal(node.right,L,R);
        }
        else if(node.val > R ) {
            addVal(node.left,L,R);
        }
        else{
            total +=node.val;
            addVal(node.left,L,R);
            addVal(node.right,L,R);
        }
    }

    private int addVal2(TreeNode node, int L, int R){
        if(node == null) return 0;
        int ret = 0;
        if(node.val < L){
            ret +=addVal2(node.right,L,R);
        }
        else if(node.val > R ) {
            ret +=addVal2(node.left,L,R);
        }
        else{
            ret +=node.val;
            ret +=addVal2(node.left,L,R);
            ret +=addVal2(node.right,L,R);
        }
        return ret;
    }
}
