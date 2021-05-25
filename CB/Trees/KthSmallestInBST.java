/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int nodesVisited = 0;
        while (curr != null) {
            if (curr.left == null) {
                nodesVisited++;
                if (nodesVisited == k) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;

                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    nodesVisited++;
                    if (nodesVisited == k)
                        return curr.val;
                    curr = curr.right;
                }
            }
        }
        return 0;
    }
}