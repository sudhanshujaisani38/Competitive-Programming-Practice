import java.util.ArrayList;
import java.util.List;

class RightViewOfBinaryTree2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,0,list);
        return list;
    }
    
    void dfs(TreeNode root, int depth, List<Integer> list)
    {
        if(root == null)return;
        
        if(list.size() == depth) list.add(root.val);
        dfs(root.right, depth+1, list);
        dfs(root.left, depth+1, list);
    }
}