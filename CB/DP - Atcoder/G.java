
/*
Given a directed graph with n vertices & m edges (With no directed cycles),
find the longest path present in the graph

Solution: Run dfs from each vertex and calculate the longest path O(n*n)
            Optimize by saving the dfs result O(n).
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

class G {
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
            int testCases = 1;
            while (testCases-- > 0) {
                int noOfVertex = fastReader.nextInt();
                int noOfEdges = fastReader.nextInt();
                Graph g=new Graph(noOfVertex);
                for (int i = 0; i < noOfEdges; i++) {
                    int x=fastReader.nextInt();
                    int y=fastReader.nextInt();
                    g.addEdge(x-1, y-1); //graph working on zero based vertices
                }
                int longestPathLength=0;
                int dp[]=new int[noOfVertex];                
                for(int i=0;i<noOfVertex;i++){
                    dp[i]=-1;
                }
                for(int i=0;i<noOfVertex;i++){
                    longestPathLength=Math.max(longestPathLength, g.dfs(i,dp));
                }
                System.out.println(longestPathLength);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    static class Graph {
        int noOfNodes;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        public Graph(int n) {
            this.noOfNodes = n;
            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<Integer>());
            }
        }

        public void addEdge(int x, int y) {
            adjList.get(x).add(y);
        }

        private int dfs(int src, int dp[]) {
            if(dp[src]!=-1){
                return dp[src];
            }
            int temp=0;
            ArrayList<Integer> neighbours = adjList.get(src);
            for (Integer neighbour : neighbours) {
                    temp=Math.max(temp,dfs(neighbour,dp)+1);
            }
            dp[src]=temp;
            return temp;
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