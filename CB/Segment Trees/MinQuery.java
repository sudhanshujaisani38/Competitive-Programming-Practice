import java.util.Scanner;

//given an array of size n and q queries, each giving two ends of a range, print the minimum element 
//in that range using segment trees
class MinQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int noOfQueries = sc.nextInt();
        int arr[] = new int[n];
        int segtree[] = new int[4 * n + 1]; // for n elements segment tree can use max of 4n+1 elements
        int lazyValue[] = new int[segtree.length];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildSegmentTree(arr, segtree, 0, n - 1, 1);

        for (int i = 0; i < noOfQueries; i++) {
            for (int k = 0; k < segtree.length; k++) {
                System.out.print(segtree[k] + ",");
            }
            System.out.println();
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                l--;
                r--;
                // int ans = query(segtree, l, r, 0, n - 1, 1);
                int ans=queryLazy(segtree,lazyValue,l,r,0,n-1,1);
                System.out.println(ans);
            } else if (queryType == 2) {
                int index = sc.nextInt();
                index--;
                int newValue = sc.nextInt();
                arr[index] = newValue;
                updateNode(index, 1, newValue, segtree, 0, n - 1);
            } else if (queryType == 3) { // updating an entire range
                int l = sc.nextInt();
                int r = sc.nextInt();
                int inc = sc.nextInt();
                l--;
                r--;
                updateRangeLazy(segtree, lazyValue, l, r, inc, 0, n - 1, 1);
                // updateRange(segtree,l,r,inc,0,n-1,1);

            }
        }
    }

    private static int queryLazy(int[] segtree, int[] lazyValue, int l, int r, int ns, int ne, int index) {
        //first resolve the lazy value at this node, then do anything.
        if(lazyValue[index]!=0){
            segtree[index]+=lazyValue[index];
            if(ns!=ne){
                lazyValue[2*index]+=lazyValue[index];
                lazyValue[2*index+1]+=lazyValue[index];
            }
            lazyValue[index]=0;
        }
        if(r<ns || l>ne){
            //no overlap
            return Integer.MAX_VALUE;
        }
        if(ns>=l && ne<=r){
            //complete overlap
            return segtree[index];
        }else{
            //partial overlap
            int mid=(ns+ne)/2;
            int leftAns=queryLazy(segtree, lazyValue, l, r, ns, mid, 2*index);
            int rightAns=queryLazy(segtree, lazyValue, l, r, mid+1, ne, 2*index+1);
            return Math.min(leftAns,rightAns);
        }
    }

    private static void updateRangeLazy(int[] segtree, int[] lazyValue, int l, int r, int inc, int ns, int ne,
            int index) {
        // before going down,resolve the lazy value here & propogate it to left&right if
        // it's not a leaf node
        if (lazyValue[index] != 0) {
            segtree[index] += lazyValue[index];
            if (ns != ne) {
                lazyValue[2 * index] += lazyValue[index];
                lazyValue[2 * index + 1] += lazyValue[index];
            }
            lazyValue[index] = 0;
        }

        if (r < ns || l > ne) {
            return;
        }
        if (ns == ne) {
            segtree[index] += inc;
            return;
        }
        if (ns >= l && ne <= r) {
            // complete overlap - update this node, pass the lazy value(if not leaf) &
            // return
            segtree[index] += inc;
            if (ns != ne) {
                lazyValue[2 * index] += inc;
                lazyValue[2 * index + 1] += inc;
            }
            // return from here only.
            return;
        } else {
            //partial overlap-call on left& right
            int mid = (ns + ne) / 2;
            updateRangeLazy(segtree, lazyValue, l, r, inc, ns, mid, 2 * index);
            updateRangeLazy(segtree, lazyValue, l, r, inc, mid + 1, ne, 2 * index + 1);
            segtree[index]=Math.min(segtree[2*index],segtree[2*index+1]);
        }

    }



    // increments the numbers in range from l to r by inc.
    private static void updateRange(int[] segtree, int l, int r, int inc, int ns, int ne, int index) {

        if (r < ns || l > ne) {
            // no overlap-do nothing
            return;
        }
        if (ns == ne) {
            segtree[index] += inc;
            return;
        } else {
            // partial or complete overlap - call on left & right
            int mid = (ns + ne) / 2;
            updateRange(segtree, l, r, inc, ns, mid, 2 * index);
            updateRange(segtree, l, r, inc, mid + 1, ne, 2 * index + 1);
            segtree[index] = Math.min(segtree[2 * index], segtree[2 * index + 1]);
        }
    }

    // this function tries to answer the query for starting=l and end=r
    // using a segment tree whose root is at index and root represents answer
    // for a range between ns to ne
    private static int query(int[] segtree, int l, int r, int ns, int ne, int index) {
        if (ns >= l && ne <= r) {
            // complete overlap
            return segtree[index];
        } else if (ns > r || ne < l) {
            // no overlap
            return Integer.MAX_VALUE;
        } else {
            int mid = (ns + ne) / 2;
            int leftAns = query(segtree, l, r, ns, mid, 2 * index);
            int rightAns = query(segtree, l, r, mid + 1, ne, 2 * index + 1);
            return Math.min(leftAns, rightAns);
        }
    }

    // given an array, this function tries to fill the elements in range between beg
    // & end of arr
    // in the segment tree's subtree whose root is at treeIndex
    // and returns the value that is placed at root
    private static int buildSegmentTree(int[] arr, int[] segtree, int beg, int end, int treeIndex) {
        if (beg == end) {
            segtree[treeIndex] = arr[beg];
        } else {
            // recursive case
            int mid = (beg + end) / 2;
            int leftPart = buildSegmentTree(arr, segtree, beg, mid, 2 * treeIndex);
            int rightPart = buildSegmentTree(arr, segtree, mid + 1, end, 2 * treeIndex + 1);
            segtree[treeIndex] = Math.min(leftPart, rightPart);
        }
        return segtree[treeIndex];
    }

    private static void updateNode(int arrIndex, int treeIndex, int newValue, int segtree[], int ns, int ne) {
        if (arrIndex == ns && arrIndex == ne) {
            segtree[treeIndex] = newValue;
        } else {
            // rec case

            int mid = (ns + ne) / 2;
            if (arrIndex <= mid) {
                updateNode(arrIndex, 2 * treeIndex, newValue, segtree, ns, mid);
            } else {
                updateNode(arrIndex, 2 * treeIndex + 1, newValue, segtree, mid + 1, ne);
            }
            segtree[treeIndex] = Math.min(segtree[2 * treeIndex], segtree[2 * treeIndex + 1]);
        }
    }
}