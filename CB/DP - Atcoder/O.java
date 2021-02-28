/*
 * given n women and n men and their compatibility with each other, find the
 * number of ways they can be paired in n pairs constraint: n<=21
 * 
 * How to solve:
 * Let X represent a bitmask such that i-th bit of X is 1 represent that i-th women is
 * still available for pairing and dp[i][X] represent the number of ways men from i to N can be paired 
 * with women in set X which is being represented using a bitmask here 
 * 
 * base case: when no men & women are left in both sets, we have found a way, so return 1
 *            when no men & atleast 1 women is left, we don't have a way to complete the pairing, so return 0
 
 * recursive case: if ith men and jth women are pairable, 
 * pair them and try to pair men from i+1 to n and women in X-{j}
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

class O {
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
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try {
            int n = fastReader.nextInt();
            int comp[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    comp[i][j] = fastReader.nextInt();
                }
            }
            int initialBitMask = (1 << n) - 1;
            int dp[][] = new int[n][1 << n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = -1;
                }
            }
            int ans = solve(n, comp, 0, initialBitMask, dp);
            System.out.println(ans);
        } catch (Exception e) {
            return;
        }
    }

    /**
     * 
     * given total no of men/women, their compatibilities, the starting index from
     * where we have to start pairing men and a bitmask representing which women are
     * available for pairing, this function gives the number of ways you can pair
     * men from index i to (n-1) with women available in set represented by bitmask
     */
    private static int solve(int n, int[][] comp, int i, int womenBitMask, int[][] dp) {
        if (i == n) {
            // no men left for pairing
            if (womenBitMask == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[i][womenBitMask] != -1) {
            return dp[i][womenBitMask];
        }
        int ans = 0;

        for (int j = 0; j < n; j++) {
            boolean isCompatible = (comp[i][j] == 1);
            boolean isAvailable = (((1 << j) & womenBitMask) != 0);
            if (isCompatible && isAvailable) {
                ans = (ans + solve(n, comp, i + 1, womenBitMask ^ ((1 << j)), dp)) % MOD;
            } else {
            }
        }

        return dp[i][womenBitMask] = ans;
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