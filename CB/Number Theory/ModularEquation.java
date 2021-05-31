import java.io.*;
import java.util.*;

class Mainn {
    static void redirectIO() {
        try {
            final String INPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/input.txt";
            final String OUTPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/output.txt";
            System.setOut(new PrintStream(new File(OUTPUT_FILE)));
            File inputFile = new File(INPUT_FILE);
            inputFile.createNewFile();
            System.setIn(new FileInputStream(inputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        redirectIO();
        FastReader fastReader = new FastReader();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer stringBuffer = new StringBuffer();
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int m = fastReader.nextInt();
                int ans = solve(n,m);
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    static int solve(int n,int m){
        int count = 0;
        for(int i =1;i<=n;i++){
            for(int j = i+1; j<=n;j++){
                if((m%i)%j == (m%j)%i){
                    System.out.println(i+" and "+j);
                    count++;
                }
            }
        }
        return count;
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