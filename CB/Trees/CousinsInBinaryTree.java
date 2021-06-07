import java.util.LinkedList;
import java.util.Queue;

class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return false;
        queue.add(root);
        boolean xFound = false, yFound = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if ((node.left != null && node.left.val == x) || (node.right != null && node.right.val == x)) {
                    xFound = true;
                } else if ((node.left != null && node.left.val == y) || (node.right != null && node.right.val == y)) {
                    yFound = true;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            if (xFound && yFound) {
                return true;
            } else if (xFound || yFound) {
                return false;
            }
        }
        return false;
    }
}