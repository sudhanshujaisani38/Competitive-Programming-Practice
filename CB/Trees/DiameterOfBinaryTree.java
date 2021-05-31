class DiameterOfBinaryTree {
    class Pair
    {
        int diameter;
        int height;
        public Pair(int d, int h)
        {
            diameter = d;
            height = h;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        Pair p = diameterAndHeight(root,0);
        return p.diameter;
    }
    
    Pair diameterAndHeight(TreeNode root, int height)
    {
        if(root == null) return new Pair(0,0);
        Pair leftPair = diameterAndHeight(root.left,height+1);
        Pair rightPair = diameterAndHeight(root.right,height+1);
        int currDiameter = leftPair.height + rightPair.height;
        int max = Math.max(leftPair.diameter,rightPair.diameter);
        max = Math.max(max, currDiameter);
        return new Pair(max, Math.max(leftPair.height,rightPair.height)+1);
    }
}