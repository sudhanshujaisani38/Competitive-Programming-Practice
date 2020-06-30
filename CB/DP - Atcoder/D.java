import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
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
            // int testCases = fastReader.nextInt();
            int testCases = 1;
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int k = fastReader.nextInt();
                int weight[] = new int[n + 1];
                long value[] = new long[n + 1];
                for (int i = 1; i <= n; i++) {
                    weight[i] = fastReader.nextInt();
                    value[i] = fastReader.nextInt();
                }
                long dp[][] = new long[n + 1][k + 1];
                for (long arr[] : dp) {
                    Arrays.fill(arr, -1);
                }
                long ans = solve(n, k, weight, value, dp);
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static long solve(int n, int k, int[] weight, long[] value, long dp[][]) {
        // System.out.println("n=" + n + ",k=" + k);
        if (n == 1) {
            if (k >= weight[n])
                return value[n];
            return 0;
        }
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        long ans1 = solve(n - 1, k, weight, value, dp);
        long ans2 = 0;
        if (k - weight[n] >= 0)
            ans2 = value[n] + solve(n - 1, k - weight[n], weight, value, dp);
        // System.out.println("solving for:n=" + n + ",k=" + k + " ans=" + Math.max(ans1, ans2));
        return dp[n][k] = Math.max(ans1, ans2);
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