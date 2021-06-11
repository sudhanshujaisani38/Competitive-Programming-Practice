public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSubtreeSymmetric(root.left, root.right);
    }

    boolean isSubtreeSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val == right.val) {
            return isSubtreeSymmetric(left.left, right.right) && isSubtreeSymmetric(left.right, right.left);
        }
        return false;
    }
}
