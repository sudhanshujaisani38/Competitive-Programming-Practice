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

class APLONG_2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int m=fastReader.nextInt();
                int k=fastReader.nextInt();
                int an[][]=new int[n][k];
                int minCorr[]=new int[k];
                int modval=n;
                for(int i=0;i<n;i++){
                    int arr[]=new int[m];
                    for(int j=0;j<k;j++){
                        int ans=fastReader.nextInt();
                        an[i][j]=ans;
                        arr[ans]++;
                    }
                    int max=0;
//                    out.println("response freq");
                    for(int j=1;j<=m;j++){
//                        out.print(arr[j]+",");
                        if(arr[j]>max){
                            max=j;
                        }
                    }
//                    out.println();
                    if(arr[max]>=(n/2)){
                        sb.append(an[i][max]+" ");
                        for(int z=0;z<k;z++){
                            if(arr[z]==arr[max]){
                                minCorr[z]++;
                            }
                        }
                    }
//                    else{
//                        sb.append(an[i][modval%m]+" ");
//                        modval--;
//                    }
//                    modval=modval%m;
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
