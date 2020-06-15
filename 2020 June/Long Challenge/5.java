import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                if((n&1)==0){
                    int value=1;
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            stringBuffer.append(value+" ");
                            value++;
                        }
                        stringBuffer.append("\n");
                        i++;
                        String ss="";
                        for(int j=n-1;j>=0;j--){
                            ss=value+" "+ss;
                            value++;
                        }
                        stringBuffer.append(ss);
                        stringBuffer.append("\n");
                    }
                }else{
                    int value=1;
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            stringBuffer.append(value+" ");
                            value++;
                        }
                        stringBuffer.append("\n");
                    }
                }
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
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