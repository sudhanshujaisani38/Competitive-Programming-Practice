
/*
Given an array AA of length N and an integer K, Chef writes down the sum of all subarrays of length K in A.
Chef writes only distinct values. You want to find the minimum number of changes you need to make to array A,
such that Chef writes only one value.
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

    static int solve(int n, int k, int arr[]) {
        ArrayList<HashMap<Integer, Integer>> group = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            group.add(new HashMap<Integer, Integer>());
        }
        for (int i = 0; i < n; i++) {
            int groupNo = i % k;
            int freq = group.get(groupNo).getOrDefault(arr[i], 0);
            group.get(groupNo).put(arr[i], freq + 1);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int highestFreq = 0;
            int totalInGroup = 0;
            for (int key : group.get(i).keySet()) {
                int freq = group.get(i).get(key);
                highestFreq = Math.max(highestFreq, freq);
                totalInGroup += freq;
            }
            ans += (totalInGroup - highestFreq);
        }
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
                int n = fastReader.nextInt();
                int k = fastReader.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = fastReader.nextInt();
                }
                int ans = solve(n, k, arr);
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