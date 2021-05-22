
/**
 * Link: https://www.codechef.com/MAY21B/problems/XOREQUAL
 * 
 * For a given N, find the number of ways to choose an integer x from the range [0,2^N−1]
 *  such that x⊕(x+1)=(x+2)⊕(x+3), where ⊕ denotes the bitwise XOR operator.
 *  Since the number of valid x can be large, output it modulo 109+7.
 * 
 * Approach: For a number to satisfy above property, last 2 bits (LSBs) must be either 00 or 10
 * so..for a number of n bits, any combination of (n-2)bits AND (00 or 10) will satisfy that property
 * so effectively, 2^(n-2) ways of selecting (n-2) MSB bits and 2 ways of selecting last 2 bits
 * 2^(n-2) * 2 = 2^(n-1) this is your answer.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    final static int MOD = 1000_000_007;

    static void redirectIO() {
        try {
            final String INPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/input.txt";
            final String OUTPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/output.txt";
            System.setOut(new PrintStream(new File(OUTPUT_FILE)));
            File inputFile = new File(INPUT_FILE);
            inputFile.createNewFile();
            System.setIn(new FileInputStream(inputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        redirectIO();
        FastReader fastReader = new FastReader();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer stringBuffer = new StringBuffer();
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                int noOfBits = fastReader.nextInt();
                System.out.println(fastModExp(2, noOfBits - 1));
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    static long fastModExp(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b = b >> 1;
        }
        return res;
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