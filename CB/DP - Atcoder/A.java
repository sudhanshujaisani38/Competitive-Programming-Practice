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
            int testCases=1;
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                long arr[]=new long[n];
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextLong();
                }
                long dp[]=new long[n];
                dp[0]=0;
                dp[1]=Math.abs(arr[1]-arr[0]);
                for(int i=2;i<n;i++){
                    long option1=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
                    long option2=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
                    dp[i]=Math.min(option1,option2);
                }
                System.out.println(dp[n-1]);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
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