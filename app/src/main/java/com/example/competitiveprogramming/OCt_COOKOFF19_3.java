import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class OCt_COOKOFF19_3 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    static long countBits(long l,long r)
    {
        long mid=(l+r)/2;
       return (mid|(mid+1));
    }
    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                long l=fastReader.nextLong();
                long r=fastReader.nextLong();
                out.println(countBits(l,r));
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        public int nextInt() {
            return parseInt(next());
        }

        public long nextLong() {
            return parseLong(next());
        }

        public double nextDouble() {
            return parseDouble(next());
        }
    }
}
