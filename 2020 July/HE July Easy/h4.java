import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.math.BigInteger;
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
    public static final int MOD=1000000007;

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                long n=fastReader.nextLong();
                long ans=0l;
                // if(n%2!=0){
                //     ans+=n;
                //     n--;
                // }
                if(n==1){
                    System.out.println(1);
                    continue;
                }
                if(n%2!=0){
                    ans=solve(n-1);
                    ans=((ans%MOD)*n%MOD)%MOD;
                }else{
                    ans=solve(n);
                }
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static long solve(long n) {

        long ans=0l;
        BigInteger b=BigInteger.valueOf(1);
        b=b.shiftLeft((int)n-1);
        b=b.mod(BigInteger.valueOf(MOD));
        long type3=b.intValue()-1;
        // System.out.println("type3="+type3);
                // System.out.println(type3+","+n);
                long fact=facto(n/2+1,n);
                long fact2=facto(1l,n/2);
                long modInv=modInverse2(fact2, MOD);
                long temp=((fact%MOD)*(modInv%MOD))%MOD;
                ans=((ans%MOD)+(temp%MOD))%MOD;
                // ans=(ans%MOD+fact%MOD)%MOD;
                // System.out.println("ans="+ans);
                // ans=((ans%MOD)*(2%MOD))%MOD;
                // System.out.println("ans="+ans);
                ans=((ans%MOD)+(type3%MOD))%MOD;
                // System.out.println("ans="+ans);
        return ans;
    }

    private static long facto(long m, long n) {
        long b=1l;
        for(long i=m;i<=n;i++){
            b=((b%MOD)*(i%MOD))%MOD;
        }
        return b;
    }
    static int modInverse(long a, long m) 
    { 
        a = a % m; 
        for (int x = 1; x < m; x++) 
           if ((a * x) % m == 1) 
              return x; 
        return 1; 
    } 
    static long modInverse2(long a, long m) 
    { 
        long m0 = m; 
        long y = 0, x = 1; 
  
        if (m == 1) 
            return 0; 
  
        while (a > 1) 
        { 
            long q = a / m; 
  
            long t = m; 

            m = a % m; 
            a = t; 
            t = y; 
  
            y = x - q * y; 
            x = t; 
        } 
        if (x < 0) 
            x += m0; 
  
        return x; 
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