import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null); //null acts as a delimiter between 2 levels
		List<Integer> currentLevel = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (curr == null) {
				ans.add(currentLevel);
				if (!queue.isEmpty()) {
					currentLevel = new ArrayList<>();
					queue.add(null);
				}
			} else {
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
				currentLevel.add(curr.val);
			}
		}
		return ans;
	}
}