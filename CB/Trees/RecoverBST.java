
class RecoverBST {
    TreeNode first = null, second = null, third = null, prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        if (third != null) {
            int temp = first.val;
            first.val = third.val;
            third.val = temp;
        } else {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                third = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}