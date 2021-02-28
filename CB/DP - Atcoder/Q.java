
/*
 * There are N flowers arranged in a row. For each i ( 1 ≤ i ≤ N ), the height
 * and the beauty of the i -th flower from the left is h[i] and a[i] ,
 * respectively. Here, h 1 , h 2 , … , h N are all distinct.
 * 
 * Taro is pulling out some flowers so that the following condition is met:
 * 
 * The heights of the remaining flowers are monotonically increasing from left
 * to right. Find the maximum possible sum of the beauties of the remaining
 * flowers.
 * 
 * N<2*10^5 (therefore N*N complexity is not allowed)
 * 
 * How to solve:
 * We need to maintain a data structure in which we store only those flowers where
 * if i>j && dp[i]>dp[j] then h[i] must be greater than h[j]
 * because if a flower of greater height and lower beauty is encountered while
 * moving from left to right, it's useless.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(final String[] args) throws Exception {
        try {
            final int n = fastReader.nextInt();
            final long h[] = new long[n];
            final long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                h[i] = fastReader.nextInt();
            }
            for (int i = 0; i < n; i++) {
                a[i] = fastReader.nextInt();
            }
            final long ans = solve(n, h, a);
            System.out.println(ans);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    private static long solve(final int n, final long[] h, final long[] a) {
        //this map stores the height of flower mapped to the max beauty that can be 
        //reached upto the flower with this height
        final TreeMap<Long, Long> meaningful = new TreeMap<>(); //Tree map keeps the keys sorted`
        meaningful.put(h[0], a[0]);
        long ans = a[0];
        for (int i = 1; i < n; i++) {
            //first try to place this at suitable place..
            Long lowerKey = meaningful.lowerKey(h[i]);
            if (lowerKey != null) {
                Long lowerVal = meaningful.get(lowerKey);
                meaningful.put(h[i], lowerVal + a[i]);
            } else {
                meaningful.put(h[i], a[i]);
            }

            //now remove all the useless flowers which have greater height but lower beauty.
            Long upperKey = meaningful.higherKey(h[i]);
            while (upperKey != null && meaningful.get(upperKey) < meaningful.get(h[i])) {
                meaningful.remove(upperKey);
                upperKey = meaningful.higherKey(h[i]);
            }
            ans = Math.max(ans, meaningful.get(h[i]));
        }
        return ans;
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
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
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
