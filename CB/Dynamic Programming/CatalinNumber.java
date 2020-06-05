// given a number n,you hava n nodes with values 1 to n
// you have to tell how many different bsts can be formed with these nodes
class CatalinNumber {
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];
        int ans = solveTopDown(n, dp);
        System.out.println("top down ans:" + ans);
        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i] + ",");
        }
        System.out.println();

        int dp2[] = new int[n + 1];
        solveBottomUp(n, dp2);
        System.out.println("bottom up ans:" + dp2[n]);
    }

    private static void solveBottomUp(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j - 1];
                dp[i] += dp[i - j];
            }
            System.out.print(dp[i] + ",");
        }
        System.out.println();
    }

    private static int solveTopDown(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += solveTopDown(i - 1, dp);
                ans += solveTopDown(n - i, dp);
            }
            return dp[n] = ans;
        }
    }
}