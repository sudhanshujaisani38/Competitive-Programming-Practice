class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {        
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums,int beg,int end) {
        if(beg>end) return null;
        if(beg == end) return new TreeNode(nums[beg]);
        
        int mid = (beg+end)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, beg, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}