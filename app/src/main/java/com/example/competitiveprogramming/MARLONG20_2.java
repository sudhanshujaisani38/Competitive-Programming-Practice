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

class MARLONG20_2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static int getNoOfOnes(int n){
//        out.println("no of ones in "+n);
        int noOfOnes=0;
        while(n>0){
            if((n&1)==1){
                noOfOnes++;
            }
            n=n>>1;
        }
//        out.print(noOfOnes);
//        out.println();

        return  noOfOnes;
    }
    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int q=fastReader.nextInt();
                int a[]=new int[n];
                for(int i=0;i<n;i++){
                    a[i]=fastReader.nextInt();
                }
                for(int i=0;i<q;i++){
                    int even=0,odd=0;
                    int p=fastReader.nextInt();
                    int b[]=new int[n];
                    for(int j=0;j<n;j++){
                        int xor=a[j]^p;
                        int ones=getNoOfOnes(xor);
                        if(ones%2==0){
                            even++;
                        }else{
                            odd++;
                        }
                    }
                    sb.append(even+" "+odd+"\n");
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
            return parseDouble(next());
        }
    }
}
