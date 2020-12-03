
/*
Given a grid having some walls in some cells, calculate the no of ways to reach
grid[n-1][m-1] from grid[0][0]

Solution: Normal recursive way but optimised using dp
where dp[i][j] represents no of ways to reach grid[i][j];
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;

class H {
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
    static int MOD=1_000_000_007;
    public static void main(String[] args) throws Exception {
        try {
            // int testCases = fastReader.nextInt();
            int testCases = 1;
            while (testCases-- > 0) {
                int r = fastReader.nextInt();
                int c = fastReader.nextInt();
                String gridStr[] = new String[r];
                char grid[][] = new char[r][c];
                for (int i = 0; i < r; i++) {
                    gridStr[i] = fastReader.next();
                    grid[i] = gridStr[i].toCharArray();
                }
                // int ansBottomUp = solveBottomUp(grid, r, c);
                // System.out.println(ansBottomUp);
                
                int dp[][]=new int[r][c];
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        dp[i][j]=-1;
                    }
                }
                int ansTopDown=solveTopDown(grid,r,c,dp,r-1,c-1);
                System.out.println(ansTopDown);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static int solveTopDown(char[][] grid, int r, int c, int[][] dp,int i,int j) {
        if(i==0 && j==0){
            return 1; //base case
        }
        if(grid[i][j]=='#'){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(i>0){
            ans+=(solveTopDown(grid, r, c, dp, i-1, j)%MOD);
        }
        if(j>0){
            ans+=(solveTopDown(grid, r, c, dp, i, j-1)%MOD);
        }
        dp[i][j]=ans%MOD;
        return dp[i][j];
    }

    private static int solveBottomUp(char[][] grid, int r, int c) {
        int dp[][] = new int[r][c];
        dp[0][0] = 1; // base case
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '#')
                    continue;
                if (i > 0) {
                    dp[i][j] += (dp[i - 1][j]%MOD);
                }
                if (j > 0) {
                    dp[i][j] += (dp[i][j - 1]%MOD);
                }
                dp[i][j]=dp[i][j]%MOD;
            }
        }
        return dp[r - 1][c - 1];
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