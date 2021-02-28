/*
 * Given a tree with N vertices, numbered 1 to N ,you need to paint each vertex
 * in white or black. Here, it is not allowed to paint two adjacent vertices both in black.
 * 
 * Find the number of ways in which the vertices can be painted, modulo 10^9 + 7.
 * 
 * How to solve:
 * dp[i][0]: represents no of ways we can paint each vertex of subtree 
 *           whose root is i, given that parent of i was not painted black
 * dp[i][1]: represents no of ways we can paint each vertex of subtree 
 *           whose root is i, given that parent of i was painted black
 * 
 * base case: for a leaf node, if parent was black then it can have only white color, 
 *                             if parent was white then it can have black/white
 * 
 * recursive case: irrespective of parent being black or white,paint the current node white
 *                   and call the same func for all the child nodes
 *                 if parent of current node was white, paint the current node black
 *                   and calculate for subtree of all child nodes
 *                 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class P {
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
    static final int MOD = 1000_000_007;

    public static void main(String[] args) throws Exception {
        try {
            int n = fastReader.nextInt();
            Graph graph = new Graph(n);
            for (int i = 0; i < n - 1; i++) {
                int x = fastReader.nextInt();
                int y = fastReader.nextInt();
                graph.addEdge(x, y);
            }
            long dp[][] = new long[n + 1][2];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = dp[i][1] = -1;
            }
            long ans = solve(graph, 1, false, -1, dp);
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static long solve(Graph graph, int vertex, boolean isParentBlack, int parent, long dp[][]) {
        ArrayList<Integer> list = graph.adjList.get(vertex);

        int isConstrained = isParentBlack ? 1 : 0;
        if (dp[vertex][isConstrained] != -1) {
            return dp[vertex][isConstrained];
        }
        long ans1 = 1, ans2 = 1;
        long ans = 0;
        for (int child : list) {
            if (child != parent) {
                ans1 = (ans1 * solve(graph, child, false, vertex, dp)) % MOD;
            }
        }
        ans = (ans + ans1) % MOD;
        if (!isParentBlack) {
            for (int child : list) {
                if (child != parent) {
                    ans2 = (ans2 * solve(graph, child, true, vertex, dp)) % MOD;
                }
            }
            ans = (ans + ans2) % MOD;
        }
        return dp[vertex][isConstrained] = ans % MOD;
    }

    static class Graph {
        int noOfNodes;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        boolean isVisited[];

        public Graph(int n) {
            this.noOfNodes = n;
            isVisited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                adjList.put(i, new ArrayList<Integer>());
            }
        }

        public void addEdge(int x, int y) {
            adjList.get(x).add(y);
            adjList.get(y).add(x);
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