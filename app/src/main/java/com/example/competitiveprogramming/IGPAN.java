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

class IGPAN {
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int n = fastReader.nextInt();
            char arr[][]=new char[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=fastReader.next().charAt(0);
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    out.print(arr[i][j]+" ");
                }
                out.println();
            }
            int size=n;
            sizeDec:while(size>0){
                out.println("Checking size:"+size);
                sameSize:for(int start=0;start<=n-size;start++){
                    for(int i=start;i<start+size;i++){
                        for(int j=start;j<=start+size;j++){
                            if(arr[i][j]=='x')
                            {
                                out.println("x found at "+i+" "+j);
                                continue sameSize;
                            }
                        }
                    }
                    out.println(size);
                    return;
                }
                size--;
            }
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
                    st = new StringTokenizer(br.readLine(),"#");
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
