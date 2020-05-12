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
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildSegmentTree(arr, segtree, 0, n - 1, 1);
        
        for (int i = 0; i < noOfQueries; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                l--;r--;
                int ans = query(segtree, l, r, 0, n - 1, 1);
                System.out.println(ans);
            }else{
                int index=sc.nextInt();
                index--;
                int newValue=sc.nextInt();
                arr[index]=newValue;
                updateElement(index, 1, newValue, segtree, 0, n-1);
               
            }
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

    private static void updateElement(int arrIndex, int treeIndex, int newValue, int segtree[], int ns, int ne) {
        if (arrIndex == ns && arrIndex == ne) {
            segtree[treeIndex] = newValue;
        } else {
            // rec case
            
            int mid = (ns + ne) / 2;
            if (arrIndex <= mid) {
                updateElement(arrIndex, 2 * treeIndex, newValue, segtree, ns, mid);
            } else {
                updateElement(arrIndex, 2 * treeIndex + 1, newValue, segtree, mid + 1, ne);
            }
            segtree[treeIndex]=Math.min(segtree[2*treeIndex],segtree[2*treeIndex+1]);
        }
    }
}