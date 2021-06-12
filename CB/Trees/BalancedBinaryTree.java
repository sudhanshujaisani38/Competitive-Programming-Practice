
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return maxHeight(root) != -1;
    }

    //returns -1 if either left or right subtrees are not balanced or the tree is itself not balanced
    //other wise returns maxHeight of the tree
    int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || (Math.abs(leftHeight - rightHeight) > 1))
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}