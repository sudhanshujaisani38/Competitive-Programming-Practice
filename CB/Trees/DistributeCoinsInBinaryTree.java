
class DistributeCoinsInBinaryTree {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        getNoOfExcessCoins(root);
        return moves;
    }

    int getNoOfExcessCoins(TreeNode node) {
        if (node == null)
            return 0;
        int left = getNoOfExcessCoins(node.left);
        int right = getNoOfExcessCoins(node.right);
        moves += (Math.abs(left) + Math.abs(right));
        return (node.val - 1) + left + right;
    }
}