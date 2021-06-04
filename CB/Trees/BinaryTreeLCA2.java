class BinaryTreeLCA2 {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    //returns true if atleast one of p or q is found in a subtree starting with root
    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int nodesFound = 0;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean mid = (root == p || root == q);
        if (left)
            nodesFound++;
        if (right)
            nodesFound++;
        if (mid)
            nodesFound++;
        if (nodesFound == 2) {
            this.ans = root;
        }
        return mid || left || right;

    }
}