import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class MaxHeightOfNaryTree {
    public int maxDepth(Node root) {
        return maxHeight(root);        
    }
    
    int maxHeight(Node root)
    {
        if(root==null) return 0;
        int maxHeight = 0;
        for(Node n:root.children)
        {
            maxHeight = Math.max(maxHeight,maxHeight(n));
        }
        return maxHeight+1;
    }
}