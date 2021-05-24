
/*
You have taken an eating challenge from Chef, to eat exactly YY burgers. You will eat in the following way:
1. In the first minute, you eat exactly X burgers, and in every minute after that, you will eat exactly twice the number of burgers you ate in the previous minute.
2. You can take a break of exactly one minute.
3. When you start eating again after the break, your eating streak resets, and you eat X burgers in that minute, and so on.

Additionally, let a_1, a_2... a_ka denote the length of your eating streaks. Chef asks that all a_i are pairwise distinct.
Find the minimum number of minutes you need in order to eat exactly Y burgers or determine if it’s impossible to do so.
 */
import java.io.*;
import java.util.*;

class Main {
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

    static long solve(long x, long y) {
        HashSet<Integer> set = new HashSet<>();
        long ans = 0;
        int powerOf2 = 0;
        long val = x;
        int len = 0;
        if (y % x != 0)
            return -1;
        while (y > 0) {
            if (y < x) {
                return -1;
            }
            if (y < val) {
                if (set.contains(len))
                    return -1;
                set.add(len);
                len = 0;
                powerOf2 = 0;
                val = x;
            } else {
                len++;
                y -= val;
                powerOf2++;
                val = (x << powerOf2);
            }
            ans++;
        }
        if (set.contains(len))
            return -1;
        return ans;
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
                long x = fastReader.nextLong();
                long y = fastReader.nextLong();
                long ans = solve(x, y);
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