class CoinChange {
    static int coin[]={1,7,10};
    static int maxAmount=200;
    static int dpBotmUp[]=new int[maxAmount];

    public static void main(String[] args) {
        initializeBottomUpDP();
        System.out.println(dpBotmUp[15]);
        int dp[]=new int[maxAmount];
        System.out.println(solveCoinChange(15, dp));
        
    }

    private static int solveCoinChange(int amount,int dp[]){
        if(amount==0){
            return 0;
        }
        if(dp[amount]!=0){
            return dp[amount];
        }else{
            int minVal=Integer.MAX_VALUE;
            for(int coinValue:coin){
                if(amount-coinValue>=0){
                    minVal=Math.min(minVal,solveCoinChange(amount-coinValue, dp));
                }
            }
            dp[amount]=minVal+1;
            return dp[amount];
        }
    }

    private static void initializeBottomUpDP() {
        for(int i=1; i<maxAmount;i++){
            int minVal=Integer.MAX_VALUE;
            for(int coinValue:coin){
                if(i-coinValue>=0){
                    minVal=Math.min(minVal,dpBotmUp[i-coinValue]);
                }
            }
            dpBotmUp[i]=minVal+1;
        }
    }
}