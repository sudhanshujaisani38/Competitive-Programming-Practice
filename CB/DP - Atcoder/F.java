
/*Given two strings S and T, find the longest subsequence (not substring) that 
exists in both S & T. If there are multiple, find any.
E.g: S = axyb, T = ayxb, then ans= axb or ayb
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

public class F {
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
                String s = fastReader.next();
                String t = fastReader.next();
                int slen = s.length();
                int tlen = t.length();
                int dp[][] = new int[slen + 1][tlen + 1]; //stores the length of longest common subsq. upto ith char of S & jth char of T (upto zeroth char means empty string)
                
                //loop starting from 1 because nothing will be common in an empty subsq.
                for (int i = 1; i <= slen; i++) {
                    for (int j = 1; j <= tlen; j++) {
                        if ((s.charAt(i-1) == t.charAt(j-1))) {
                            dp[i][j] = dp[i-1][j-1] + 1;
                        }else{
                            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                        }
                    }
                }
                
                //now tracing back the subsequence.
                String ans = "";
                int sIndex = slen, tIndex = tlen;
                while (sIndex > 0 && tIndex > 0) {
                    if (dp[sIndex][tIndex] == dp[sIndex-1][tIndex]) {
                        sIndex--;
                    } else if (dp[sIndex][tIndex] == dp[sIndex][tIndex-1]) {
                        tIndex--;
                    } else {
                        sIndex--;
                        tIndex--;
                        ans = s.charAt(sIndex) + ans;
                    }
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