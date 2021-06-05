import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            TreeNode node = null;
            Queue<TreeNode> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                node = queue.pollLast();
                currentLevel.add(node.val);
                if (leftToRight) {
                    if (node.left != null) temp.add(node.left);
                    if (node.right != null)temp.add(node.right);
                } else {
                    if (node.right != null) temp.add(node.right);
                    if (node.left != null) temp.add(node.left);
                }
            }
            queue.addAll(temp);
            list.add(currentLevel);
            leftToRight = (!leftToRight);
        }
        return list;
    }
}