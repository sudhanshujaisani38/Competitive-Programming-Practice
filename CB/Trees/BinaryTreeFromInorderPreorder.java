import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeFromInorderPreorder {
    HashMap<Integer,Integer> map = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {        
        for(int idx = 0;idx<inorder.length;idx++)
        {
            map.put(inorder[idx],idx);
        }
        return buildTree(preorder, inorder, 0 , preorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int beg, int end)
    {
        if(beg>end)return null;
        int val = preorder[preorderIndex++];
        TreeNode root = new TreeNode(val);
        int idxOfRoot = map.get(val);
        root.left = buildTree(preorder,inorder,beg,idxOfRoot-1);
        root.right = buildTree(preorder,inorder,idxOfRoot+1,end);  
        return root;
    }
}