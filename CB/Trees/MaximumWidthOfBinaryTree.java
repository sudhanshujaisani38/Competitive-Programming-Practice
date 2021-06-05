import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        HashMap<TreeNode, Integer> idx = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        idx.put(root, 0);
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = 0, max = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int indexOfNode = idx.get(node);
                if (i == 0)
                    min = indexOfNode;
                if (i == size - 1)
                    max = indexOfNode;
                if (node.left != null) {
                    idx.put(node.left, 2 * indexOfNode + 1);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    idx.put(node.right, 2 * indexOfNode + 2);
                    queue.add(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
    }
}