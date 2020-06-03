//given an array, find the longest subsequence such that for every i<j, a[i]<=a[j].
class LongestIncSubseq {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 6 };
        int n = arr.length;
        int dp[] = new int[n];
        
        int topDownAns = solveTopDown(arr, n - 1, dp);
        for(int i=0;i<n;i++){
            System.out.print(dp[i]+",");
        }
        System.out.println();
        System.out.println("top down ans:" + topDownAns);
        

        int dp2[] = new int[n];
        solveBottomUp(arr, n, dp2);
        int bottomUpAns = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(dp2[i] + ",");
            bottomUpAns = Math.max(bottomUpAns, dp2[i]);
        }
        System.out.println();
        System.out.println("bottom up ans:" + bottomUpAns);
    }

    private static void solveBottomUp(int[] arr, int n, int[] dp) {
        for (int end = 0; end < n; end++) {
            int maxAns = 1;
            for (int i = 0; i < end; i++) {
                if (arr[i] <= arr[end])
                    maxAns = Math.max(maxAns, 1 + dp[i]);
            }
            dp[end] = maxAns;
        }
    }

    private static int solveTopDown(int[] arr, int n, int[] dp) {
        if (n == 0) {
            return dp[0] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            int maxAns = 1;
            for (int i = 0; i < n; i++) {
                int ans=solveTopDown(arr, i, dp);
                if (arr[i] <= arr[n])
                    maxAns = Math.max(maxAns, 1 + ans);
            }
            dp[n] = maxAns;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}