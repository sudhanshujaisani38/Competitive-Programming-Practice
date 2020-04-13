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

class FEBLONG20_2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int k=fastReader.nextInt();
                int arr[]=new int[n];
                int prev[]=new int[n];
                int next[]=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextInt();
                    prev[i]=arr[i]%k;
                    next[i]=k-prev[i];
                }
//                for(int i=0;i<n;i++){
//                    out.print(prev[i]+",");
//                }
//                out.println();
//                for(int i=0;i<n;i++){
//                    out.print(next[i]+",");
//                }
//                out.println();

                int minR=Integer.MAX_VALUE;
                for(int i=0;i<n;i++){
                    int r=0;
                    for(int j=0;j<=i;j++){
                        r+=prev[j];
                    }
                    for(int j=i+1;j<n;j++){
                        r-=next[j];
                    }
                    if(r>=0 && minR>r){
//                        out.println("min for i="+i);
                        minR=r;
                    }
                }
                sb.append(minR).append("\n");

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
