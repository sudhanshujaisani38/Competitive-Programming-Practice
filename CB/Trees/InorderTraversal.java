import java.util.ArrayList;
import java.util.List;

class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();

        inorderTraversal(root,list);
        return list;
    }
    public void inorderTraversal(TreeNode root,List<Integer> inorderList) {
         if(root == null) return;
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right, inorderList);
    }
}