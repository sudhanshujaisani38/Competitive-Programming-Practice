//given an array, find the number of pairs suvh that i<j && arr[i]>arr[j] using BIT
class BIT{
    public static void main(String[] args) {
        int arr[]={5,2,1,4,3};
        int biTree[]=buildBiTree(arr);       
        for(int i=0;i<=arr.length;i++){
            System.out.print(biTree[i]+",");
        } 
        System.out.println();
        // System.out.println(query(biTree,5));
    }

    private static int query(int[] biTree, int i) {
        int ans=0;
        while(i>0){
            ans+=biTree[i];
            i-=(i&-i);
        }
        return ans;
    }

    private static int[] buildBiTree(int[] arr) {
        int biTree[]=new int[arr.length+1];
        int ans=0;
        for(int i=arr.length;i>=1;i--){
            ans+=(query(biTree, arr[i-1]-1));
            update(arr[i-1],1,biTree);
        }
        System.out.println(ans);
        return biTree;
    }

    private static void update(int index, int increment, int[] biTree) {
        while(index<biTree.length){
            biTree[index]+=increment;
            index+=(index&(-index));
        }
    }
}