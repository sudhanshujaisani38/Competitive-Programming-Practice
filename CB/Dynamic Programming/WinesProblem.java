//given prices of n wines, maximize the amount of selling such that
//the price of the wine increases every year by initial year
//i.e if the wine is sold after y years its price becomes price*y
class WinesProblem{
    public static void main(String[] args) {
        int wines[]={2,3,5,1,4};
        int dp[][]=new int[wines.length][wines.length];
        int ans=solveTopDown(wines,0,wines.length-1,dp,0);
        System.out.println("top down ans:"+ans);
        int dp2[][]=new int[wines.length][wines.length];
        solveBottomUp(wines, dp2);
        System.out.println("bottom up ans:"+dp2[0][wines.length-1]);
    }

    private static int solveTopDown(int[] wines,int start,int end, int dp[][],int yearsPassed) {
        if(start==end){
            dp[start][start]=(yearsPassed+1)*wines[start];
            return dp[start][start];
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }else{

            int ans1=(yearsPassed+1)*wines[start]+solveTopDown(wines,start+1,end,dp,yearsPassed+1);
            int ans2=(yearsPassed+1)*wines[end]+solveTopDown(wines,start,end-1,dp,yearsPassed+1);
            dp[start][end]=Math.max(ans1,ans2);
            return dp[start][end];
        }
    }
    private static void  solveBottomUp(int wines[],int dp[][]){
        int n=wines.length;
        for(int i=0;i<n;i++){
            dp[i][i]=wines.length*wines[i];
        }
        for(int i=1;i<=n-1;i++){
            for(int j=0;(j+i)<=n-1;j++){
                int ans1=(wines.length-i)*wines[j+i]+dp[j][j+i-1];
                int ans2=(wines.length-i)*wines[j]+dp[j+1][j+i];
                dp[j][j+i]=Math.max(ans1, ans2);
            }
        }
    }
}