
class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val < low || root.val > high)
            root = deleteNode(root, root.val);
        return root;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        TreeNode temp = root.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        root.val = temp.val;
        root.right = deleteNode(root.right, temp.val);
        return root;
    }
}