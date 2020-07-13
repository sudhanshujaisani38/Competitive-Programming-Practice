import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                long stVal = fastReader.nextLong();
                long arr[] = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = fastReader.nextLong();
                }
                long ans = solve(stVal, arr, n);
                stringBuffer.append(ans + "\n");
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static long solve(long stVal, long[] arr, int n) {
        long ans = 0l;
        Arrays.sort(arr);
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= stVal) {
                list1.add(arr[i]);
            } else {
                list2.add(arr[i]);
            }
        }

        while (list2.size() > 0 && list1.size() > 0
                && ((float) (list2.get(list2.size() - 1)) >= (float) (list1.get(0) / 2f)||
                ((float)(list2.get(list2.size() - 1))>=(float)(stVal/2f)))) {
            list1.add(0, list2.get(list2.size() - 1));
            list2.remove(list2.size() - 1);
        }
        if (list1.size() > 0 && list1.get(0) > stVal) {
            list1.add(0, stVal);
        }
        if (list1.size() > 0) {
            ans = 1;
            long diff[] = new long[list1.size() - 1];

            for (int i = 1; i < list1.size(); i++) {
                diff[i - 1] = daysToCover(list1.get(i), list1.get(i - 1));
                ans += diff[i - 1];
            }
            
        }
        ans += list2.size();
        return ans;
    }

    private static long daysToCover(long pop, long stVal) {
        if (stVal == 0)
            throw new RuntimeException("stVal=0");
        if (stVal >= pop){
            return 1;
        }            
        int x = 0;
        while ((float)(stVal * (1 << x)) < (float)(pop/2f)) {
            x++;
        }
        return x + 1;
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