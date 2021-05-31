
//Time complexity: O(n) as every node will be visited exactly once
public class MaxHeightOfBinaryTree {   
    public int maxDepth(TreeNode root) {
        return maxHeight(root);
    }
    int maxHeight(TreeNode root)
    {
        if(root==null)return 0;
        return Math.max(maxHeight(root.left),maxHeight(root.right))+1;
    }
}