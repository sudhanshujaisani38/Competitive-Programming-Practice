//given an array of elements, print the subarrray that gives the maximum sum and the sum
class MaximumSubarray{
    public static void main(String[] args) {
        int arr[]={-3,2,-5,-1,6,3,-2,7,-5,2};
        solve(arr);
    }

    private static void solve(int[] arr) {
        int n=arr.length;
        int maxSoFar=0;
        int dp[]=new int[n];
        int startIndex=0,endIndex=-1,tempStart=0;
        dp[0]=Math.max(0,arr[0]);
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+arr[i];
            if(dp[i]<0){
                dp[i]=0;
                tempStart=i+1;
            }
            if(dp[i]>maxSoFar){
                startIndex=tempStart;
                endIndex=i;
                maxSoFar=dp[i];
            }
        };
        System.out.println(maxSoFar);
        for(int i=startIndex;i<=endIndex;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();

    }
}