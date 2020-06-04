//given two strings, find the longest subsequence (not substring) that is present in both
class LongestCommonSubseq{
    public static void main(String[] args) {
        String s1="empty";
        String s2="nematode";
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        solveBottomUp(s1,s2,dp);
        System.out.println("bottom up ans:"+dp[n-1][m-1]);


        
        int dp2[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp2[i][j]=-1;
            }
        }
        int ans=solveTopDown(s1,s2,n,m,dp2);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print(dp2[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("top down ans:"+ans);
    }

    private static int solveTopDown(String s1, String s2, int len1,int len2, int[][] dp) {
        if(len1==0 || len2==0){
            return 0;
        }
        if(dp[len1][len2]!=-1){
            return dp[len1][len2];
        }else{
            int ans;
            if(s1.charAt(len1-1)==s2.charAt(len2-1)){
                ans=1+solveTopDown(s1, s2, len1-1, len2-1, dp);
            }else{
                ans=Math.max(solveTopDown(s1, s2, len1-1, len2, dp), solveTopDown(s1, s2, len1, len2-1, dp));
            }
            return dp[len1][len2]=ans;
        }
    }

    private static void solveBottomUp(String s1, String s2, int dp[][]) {
        int n=s1.length();
        int m=s2.length();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
    }
}