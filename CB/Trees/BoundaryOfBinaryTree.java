import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    List<Integer> boundary = new ArrayList<>();
     boolean isBoundaryAdded =  false;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null)
        {
            boundary.add(root.val);
            isBoundaryAdded = true;
        }
        addLeftBoundaryAndLeaves(root);
        addRightBoundaryInReverse(root.right);
        return boundary;
    }
    void addLeftBoundaryAndLeaves(TreeNode root)
    {        
        if(root == null)return;
        if(root.left == null && root.right == null)
        {
            boundary.add(root.val);
            isBoundaryAdded = true;
        }
        else if(!isBoundaryAdded)
        {
            boundary.add(root.val);            
        }
        addLeftBoundaryAndLeaves(root.left);
        addLeftBoundaryAndLeaves(root.right);
    }

    void addRightBoundaryInReverse(TreeNode root)
    {
        if(root == null || root.left == null && root.right == null) return;
        if(root.right != null)
        {
            addRightBoundaryInReverse(root.right);
        }
        else
        {
            addRightBoundaryInReverse(root.left);
        }
        boundary.add(root.val);
    }
}