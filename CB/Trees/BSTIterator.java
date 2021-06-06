import java.util.LinkedList;
import java.util.Queue;

class BSTIterator {
    Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(root);
    }
    
    void inorder(TreeNode root)
    {
        if(root == null)return;
        inorder(root.left);
        queue.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return queue.size()>0;
    }
}
