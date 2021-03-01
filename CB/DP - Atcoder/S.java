/*
 * Find the number of integers between 1 and K (inclusive) satisfying the
 * following condition, modulo 10 9 + 7 :
 * 
 * The sum of the digits in base ten is a multiple of D .
 * 
 * 1 ≤ K < 10^10000 
 * 1 ≤ D ≤ 100
 */

import java.io.*;
import java.util.*;

class S {
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
    static final int MOD = 1000_000_007;

    static long dp[][][];

    public static void main(String[] args) throws Exception {
        String k = fastReader.next();
        int num = fastReader.nextInt();
        dp = new long[k.length()][num][2];
        for (int i = 0; i < k.length(); i++) {
            for (int j = 0; j < num; j++) {
                dp[i][j][0] = dp[i][j][1] = -1;
            }
        }
        long ans = (MOD + solve(k, num, 0, 0, true) - 1) % MOD;
        System.out.println(ans);
    }

    private static long solve(String k, int num, int index, int afterFixMod, boolean isTightBound) {
        int isTight = isTightBound ? 1 : 0;
        if (dp[index][afterFixMod][isTight] != -1) {
            return dp[index][afterFixMod][isTight];
        }
        int upperBound = isTightBound ? k.charAt(index) - '0' : 9;
        long ans = 0;
        if (index == k.length() - 1) {
            for (int x = 0; x <= upperBound; x++) {
                if (x % num == afterFixMod) {
                    ans++;
                }
            }
            return ans;
        }

        for (int x = 0; x <= upperBound; x++) {
            if (isTightBound && (x == upperBound))
                ans = (ans % MOD + solve(k, num, index + 1, (num + afterFixMod - x % num) % num, true) % MOD) % MOD;
            else
                ans = (ans % MOD + solve(k, num, index + 1, (num + afterFixMod - x % num) % num, false) % MOD) % MOD;
        }
        return dp[index][afterFixMod][isTight] = ans;
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