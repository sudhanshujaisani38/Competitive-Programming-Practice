/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
import java.util.StringTokenizer;
public class Solution {
    void getString(DirectedGraphNode root, StringBuilder sb)
    {
        sb.append(root.label).append(",");
        for(DirectedGraphNode nbr: root.neighbors)
        {
            getString(nbr,sb);
        }
        sb.append("),");
    }

    public String serialize(ArrayList<DirectedGraphNode> nodes) {
        if(nodes.size() == 0)return "";
        StringBuilder sb = new StringBuilder();
        DirectedGraphNode root = nodes.get(0);
        getString(root,sb);
        System.out.println(sb);
        return sb.toString();
    }
    public UndirectedGraphNode deserialize(String data) {
       if(data.length() == 0) return null;
       StringTokenizer st = new StringTokenizer(data,",");
       UndirectedGraphNode root = new UndirectedGraphNode(Integer.parseInt(st.nextToken()));
       while (addChild(root,st));
       return root;
    }

    //this function tries to add child to root by reading next token, returns true if succesful in adding
    boolean addChild(UndirectedGraphNode root, StringTokenizer st)
    {
        String token = st.nextToken();
        if(token.equals(")"))return false;
        int label = Integer.parseInt(token);
        UndirectedGraphNode node = new UndirectedGraphNode(label);
        root.neighbors.add(node);
        while (addChild(node,st));
        return true;
    }
}