import java.util.Stack;

class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for(int i =0;i<nums.length;i++)
        {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < curr.val)
            {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty())
            {
                stack.peek().right = curr;
            }else
            {
                root = curr;
            }
            stack.push(curr);
        }
        return root;
    }        
}