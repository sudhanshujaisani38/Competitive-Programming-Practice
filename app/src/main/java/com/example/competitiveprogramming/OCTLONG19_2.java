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

class OCTLONG19_2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
    static int arr[]=new int[10000];

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                long k=fastReader.nextLong();
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextInt();
                }
                int end=(n/2);
                if(n%2!=0){
                    end++;
                    if(k>(n/2)){
                        arr[end-1]=0;
                    }
                }
                for(int z=0;z<((k/n)%3);z++){
                    for(int i=0;i<end;i++){
                        int a=arr[(i%n)];
                        int b=arr[n-(i%n)-1];
                        arr[n-(i%n)-1]=a;
                        arr[(i%n)]=a^b;
//                        out.println("After i="+i);
//                        for(int j=0;j<n;j++){
//                            out.print(arr[j]+" ");
//                        }
//                        out.println();
                    }
                }
//                out.println("Complete loops finished");
                for(int i=0;i<(k%n);i++){
                    int a=arr[(i%n)];
                    int b=arr[n-(i%n)-1];
                    arr[(i%n)]=a^b;
//                        out.println("After i="+i);
//                        for(int j=0;j<n;j++){
//                            out.print(arr[j]+" ");
//                        }
//                        out.println();
                }

                for(int i=0;i<n;i++){
                    sb.append(arr[i]+" ");
                }
                sb.append("\n");
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
