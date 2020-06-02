// given a rod of length n,and the prices of rods of length 1 to n
// determine the maximum profit that can be made by cutting the rod
class RodCutting {
    public static void main(String[] args) {
        int n = 4;
        int prices[] = { 0, 2, 3, 2, 5 }; // 1-based indexing
        int dp[] = new int[n + 1];
        int ans = solveTopDown(prices, n, dp);
        System.out.println("Top down ans:"+ans);

        int dp2[]=new int[n+1];
        solveBottomUp(prices, n, dp2);
        System.out.println("Bottom up ans:"+dp2[n]);
    }

    private static int solveTopDown(int[] prices, int totalLen, int[] dp) { 
        if(totalLen==1){
            return dp[1]=prices[1];
        }
        if(dp[totalLen]!=0){
            return dp[totalLen];
        }else{
            int maxProfit=0;
            for(int len=1;len<=totalLen;len++){
                maxProfit=Math.max(maxProfit, prices[len]+solveTopDown(prices, totalLen-len, dp));
            }
            dp[totalLen]=maxProfit;
            return dp[totalLen];
        }
    }

    private static void solveBottomUp(int []prices, int totalLen, int dp[]){
        for(int i=1;i<=totalLen;i++){
            int maxProfit=0;
            for(int len=1;len<=i;len++){
                maxProfit=Math.max(maxProfit, prices[len]+dp[i-len]);
            }
            dp[i]=maxProfit;
        }
    }
}