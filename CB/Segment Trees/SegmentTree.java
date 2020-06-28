public class SegmentTree {
    int size;
    int tree[];
    SegNode root;

    public SegmentTree(int n) {
        size = n;
        root = new SegNode();
    }

    public static void main(String[] args) {
        SegmentTree tree=new SegmentTree(6);
        int arr[]={1,3,2,-5,6,4};
        tree.build(arr, 0, arr.length-1, tree.root);
        tree.print(tree.root, true);System.out.println();
        tree.rangeUpdateLazy(3, 4, 10, tree.root);
        tree.print(tree.root, true);System.out.println();
        System.out.println(tree.queryLazy(4, 4, tree.root));
        tree.print(tree.root, true);System.out.println();
    }

    public void build(int arr[], int start, int end, SegNode node) {
        if (start == end) {
            node.start = start;
            node.end = start;
            node.data = arr[start];
            return;
        }
        node.left = new SegNode();
        node.right = new SegNode();
        int mid = (start + end) / 2;
        build(arr, start, mid, node.left);
        build(arr, mid + 1, end, node.right);
        node.data = Math.min(node.left.data, node.right.data);
        node.start = node.left.start;
        node.end = node.right.end;
    }

    public int query(int start, int end, SegNode node) {
        if (node.start > end || node.end < start) {
            return Integer.MAX_VALUE;
        }
        if (node.start >= start && node.end <= end) {
            return node.data;
        }
        int leftAns = query(start, end, node.left);
        int rightAns = query(start, end, node.right);
        return Math.min(leftAns, rightAns);
    }

    public void rangeUpdate(int start, int end, int increment, SegNode node) {
        if (node.start > end || node.end < start) {
            return;
        }
        if (node.isLeaf()) {
            node.data += increment;
            return;
        }
        rangeUpdate(start, end, increment, node.left);
        rangeUpdate(start, end, increment, node.right);
        node.data = Math.min(node.left.data, node.right.data);
    }

    public void pointUpdate(int index, int increment, SegNode node) {
        if (node.start == index && node.end == index) {
            node.data += increment;
            return;
        }
        if (index < node.start || index > node.end) {
            return;
        }
        int mid = (node.start + node.end) / 2;
        if (index > mid) {
            pointUpdate(index, increment, node.right);
        } else {
            pointUpdate(index, increment, node.left);
        }
        node.data = Math.min(node.left.data, node.right.data);
    }

    public void rangeUpdateLazy(int start, int end, int increment, SegNode node) {
        node.resolveLazyValue();
        if (start > node.end || end < node.start) {
            return;
        }
        if (node.isLeaf()) {
            node.data += increment;
            return;
        }
        if (node.start >= start && node.end <= end) {
            node.data += increment;
            if (node.start != node.end) {
                node.left.lazyValue += increment;
                node.right.lazyValue += increment;
            }
            return;
        }
        int mid = (node.start + node.end) / 2;
        if (start > mid) {
            rangeUpdateLazy(start, end, increment, node.right);
        } else {
            rangeUpdateLazy(start, end, increment, node.left);
        }
        node.data=Math.min(node.left.data,node.right.data);
    }

    public int queryLazy(int start,int end,SegNode node){
        node.resolveLazyValue();
        if(node.start>end || node.end<start){
            return Integer.MAX_VALUE;
        }
        if(node.start>=start && node.end<=end){
            return node.data;
        }
        int ans1=queryLazy(start, end, node.left);
        int ans2=queryLazy(start, end, node.right);
        return Math.min(ans1,ans2);
    }

    static class SegNode {
        int data;
        SegNode left;
        SegNode right;
        int start;
        int end;
        int lazyValue;

        void resolveLazyValue(){
            if(this.lazyValue!=0){
                this.data+=this.lazyValue;
                if(this.start!=this.end){
                    this.left.lazyValue+=this.lazyValue;
                    this.right.lazyValue+=this.lazyValue;                
                }
                this.lazyValue=0;
            }
        }
        boolean isLeaf(){
            return (start==end);
        }
    }

    //prints the preorder traversal of segment tree, also prints lazy value of each node
    //if wantLazy is passed true;
    public void print(SegNode node,boolean wantLazy) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        if(wantLazy){
            System.out.print("("+node.lazyValue+")");
        }
        System.out.print(",");
        print(node.left,wantLazy);
        print(node.right,wantLazy);
    }    
}