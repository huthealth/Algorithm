package 알고리즘인터뷰.트리;


import java.util.function.Consumer;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    int pIndex = 0;
    int[] po;
    int[] io;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null ) return null;
        po = preorder;
        io = inorder;
        TreeNode root = makeTree(0,preorder.length-1);
        return root;
    }

    public TreeNode makeTree(int start , int end){
        System.out.println(start + " "+end);
        if(start> end) return null;
        if(start == end) return new TreeNode(po[pIndex++]);
        TreeNode node = new TreeNode(po[pIndex]);
        int mid = -1;
        for(int i = 0; i <= end ; i++) {
            if(po[pIndex] == io[i]) {
                mid = i;
                pIndex++;
                break;
            }
        }
        node.left = makeTree(start,mid-1);
        node.right = makeTree(mid+1,end);
        return node;
    }

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal t = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        int[] a = {1,2,3};
        int[] b = {3,2,1};
        t.buildTree(a,b);
    }
}