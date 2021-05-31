import java.util.ArrayList;
import java.util.List;

class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }
    public void postorderTraversal(TreeNode root, List<Integer> list)
    {
        if(root == null) return;
        postorderTraversal(root.left,list);
        postorderTraversal(root.right,list);
        list.add(root.val);
    }
    
}