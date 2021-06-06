import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class VerticalOrderTraversalOfBinaryTree {
    class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> verticalLists = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<Pair<Integer, Integer>> level = new LinkedList<>();

        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<TreeNode, Integer> nodeToHD = queue.poll();
                TreeNode node = nodeToHD.getKey();
                int horizontalDist = nodeToHD.getValue();
                level.add(new Pair<>(node.val, horizontalDist));
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, horizontalDist - 1));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, horizontalDist + 1));
                }
            }
            Comparator<Pair<Integer, Integer>> comp = (first, sec) -> first.getKey() - sec.getKey();
            Collections.sort(level, comp);
            for (Pair<Integer, Integer> pair : level) {
                ArrayList<Integer> list = verticalLists.getOrDefault(pair.getValue(), new ArrayList<Integer>());
                list.add(pair.getKey());
                verticalLists.put(pair.getValue(), list);
            }
            level.clear();
        }
        for (Integer idx : verticalLists.keySet()) {
            ans.add(verticalLists.get(idx));
        }

        return ans;
    }
}