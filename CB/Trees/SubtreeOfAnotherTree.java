
class SubtreeOfAnotherTree {
    
    //returns true if either the subtree starts from root itself, or is present somewhere in the right or left subtree of root.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        return isExactSubtree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);    
    }
    
    //returns true if subRoot is present as a subtree starting from root itself
    public boolean isExactSubtree(TreeNode root, TreeNode subRoot)
    {
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        return(root.val==subRoot.val && isExactSubtree(root.left,subRoot.left) && isExactSubtree(root.right,subRoot.right));
    }
}