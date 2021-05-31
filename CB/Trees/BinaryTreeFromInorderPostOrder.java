import java.util.HashMap;

class BinaryTreeFromInorderPostOrder {
    HashMap<Integer,Integer> map = new HashMap<>();
    int postorderIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;
        for(int idx = 0;idx<postorder.length;idx++)
        {
            map.put(inorder[idx],idx);
        }
        return buildTree(inorder,postorder,0,postorder.length-1);
    }
     public TreeNode buildTree(int[] inorder, int[] postorder, int beg, int end)
     {
         if(beg>end || postorderIndex <0)return null;
         int val = postorder[postorderIndex--];
         TreeNode root = new TreeNode(val);
         int idx = map.get(val);
         root.right = buildTree(inorder,postorder,idx+1,end);
         root.left = buildTree(inorder,postorder,beg,idx-1);         
         return root;
     }
}