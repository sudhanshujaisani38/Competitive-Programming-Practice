
/**
 * There are N stones, numbered 1 , 2 , … , N . For each i ( 1 ≤ i ≤ N ), the
 * height of Stone i is h i . Here, h 1 < h 2 < ⋯ < h N holds.
 * 
 * There is a frog who is initially on Stone 1 . He will repeat the following
 * action some number of times to reach Stone N :
 * 
 * If the frog is currently on Stone i , jump to one of the following: Stone i +
 * 1 , i + 2 , … , N . Here, a cost of (h[j] − h[i])^2 + C is incurred, where j
 * is the stone to land on. Find the minimum possible total cost incurred before
 * the frog reaches Stone N .
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Z {
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

    public static void main(String[] args) throws Exception {
        int n = fastReader.nextInt();
        long c = fastReader.nextLong();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fastReader.nextLong();
        }
        long ans = solve(n, c, arr);
        System.out.println(ans);
    }

    private static long solve(int n, long c, long[] h) {
        CHT minimaDS = new CHT();
        long dp[] = new long[n];
        dp[0] = 0;
        Line firstLine = new Line(-2 * h[0], h[0] * h[0]);
        minimaDS.insert(firstLine);
        for (int i = 1; i < n; i++) {
            dp[i] = h[i] * h[i] + c + minimaDS.query(h[i]);
            Line line = new Line(-2*h[i], dp[i]+h[i]*h[i]);
            minimaDS.insert(line);
        }
        return dp[n-1];
    }

    static class CHT {
        LinkedList<Pair<Line, Long>> dq = new LinkedList<>();

        void insert(Line line) {
            if (dq.isEmpty()) {
                dq.add(new Pair<Line,Long>(line, 0l));
                return;
            }
            while (!dq.isEmpty()) {
                long x = line.xIntersect(dq.peekLast().getKey());
                if (x <= dq.peekLast().getValue()) {
                    dq.pollLast();
                } else {
                    Pair<Line, Long> newPair = new Pair<Line, Long>(line, x);
                    dq.addLast(newPair);
                    break;
                }
            }
        }

        long query(long x) {
            while (dq.size() > 1) {
                if (dq.get(1).getValue() <= x) {
                    dq.removeFirst();
                } else {
                    break;
                }
            }
            return dq.peekFirst().getKey().valAtX(x);
        }
    }

    static class Line {
        long m; // slope
        long c; // intercept

        Line(long m, long c) {
            this.m = m;
            this.c = c;
        }

        long valAtX(long x) {
            return m * x + c;
        }

        long xIntersect(Line line) {
            return (long) Math.ceil(1.0 * (line.c - this.c) / (this.m - line.m));
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
    static class Pair<K,V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        K getKey(){
            return key;
        }
        V getValue(){
            return value;
        }
    }
}