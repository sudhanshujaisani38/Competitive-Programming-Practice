public class GraphValidTree {
    int parentOf[];

    public boolean validTree(int n, int[][] edges) {
        if ((n - 1) != edges.length)
            return false;
            
        parentOf = new int[n];
        for (int i = 0; i < n; i++) {
            parentOf[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (getSuperParentOf(edges[i][0]) == getSuperParentOf(edges[i][1])) {
                return false;
            } else {
                performUnion(edges[i][0], edges[i][1]);
            }
        }
        return true;
    }

    int getSuperParentOf(int x) {
        if (x == parentOf[x]) {
            return x;
        } else {
            parentOf[x] = getSuperParentOf(parentOf[x]);
            return parentOf[x];
        }
    }

    void performUnion(int x, int y) {
        int px = getSuperParentOf(x);
        int py = getSuperParentOf(y);
        if (px != py) {
            parentOf[px] = py;
        }
    }
}