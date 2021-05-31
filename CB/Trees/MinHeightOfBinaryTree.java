//Time complexity: O(n) as visiting all the nodes exactly once.
public class MinHeightOfBinaryTree {
    
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        return minHeight(root);
    }
    int minHeight(TreeNode node)
    {
        if(node.left == null && node.right == null) return 1;
        
        int leftHeight = Integer.MAX_VALUE;
        int rightHeight = Integer.MAX_VALUE;
        if(node.left!=null)
        {
            leftHeight = minHeight(node.left);
        }
        if(node.right!=null)
        {
            rightHeight = minHeight(node.right);
        }
        return Math.min(leftHeight,rightHeight)+1;
    }
}