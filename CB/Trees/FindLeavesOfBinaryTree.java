import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        addToCorrectLevel(root);
        return list;
    }

    public int addToCorrectLevel(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = addToCorrectLevel(root.left);
        int rightHeight = addToCorrectLevel(root.right);
        int heightOfRoot = Math.max(leftHeight, rightHeight) + 1;
        while (list.size() < heightOfRoot + 1) {
            list.add(new ArrayList<>());
        }
        list.get(heightOfRoot).add(root.val);
        return heightOfRoot;
    }
}