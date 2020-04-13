import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class OCTLONG19_1 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) throws IOException {

            int testCases = fastReader.nextInt();
            int r,c,q,x,y;
            long count;
            while (testCases-- > 0) {
                r=fastReader.nextInt();
                c=fastReader.nextInt();
                q=fastReader.nextInt();

                int rows[]=new int[r];
                int columns[]=new int[c];

                for(int i=0;i<q;i++){
                    x=fastReader.nextInt();
                    y=fastReader.nextInt();
                    x--;
                    y--;
                    rows[x]++;
                    columns[y]++;
                }
                long evenColumns=0,evenRows=0,oddRows,oddColumns;
                for(int i=0;i<r;i++){
                    if((rows[i]&1)==0){
                        evenRows++;
                    }
                }
                oddRows=r-evenRows;
                for(int i=0;i<c;i++){
                    if((columns[i]&1)==0){
                        evenColumns++;
                    }
                }
                oddColumns=c-evenColumns;
                count=(evenColumns*oddRows)+(oddColumns*evenRows);
                sb.append(count+"\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
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
