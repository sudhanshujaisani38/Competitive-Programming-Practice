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
            test:while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int arr[]=new int[n];
                int coins[]=new int[16];
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextInt();
                }
                for(int i=0;i<n;i++){
                    if(arr[i]==15){
                        if(coins[10]>=1){
                            coins[10]--;
                            coins[15]++;
                            continue;
                        }
                        if(coins[5]>=2){
                            coins[5]-=2;
                            coins[15]++;
                            continue;
                        }
                        System.out.println("NO");
                        continue test;
                    }else if(arr[i]==10){
                        if(coins[5]>=1){
                            coins[5]--;
                            coins[10]++;
                            continue;
                        }
                        System.out.println("NO");
                        continue test;
                    }else{
                        coins[5]++;
                    }
                }
                System.out.println("YES");
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