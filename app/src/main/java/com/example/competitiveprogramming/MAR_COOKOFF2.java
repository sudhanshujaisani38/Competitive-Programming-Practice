import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.console;
import static java.lang.System.in;
import static java.lang.System.out;

class MAR_COOKOFF2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            int maxleftIndex=-1,maxrtIndex=-1,maxele=-1;
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                boolean allSame=true;
                for(int i=1;i<=n;i++){
                    int w=fastReader.nextInt();
                    if(w>maxele){
                        maxele=w;
                        maxleftIndex=i;
                        maxrtIndex=i;
                    }
                    if(w==maxele){
                        maxrtIndex=i;
                    }else{
                        allSame=false;
                    }
                }
                if(allSame){
                    sb.append(n).append("\n");
                    continue;
                }
                int mid=n/2;
                if(maxleftIndex<=mid && maxrtIndex<=mid){
                    int d=mid-maxleftIndex;
                    int diff=n-maxrtIndex-d;
                    sb.append(diff).append("\n");continue;
                }
                if(maxleftIndex>mid && maxrtIndex>mid){
                    int diff=n-maxrtIndex+1;
                    sb.append(diff).append("\n");continue;
                }
                if(maxleftIndex<=mid && maxrtIndex>mid){
                    int minSteps=mid-maxleftIndex+1;
                    int maxSteps=n-maxrtIndex;
                    if(minSteps>maxSteps)sb.append(0).append("\n");
                    if(minSteps<=maxSteps){

                        int diff=n-maxrtIndex;
                        sb.append(diff).append("\n");continue;
                    }
                }
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
            return parseDouble(next());new HashSet<>().a
        }
    }
}
