class MinimumTo1{
    static int dpBotmUp[]=new int[20];
    public static void main(String[] args) {
        int dp[]=new int[20];
        initializeBottomUpDP(20);
        System.out.println("5:"+solveMinTo1TopDown(5, dp)+" "+dpBotmUp[5]);
        System.out.println("9:"+solveMinTo1TopDown(9, dp)+" "+dpBotmUp[9]);
        System.out.println("10:"+solveMinTo1TopDown(10, dp)+" "+dpBotmUp[10]);
        System.out.println("11:"+solveMinTo1TopDown(11, dp)+" "+dpBotmUp[11]);
        System.out.println("12:"+solveMinTo1TopDown(12, dp)+" "+dpBotmUp[12]);
        System.out.println("13:"+solveMinTo1TopDown(13, dp)+" "+dpBotmUp[13]);
        System.out.println("19:"+solveMinTo1TopDown(19, dp)+" "+dpBotmUp[19]);
    }

    static int solveMinTo1TopDown(int n,int dp[]){
        // System.out.println("solving for:"+n);
        if(n==1){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }else{
            int ans;
            int a=solveMinTo1TopDown(n-1, dp);
            int b=Integer.MAX_VALUE;
            int c=Integer.MAX_VALUE;
            if(n%2==0){
                b=solveMinTo1TopDown(n/2, dp);
            }
            if(n%3==0){
                c=solveMinTo1TopDown(n/3, dp);
            }
            ans=Math.min(a,Math.min(b,c));
            dp[n]=ans+1;
            return dp[n];
        }        
    }

    private static void initializeBottomUpDP(int n) {
        int min;
        for(int i=2;i<n;i++){
            min=dpBotmUp[i-1];
            if(i%2==0){
                min=Math.min(min,dpBotmUp[i/2]);
            }
            if(i%3==0){
                min=Math.min(min,dpBotmUp[i/3]);
            }
            dpBotmUp[i]=min+1;
        }
    }
}