class Main {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 2, 7, 6, 3, 1, 4, 8 };
        int blocks[] = buildBlocks(arr);
        int ans=query(arr,blocks,2,8);
        System.out.println(ans);
        
        update(blocks,arr,2,15);
        ans=query(arr,blocks,2,8);
        System.out.println(ans);
        
    }

    private static void update(int[] blocks, int[] arr, int index, int newVal) {
        int n = arr.length;
        int rootN = (int) Math.sqrt(n);
        int blockNo=index/rootN;
        blocks[blockNo]+=(newVal-arr[index]);
        arr[index]=newVal;
    }

    private static int query(int[] arr, int[] blocks, int l, int r) {
        int ans=0;
        int n = arr.length;
        int rootN = (int) Math.sqrt(n);
        int blockNo=l/rootN;
        while(l<=r && l%rootN!=0){
            ans+=arr[l];
            l++;
        }        
        while(l+rootN<r){
            blockNo++;
            ans+=blocks[blockNo];
            l+=rootN;
        }
        while(l<=r){
            ans+=arr[l];
            l++;
        }
        return ans;
    }

    private static int[] buildBlocks(int[] arr) {
        int n = arr.length;
        int rootN = (int) Math.sqrt(n);
        int noOfBlocks = n / rootN;
        if (n % rootN != 0)
            noOfBlocks++;
        int blocks[] = new int[noOfBlocks];
        int blockNo = -1;
        for (int i = 0; i < n; i++) {
            if (i % rootN == 0) {
                blockNo++;
            }
            blocks[blockNo] += arr[i];
        }
        return blocks;
    }
}