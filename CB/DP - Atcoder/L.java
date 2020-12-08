import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;

class L {
    static {
        try {
            System.setOut(new PrintStream(new File("output.txt")));
            new File("input.txt").createNewFile();
            System.setIn(new FileInputStream(new File("input.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();
    final static int TURN_TARO = 0;
    final static int TURN_JIRO = 1;

    public static void main(String[] args) throws Exception {
        try {
            int testCases = 1;
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                long arr[]=new long[n];
                long totalSum=0l;
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextLong();
                    totalSum+=arr[i];
                }
                long dp[][][]=new long[n][n][2];
                /*
                dp[i][j][turn] stores the answer for if the array had elements a[i] to a[j]
                and turn denotes who has the first turn;
                */
                long taroScore=solve(arr,0,n-1,TURN_TARO,dp);
                long jiroScore=totalSum-taroScore;
                System.out.println(taroScore-jiroScore);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static long solve(long[] arr, int i, int j, int turn, long[][][] dp) {
        if(i>j){
            return 0;
        }
        if(dp[i][j][turn]!=0){
            return dp[i][j][turn];
        }
        if(turn==TURN_TARO){
            //if it's taro's turn, play such that it's score gets maximized
            dp[i][j][turn]=Math.max(arr[i]+solve(arr,i+1,j,TURN_JIRO,dp), arr[j]+solve(arr,i,j-1,TURN_JIRO,dp));
        }else{
            //if it's jiro's turn, play such that taro's score gets maximized again
            dp[i][j][turn]=Math.min(solve(arr,i+1,j,TURN_TARO,dp), solve(arr,i,j-1,TURN_TARO,dp));
        }
        return dp[i][j][turn];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}