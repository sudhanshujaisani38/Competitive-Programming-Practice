import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int noOfNodesInCurr = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty())
        {            
            int size = queue.size();  
            noOfNodesInCurr=0;
            while(size-->0)
            {
                TreeNode node = queue.poll();
                if(node!=null)
                {
                    noOfNodesInCurr++;
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }else
                {
                    list.add(null);
                }
            }
            if(noOfNodesInCurr==0)break;            
        }
        while(list.size()>0 && list.get(list.size()-1)==null)
        {
            list.remove(list.size()-1);
        }
        System.out.println(list);
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str = data.substring(1,data.length()-1);
        if(str.length()==0)return null;
        String[] tokens = str.split(",");
        TreeNode nodes[] = new TreeNode[tokens.length];
        for(int i =0;i<tokens.length;i++)
        {
            String token = tokens[i].trim();
            if(token.equals("null"))
                nodes[i] = null;
            else
                nodes[i] = new TreeNode(Integer.parseInt(token));
        }
        TreeNode root = nodes[0];
        if(root == null)return null;
        int parentIndex = 0, currIndex = 1;       
        int nodesInPrev = 1, nodesInCurr = 0; 
        boolean isLeftChild = true;
        while(currIndex<nodes.length)
        {
            
            nodesInCurr = 2*nodesInPrev;
            nodesInPrev = 0;
            while(nodesInCurr-->0 && currIndex<nodes.length)
            {
                TreeNode parent = null;
                while(parentIndex < nodes.length && (parent = nodes[parentIndex]) == null) parentIndex++;
                TreeNode current = nodes[currIndex];
                if(isLeftChild)
                {
                    parent.left = current; 
                    isLeftChild = false;
                }else
                {
                    parent.right = current;
                    isLeftChild = true;
                    parentIndex++;
                }
                currIndex++;
                if(current != null)
                nodesInPrev++;
            }
        }                    
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));