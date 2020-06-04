import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Mixtures {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            String ip[] = br.readLine().split(" ");
            int arr[] = new int[n];
            int dp[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(ip[i]);
            }
            // int ans = solveTopDown(arr, 0, n - 1, dp);
            solveBottomUp(arr, dp);
            System.out.println(dp[0][n-1]);
        }
    }

    private static int solveTopDown(int[] arr, int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int minAns=Integer.MAX_VALUE;
            for(int pivot=i;pivot<j;pivot++){
                int ans=solveTopDown(arr, i, pivot, dp)+solveTopDown(arr, pivot+1, j, dp)+sum(arr,i,pivot)*sum(arr,pivot+1,j);
                minAns=Math.min(minAns,ans);
            }
            return dp[i][j]=minAns;
        }
    }
    private static void solveBottomUp(int []arr, int dp[][]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        for(int i=1;i<n;i++){
            int l=0,r=i;
            for(l=0;r<n;l++,r++){
                int minAns=Integer.MAX_VALUE;
                for(int pivot=l;pivot<r;pivot++){
                    int ans=dp[l][pivot]+dp[pivot+1][r]+sum(arr,l,pivot)*sum(arr,pivot+1,r);
                    minAns=Math.min(minAns,ans);
                }
                dp[l][r]=minAns;
            }
        }
    }

    private static int sum(int[] arr, int i, int j) {
        int sum=0;
        for(int index=i;index<=j;index++){
            sum+=arr[index];
            sum%=100;
        }
        return sum;
    }
}