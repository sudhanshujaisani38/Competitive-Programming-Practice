import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DuplicateSubtrees {
    HashMap<String, TreeNode> subTreeMap = new HashMap<>();
    List<TreeNode> list = new ArrayList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        addSubtreeToMap(root, new StringBuilder());

        //now add only populated values (only duplicate will be populated)
        for (String str : subTreeMap.keySet()) {
            TreeNode node = subTreeMap.get(str);
            if (node != null) {
                list.add(node);
            }
        }
        return list;
    }

    void addSubtreeToMap(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        addSubtreeToMap(root.left, sb2);
        sb2.append(",");
        addSubtreeToMap(root.right, sb2);
        sb2.append(",");
        sb2.append(root.val);
        String str = sb2.toString();
        if (!subTreeMap.containsKey(str)) {
            subTreeMap.put(str, null); //if this is first occurance of string, don't populate TreeNode
        } else {
            subTreeMap.put(str, root); //if this string is already there: duplicate found; populate in map
        }
        sb.append(str);
    }
}