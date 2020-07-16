
//this problem didn't worked without fast reader -_-
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            Graph g = new Graph(n);
            for (int i = 1; i <= n; i++) {
                g.a[i] = sc.nextLong();
            }
            for (int i = 0; i < (n - 1); i++) {
                int first = sc.nextInt();
                int sec = sc.nextInt();
                g.addEdge(first, sec);
            }
            g.actualDFS(1, 0);
            for (int i = 0; i < q; i++) {
                int type = sc.nextInt();
                if (type == 1) {
                    int first = sc.nextInt();
                    int sec = sc.nextInt();
                    int x = sc.nextInt();
                    g.solve1(first, sec, x);
                } else {
                    boolean isVis[] = new boolean[n + 1];
                    int k = sc.nextInt();
                    long y = sc.nextLong();
                    long ans = g.solve2(k, y, isVis);
                    System.out.println(ans);

                }
            }
        }
    }

    static class Graph {
        int noOfNodes;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        long a[];
        boolean isVisited[];
        int parentOf[];
        int depth[];

        public Graph(int n) {
            this.noOfNodes = n;
            this.a = new long[n + 1];
            isVisited = new boolean[n + 1];
            depth = new int[n + 1];
            parentOf = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                adjList.put(i, new ArrayList<Integer>());
            }
        }

        public void addEdge(int x, int y) {
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        private void actualDFS(int src, int d) {
            isVisited[src] = true;
            this.depth[src] = d;
            ArrayList<Integer> neighbours = adjList.get(src);
            for (Integer neighbour : neighbours) {
                if (!isVisited[neighbour]) {
                    parentOf[neighbour] = src;
                    actualDFS(neighbour, d + 1);

                }
            }
        }

        private long solve2(int src, long y, boolean isVis[]) {
            System.out.println("at:" + src);
            isVis[src] = true;
            long maxXor = a[src] ^ y;
            System.out.println("xor:" + maxXor);
            ArrayList<Integer> neighbours = adjList.get(src);
            for (Integer neighbour : neighbours) {
                if (!isVis[neighbour] && depth[neighbour] > depth[src]) {
                    maxXor = Math.max(maxXor, solve2(neighbour, y, isVis));
                }
            }

            return maxXor;
        }

        private void solve1(int first, int sec, long x) {
            int d1 = depth[first];
            int d2 = depth[sec];
            if (d1 > d2) {
                while (d1 != d2) {
                    a[first] = a[first] | x;
                    d1--;

                    // System.out.println("updated:"+first+":"+a[first]);
                    first = parentOf[first];
                }
            } else {
                while (d1 != d2) {
                    a[sec] = a[sec] | x;
                    d2--;
                    // System.out.println("updated:"+sec+":"+a[sec]);
                    sec = parentOf[sec];
                    
                }
            }
            // System.out.println("at same level");
            while(first!=sec){
                a[first]=a[first]|x;
                a[sec]=a[sec]|x;
                first=parentOf[first];
                sec=parentOf[sec];
                // System.out.println("updated:"+first+":"+a[first]);
                // System.out.println("updated:"+sec+":"+a[sec]);
            }
            
            a[first]=a[first]|x;
            // System.out.println("updated:"+first+":"+a[first]);
            
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
