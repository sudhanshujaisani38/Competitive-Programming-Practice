import java.util.ArrayList;
import java.util.List;
public class ClosestBSTValue {
    List<Integer> list;
    List<Integer> ans;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (k == 0)
            return null;
        list = new ArrayList<>();
        ans = new ArrayList<>();
        inorder(root);
        int index = binarySearch(target);
        int prev = index - 1;
        int next = index + 1;
        ans.add(list.get(index));
        int count = 1;
        while (count != k) {
            if (prev >= 0 && next < list.size()) {
                int val = Math.abs(list.get(prev) - target) < Math.abs(list.get(next) - target) ? list.get(prev--)
                        : list.get(next++);
                ans.add(val);
            } else if (prev < 0) {
                ans.add(list.get(next));
                next++;
            } else if (next >= list.size()) {
                ans.add(list.get(prev));
                prev--;
            }
            count++;
        }
        return ans;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    int binarySearch(double key) {
        int beg = 0, end = list.size() - 1;
        while (beg < end) {
            int mid = (beg + end) / 2;
            if (list.get(mid) == key)
                return mid;
            if (list.get(mid) > key) {
                if (mid == 0)
                    break;
                end = mid - 1;
            } else {
                if (mid == list.size() - 1)
                    break;
                beg = mid + 1;
            }
        }
        if (beg == end)
            return beg;
        int index = Math.abs(list.get(beg) - key) < Math.abs(list.get(end) - key) ? beg : end;
        return index;
    }
}