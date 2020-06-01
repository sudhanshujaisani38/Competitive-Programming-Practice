// given a ladder of n steps, and the maximum no of steps you
// can take at once, find the no of ways you can reach to the top
class NKLadder {
    public static void main(String[] args) {
        int dp[] = new int[100];
        int dp2[] = new int[100];
        int dp3[]=new int[100];
        nkBottomUp(4, 3, dp2);
        nkBottomUpOptimized(4, 3, dp3);
        System.out.println(dp3[4]);
        System.out.println(dp2[4]);
        int ans = nkTopDown(4, 3, dp);
        System.out.println(ans);
    }

    private static int nkTopDown(int n, int k, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            int ans = 0;
            for (int i = 1; i <= k; i++) {
                if (n - i >= 0) {
                    ans += (nkTopDown(n - i, k, dp));
                }
            }
            dp[n] = ans;
            return dp[n];
        }
    }

    private static void nkBottomUp(int n, int k, int dp[]) {
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j <= n) {
                    dp[i + j] += dp[i];
                }
            }
        }
    }

    private static void nkBottomUpOptimized(int n, int k, int dp[]) {
        dp[0] = 1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
            if (i - (k + 1) >= 0) {
                dp[i] -= dp[i - (k + 1)];
            }
        }
    }
}