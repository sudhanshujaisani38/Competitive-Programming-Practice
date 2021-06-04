class MaxPathSumInBinaryTree 
    {
    public static final int MIN_VALUE = Integer.MIN_VALUE+20000;    
    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return maxPathSum;
    }
    int maxPathSum = MIN_VALUE;

    //returns the max Height sum possible with current node
    public int maxPathSum2(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        
        int maxHeightSum = Math.max( root.val, Math.max(left,right)+root.val); 
        int diameterSum = left+right+root.val;
        int maxSumPossibleWithRoot = Math.max(diameterSum, maxHeightSum);
        
        maxPathSum = Math.max(maxPathSum, maxSumPossibleWithRoot);       
        return maxHeightSum;
    }
}