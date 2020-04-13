import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.in;
import static java.lang.System.out;

class OCTLONG19_3 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
    static HashMap<Integer, Long> power = new HashMap<>();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                power.clear();
                long maxPower = 0;
                for (int i = 0; i < n; i++) {
                    int ele = fastReader.nextInt();
                    if (power.get(ele) == null)
                        power.put(ele, 0l);
                    long powerTemp = power.get(ele);
                    if (powerTemp > maxPower) {
//                        out.println("Max power updated:"+powerTemp+" of "+ele);
                        maxPower = powerTemp;
                    }
                    getDivisors(ele);
                }

                sb.append(maxPower + "\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    static void getDivisors(int n) {
        if (n == 1)
            return;
        for (int i = 1; i <= (int) sqrt(n); i++) {
            if (n % i == 0) {
                if ((n / i) == i) {
                    if (power.get(i) != null)
                        power.put(i, power.get(i) + 1);
                    else
                        power.put(i, 1l);
                } else {
                    if (power.get(i) != null)
                        power.put(i, power.get(i) + 1);
                    else
                        power.put(i, 1l);

                    if (power.get(n / i) != null)
                        power.put((n / i), power.get(n / i) + 1);
                    else
                        power.put((n / i), 1l);


                }
            }
        }
//        out.println(power);
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
