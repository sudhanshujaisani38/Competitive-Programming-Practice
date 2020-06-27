import java.util.*;
import java.io.*;

class DSU {
    int noOfNodes;
    int parent[];
    int ans;

    public DSU(int n) {
        this.noOfNodes = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        ans = n;
    }

    static {
        try {
            System.setOut(new PrintStream(new File("output.txt")));
            new File("input.txt").createNewFile();
            System.setIn(new FileInputStream(new File("input.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        DSU dsu = new DSU(n);
        int q = fastReader.nextInt();
        while (q-- > 0) {
            int first = fastReader.nextInt();
            int sec = fastReader.nextInt();
            first--;
            sec--;
            int k=sec-first;
            for(int i=0;i<=k;i++)
            dsu.performUnion(first+i, sec-i);
            System.out.println(dsu.ans);

        }
    }

    private int getSuperParentOf(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = getSuperParentOf(parent[x]);
            return parent[x];
        }
    }

    private void performUnion(int x, int y) {        
        int px = getSuperParentOf(x);
        int py = getSuperParentOf(y);
        if (px != py) {
            // System.out.println("joining"+(x+1)+"&"+(y+1));
            // only perform union only when they are not already united
            parent[px] = py;
            ans--;
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