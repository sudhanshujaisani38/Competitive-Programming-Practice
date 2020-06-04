// given dimensions of n matrices, find the minimum number of arithmetic mutltiplication
// operations required to carry out the final matrix
//you will be given an array of n+1 elements a[0] to a[n]
//dimensions of i-th matrix will be represented by a[i]*a[i+1]

class MCM {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 3, 1, 3 };
        int n=arr.length-1;
        int dp[][]=new int[n][n];
        solveBottomUp(arr,n,dp);
        System.out.println("bottom up ans:"+dp[0][n-1]);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------");
        int dp2[][]=new int[n][n];
        int ans=solveTopDown(arr, 0, n-1, dp2);
        System.out.println("top down ans:"+ans);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp2[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void solveBottomUp(int[] arr, int n, int[][] dp) {
        for(int i=1;i<n;i++){
            int l=0,r=i;
            for(l=0;r<n;l++,r++){
                dp[l][r]=Integer.MAX_VALUE;
                for(int pivot=l;pivot<r;pivot++){
                    int ans=dp[l][pivot]+dp[pivot+1][r]+(arr[l]*arr[pivot+1]*arr[r+1]);
                    dp[l][r]=Math.min(dp[l][r],ans);
                }
            }
        }
    }

    private static int solveTopDown(int arr[],int l,int r,int[][]dp){
        if(l==r){
            return 0;
        }
        if(dp[l][r]!=0){
            return dp[l][r];
        }else{
            dp[l][r]=Integer.MAX_VALUE;
            for(int pivot=l;pivot<r;pivot++){
                int ans=solveTopDown(arr, l, pivot, dp)+solveTopDown(arr, pivot+1, r, dp)+(arr[l]*arr[pivot+1]*arr[r+1]);
                dp[l][r]=Math.min(dp[l][r],ans);
            }
            return dp[l][r];
        }
    }
}