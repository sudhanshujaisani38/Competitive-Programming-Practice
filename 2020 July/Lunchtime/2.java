import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;

class Main {
    public static final int MOD=1000000007;
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
            int testCases = fastReader.nextInt();

            int n = 10000000;
            int dp[] = new int[n + 1];
            printGolomb(n, dp);
            long acc[]=new long[n+1];            
            for(int i=1;i<=n;i++){
                long dd=dp[i];
                acc[i]=((acc[i-1]%MOD)+(((dd%MOD)*(dd%MOD))%MOD))%MOD;
                // System.out.println(acc[i]);
            }

            // SegmentTree tree=new SegmentTree(n);
            // tree.build(dp, 1, n, tree.root);
            // int testCases=1;
            while (testCases-- > 0) {
                int l=fastReader.nextInt();
                int r=fastReader.nextInt();
                System.out.println(acc[r]-acc[l-1]);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void printGolomb(int n, int dp[]) {
        dp[1] = 1;
        // System.out.print(dp[1] + " ");
        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - dp[dp[i - 1]]];
            // System.out.print(dp[i] + " ");
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
    }
}