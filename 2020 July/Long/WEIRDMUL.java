import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;

class Main {
    static {
        try {
            System.setOut(new PrintStream(new File("output.txt")));
            new File("input.txt").createNewFile();
            System.setIn(new FileInputStream(new File("input.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();
    public static final int MOD=998244353;

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int x=fastReader.nextInt();
                long arr[]=new long[n];
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextLong();
                }
                long xkiPower[]=new long[n];
                xkiPower[0]=1;
                // acc[0]=arr[0];
                long sn[]=new long[n+1];
                
                for(int i=1;i<n;i++){
                    xkiPower[i]=fastModExpo(x, i);
                    sn[i]=((sn[i-1]%MOD)+(i%MOD))%MOD;
                }
                sn[n]=(sn[n-1]%MOD)+(n%MOD)%MOD;
                long acc[]=new long[n];
                
                // System.out.println();
                long ans=1;
                for(int i=0;i<n;i++){
                    acc[i]=((arr[i]%MOD)*(xkiPower[0]%MOD))%MOD;
                    ans=((ans%MOD)*(acc[i]%MOD))%MOD;
                    for(int j=i+1;j<n;j++){
                        // System.out.println("("+i+","+j+")");
                        acc[j]=acc[j-1];
                        acc[j]=((acc[j]%MOD)+((arr[j]%MOD)*(xkiPower[j-i]%MOD))%MOD)%MOD;
                        ans=((ans%MOD)*(acc[j]%MOD))%MOD;
                        // System.out.println("adding:(a["+(j+1)+"]*x["+(j-i)+"])^"+(n-i));
                    }

                }          
                ans=((ans%MOD)*(ans%MOD))%MOD;
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    static int fastModExpo(long a,long e){
        long res=1;
        while(e>0){
            if((e&1)!=0){
                res=((res%MOD)*(a%MOD))%MOD;
            }
            a=((a%MOD)*(a%MOD))%MOD;
            e=e>>1;
        }
        return (int)(res%MOD);
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