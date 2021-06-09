
import java.util.*;

public class SerializeAndDeserializeBST {

    void appendPreorderString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        appendPreorderString(root.left, sb);
        appendPreorderString(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        appendPreorderString(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer st = new StringTokenizer(data, ",");
        TreeNode root = populateFromString(st);
        return root;
    }

    TreeNode populateFromString(StringTokenizer st) {
        if (!st.hasMoreElements()) {
            return null;
        }
        String str = st.nextToken();
        if (str.length() == 0 || str.equals("#")) {
            return null;
        } else {
            int val = Integer.parseInt(str);
            TreeNode root = new TreeNode(val);
            root.left = populateFromString(st);
            root.right = populateFromString(st);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;