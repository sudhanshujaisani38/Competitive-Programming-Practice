
class inorderSuccessorBST {
    static TreeNode succ = null; // this is an important thing

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null) {
            if (root.val == p.val) {
                if (root.right != null) {
                    TreeNode temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    succ = temp;
                }
                break;
            } else if (root.val > p.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}