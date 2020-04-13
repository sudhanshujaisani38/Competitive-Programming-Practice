import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.identityHashCode;
import static java.lang.System.in;
import static java.lang.System.out;

class OCT_COOKOFF19_2 {

    static String powersOf20[]=new String[19];
    static String powersOf10[]=new String[19];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
static void fillArr(){
    for(int i=0;i<19;i++){
        powersOf20[i]=(long)Math.pow(20,i)+"";
        powersOf10[i]=(long)Math.pow(10,i)+"";
    }
}

    public static void main(String[] args) {
        out.println(1031&93714);
        try {fillArr();
            int testCases = fastReader.nextInt();
            outer:while (testCases-- > 0) {
                String str=fastReader.next();
                int zeroCount=0;
                for(int i=str.length()-1;i>=0;i--){
                    if(str.charAt(i)=='0')
                        zeroCount++;
                    else
                        break;
                }
                String str2=str.substring(0,str.length()-zeroCount);
                out.println(str2);
                long num=Long.parseLong(str2);
                for(int i=0;i<19;i++){
                    if(num==(long)Math.pow(2,i)){
                        if(zeroCount>=log2(num))
                            sb.append("Yes\n");
                        else
                            sb.append("No\n");
                        continue outer;
                    }
                }
                sb.append("No\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static int log2(long x){
        return (int)(Math.log(x)/Math.log(2));
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
