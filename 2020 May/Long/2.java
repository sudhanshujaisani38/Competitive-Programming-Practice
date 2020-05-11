//this code didn't worked without fast reader
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();
    static FastReader sc = new FastReader();
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int arr[] = new int[26];
            String str = sc.next();
            for (int i = 0; i < n; i++) {
                int index = str.charAt(i) - 'a';
                arr[index]++;
            }
            int ans = 0;
            for (int i = 0; i < q; i++) {
                ans = 0;
                int capacity = sc.nextInt();
                for (int j = 0; j < 26; j++) {
                    if (arr[j] > capacity) {
                        ans += (arr[j] - capacity);
                    }
                }
                System.out.println(ans);
            }
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}