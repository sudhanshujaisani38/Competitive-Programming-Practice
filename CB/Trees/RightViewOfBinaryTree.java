import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode node = queue.poll();
                if(i==size-1)
                {
                    list.add(node.val);
                }
                if(node.left !=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
        }
        return list;
            
    }
}