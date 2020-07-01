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
    public static final int MOD = 1000_000_000;
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
            while (testCases-- > 0) {
                int k = fastReader.nextInt();
                long f1[] = new long[k + 1];
                for (int i = 1; i <= k; i++) {
                    f1[i] = fastReader.nextInt();
                }
                long coeff[] = new long[k + 1];
                for (int i = k; i > 0; i--) {
                    coeff[i] = fastReader.nextInt();
                }
                int n = fastReader.nextInt();                
                long ans = solve(coeff, f1, n);
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    //solves the problem using matrix exponentiation
    private static long solve(long[] coeff, long[] f1, int n) {
        //step1: determine k
        int k = f1.length - 1;

        if (n <= k) {
            return f1[n];
        }

        //step 2: determine transformation matrix
        long trans[][] = getTransformationMatrix(coeff, k);
        
        //exponentiate the matrix
        long tn[][] = matPow(trans, k, n - k);

        //calculate the ans
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += (tn[k][i] * f1[i]);
            ans = ans % MOD;
        }
        return ans;
    }

    //exponentiates a matrix by a power of 'power' returns trans^power
    private static long[][] matPow(long[][] trans, int k, int power) {
        if (power == 1) {
            return trans;
        }
        long smallerAns[][] = matPow(trans, k, power / 2);
        long ans[][] = multiplyMat(smallerAns, smallerAns);
        if ((power & 1) == 0) {
            return ans;
        } else {
            return multiplyMat(trans, ans);
        }
    }

    // multiplies two matrices and returns the resultant matrix
    private static long[][] multiplyMat(long[][] a, long[][] b) {
        int r1 = a[0].length - 1;
        int c1 = a.length - 1;
        int r2 = b[0].length - 1;
        int c2 = b.length - 1;
        long res[][] = new long[r1 + 1][c2 + 1];
        for (int i = 1; i <= r1; i++) {
            for (int j = 1; j <= c2; j++) {
                for (int x = 1; x <= c1; x++) {
                    res[i][j] = (res[i][j] % MOD + (a[i][x] * b[x][j]) % MOD) % MOD;
                }
            }
        }
        return res;
    }

    // returns transformation matrix
    //only this function needs to be modified for other recurrence relations
    private static long[][] getTransformationMatrix(long[] coeff, int k) {
        long trans[][] = new long[k + 1][k + 1];
        for (int i = 1; i < k; i++) {
            trans[i][i + 1] = 1;
            trans[k][i] = coeff[i];
        }
        trans[k][k] = coeff[k];
        return trans;
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