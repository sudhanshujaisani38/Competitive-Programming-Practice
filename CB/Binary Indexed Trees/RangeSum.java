//given an array, find the sum of the numbers in a given range, also updating of an index is required
//all this in logn per query.
class BIT {
    public static void main(String[] args) {
        int arr[] = { 3, 7, 8, 4, 2, 8, 1, 9, 23, 12, 67, 43, 32 };
        int biTree[] = buildBiTree(arr);
        for(int i=0;i<biTree.length;i++){
            System.out.print(biTree[i]+",");
        }
        System.out.println();
        int ans=query(biTree,8)-query(biTree,3);
        System.out.println(query(biTree,8)+"-"+query(biTree,3)+"="+ans);
        arr[3]=14;
        update(4, 10, biTree);
        ans=query(biTree,8)-query(biTree,3);
        System.out.println(query(biTree,8)+"-"+query(biTree,3)+"="+ans);
    }

    


    private static int query(int[] biTree, int i) {
        int ans=0;
        while(i>0){
            ans+=biTree[i];
            i-=(i&(-i));
        }
        return ans;
    }

    // this thing can be done while taking input too.
    private static int[] buildBiTree(int[] arr) {
        int n = arr.length;
        int biTree[] = new int[n + 1]; // one-based indexing required
        for (int i = 1; i <= n; i++) {
            update(i, arr[i-1], biTree);      
        }
        return biTree;
    }

    //there was an update at ith position in original array,
    //this function adjusts the BIT according to that.
    private static void update(int index, int increment, int[] biTree) {
        while (index < biTree.length) {
            biTree[index]+=increment;
            index+=(index&(-index));
        }
    }
}