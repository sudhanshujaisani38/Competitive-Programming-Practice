class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return checkBSTNode(root, Long.MIN_VALUE,Long.MAX_VALUE);//taking these values because Int.MAX_VALUE was a valid key.
    }
    
    public boolean checkBSTNode(TreeNode root, long minVal, long maxVal)
    {
        if(root == null)
            return true;
        
        if(root.val<= minVal || root.val >= maxVal)
            return false;
        
        return checkBSTNode(root.right, root.val, maxVal) && checkBSTNode(root.left, minVal,root.val);
    }
}