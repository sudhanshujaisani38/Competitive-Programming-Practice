import java.util.ArrayList;
import java.util.List;

class NodesAtDistKFromTarget {
    TreeNode target = null;
    int k = 0;
    ArrayList<Integer> list;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        list = new ArrayList<>();
        this.target = target;
        this.k = k;
        distFromTarget(root);
        return list;
    }
    
    public int distFromTarget(TreeNode root)
    {
        if(root==null)return -1;
        
        if(root == target)
        {
            addToList(root,k);
            return 1;
        }
        else
        {
            int leftDist = distFromTarget(root.left);
            int rightDist = distFromTarget(root.right);
            if(leftDist!=-1)
            {
                if(leftDist == k)
                {
                    list.add(root.val);
                }
                else if(leftDist < k)
                {
                    addToList(root.right, k-leftDist-1);
                }
                return leftDist+1;
            }
            
            if(rightDist!=-1)
            {
                if(rightDist == k)
                {
                    list.add(root.val);
                }
                else if(rightDist < k)
                {
                    addToList(root.left, k-rightDist-1);
                }
                return rightDist+1;
            }
            return -1;
        }
    }
    
    public void addToList(TreeNode root, int kk)
    {
        if(root == null) return;
        if(kk==0)
        {
            System.out.println("adding:"+root.val);
            list.add(root.val);
        }else
        {
            addToList(root.left,kk-1);
            addToList(root.right,kk-1);
        }        
    }
    
}