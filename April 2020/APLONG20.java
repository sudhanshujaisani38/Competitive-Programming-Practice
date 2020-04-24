import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class APLONG20 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args)throws  Exception {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                long arr[]=new long[n];
                long left[]=new long[n];
                long right[]=new long[n];
                int last2=1;
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextLong();
                    if((arr[i]&1)==1){
                        arr[i]=1;

                    }else if((arr[i]%4)==0){
                        arr[i]=4;
                    }else{
                        arr[i]=2;
                    }

                }
                int noOf1=0;
                for(int i=0;i<n;i++){
                    left[i]=noOf1;
                    if(arr[i]==1){
                        noOf1++;
                    }else{
                        noOf1=0;
                    }
                }
                noOf1=0;
                for(int i=(n-1);i>=0;i--){
                    right[i]=noOf1;
                    if(arr[i]==1){
                        noOf1++;
                    }else{
                        noOf1=0;
                    }
                }
                long ex=0;
                for(int i=0;i<n;i++){
                    if(arr[i]==2){
                        ex=ex+((left[i]+1)*(right[i]+1));
                    }
//                    out.print(arr[i]+",");
                }
//                out.println();
                long total=(long)n*((long)n+1)/2;
//                out.println("total="+total+" ex="+ex);
                out.println(total-ex);
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (OutOfMemoryError e) {
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
