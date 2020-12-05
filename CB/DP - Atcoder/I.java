
/*
There are n coins & each coin is tossed only once. Find the probability of 
getting more heads than tails.(Probability of getting a head on each coin is given)

Solution: Probability of getting j heads in coins can be calculated as:
        (Probability of getting j-1 heads in i-1 coins AND(multiplied with) Probability of getting head in ith coin)
        OR (add)
        (Probability of getting j heads in i-1 coins AND(multiplied with) Probability of getting tail in ith coin)

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

class I {
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

    public static void main(String[] args) throws Exception {
        try {
            int testCases = 1;
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                double pHead[] = new double[n];
                double pTail[] = new double[n];
                for (int i = 0; i < n; i++) {
                    pHead[i] = fastReader.nextDouble(); // probability of getting a Head in i-th coin
                    pTail[i] = 1 - pHead[i]; // probability of getting a Tail in i-th coin
                }

                // size is (n+1)*(n+1) because no of coins tossed & no of heads will be from 0
                // to n (total n+1 possibilities)
                double dp[][] = new double[n + 1][n + 1]; // dp[i][j] stores probability of getting j heads in i coin
                                                          // tosses
                fillDp(dp, n, pHead, pTail);

                /*
                 * for calculating probability of getting more heads than tails, add
                 * dp[n][(n/2)+1] to dp[n][n] which represent probability of getting more than
                 * n/2 heads in n coin tosses.This is the required ans.
                 * 
                 * note: for zero based indexing it will be dp[n-1][n/2] to dp[n-1][n-1]
                 */
                double ans = 0.0;
                for (int i = (n / 2) + 1; i <= n; i++) {
                    ans += dp[n][i];
                }
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void fillDp(double[][] dp, int n, double[] pHead, double[] pTail) {
        dp[0][0] = 1; // probability of getting 0 heads in 0 coins tossed will be 1.

        /*
         * starting the loop from i=1 because probabilty of getting 1 or more heads in 0
         * coins tossed will be zero anyway
         */
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 0; j < (n + 1); j++) {
                double temp = 0.0;
                /*
                 * logically if you get a head in ith coin, you have to AND it with dp[i-1][j-1]
                 * which stores probability of j-1 heads in i-1 coins tossed
                 * 
                 * if you get a tail you have to AND it with dp[i-1][j] which stores j heads in
                 * i-1 coin tosses.
                 * 
                 * Think logically!
                 */

                temp += (dp[i - 1][j] * pTail[i - 1]); // if you get tail in the ith coin, index wise (i-1)

                if (j > 0) {
                    temp += (dp[i - 1][j - 1] * pHead[i - 1]); // if you get head in the ith coin,index wise (i-1)
                }
                dp[i][j] = temp;
            }
        }
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

        float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}