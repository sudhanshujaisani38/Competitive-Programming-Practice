import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeLCA1 {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,stack1);
        if(stack1.contains(q))return q;
        dfs(root,q,stack2);
        if(stack2.contains(p))return p;        

        while(stack1.size()>stack2.size())
        {
            stack1.pop();
        }        
        while(stack2.size()>stack1.size())
        {
            stack2.pop();
        }
        while(stack1.peek()!=stack2.peek())
        {
            stack1.pop();
            stack2.pop();
        }
        return stack1.peek();
    }
    
    boolean dfs(TreeNode node, TreeNode key, Stack<TreeNode> stack)
    {
        if(node == null)return false;
        if(node.val == key.val)
        {
            return true;
        }
        stack.push(node);
        if(dfs(node.left,key,stack) || dfs(node.right,key,stack)) 
        {
            return true;            
        }        
        else
        {
            stack.pop();
            return false;
        }
    }
}