//calculation of lca using binary lifting
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

    public static void main(String[] args) throws Exception {
        redirectIO();
        Graph g = new Graph(9);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 5);
        g.addEdge(5, 4);
        g.addEdge(4, 8);
        g.addEdge(2, 6);
        g.addEdge(6, 7);
        g.actualDFS(1, -1, 0);
        g.prepareSparseTable();

        System.out.println(g.getLCAOf(5, 8));
        System.out.println(g.getLCAOf(1, 3));
        System.out.println(g.getLCAOf(2, 3));
        System.out.println(g.getLCAOf(5, 7));
        System.out.println(g.getLCAOf(4, 6));
        System.out.println(g.getLCAOf(4, 3));
    }

    public static int log2(int N) {
        int result = (int) (Math.log(N) / Math.log(2));
        return result;
    }

    static class Graph {
        int noOfNodes;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int parentOf[];
        int depthOf[];
        int maxDepth;
        int lca[][];

        public Graph(int n) {
            this.noOfNodes = n;
            parentOf = new int[n];
            depthOf = new int[n];
            maxDepth = 0;
            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<Integer>());
            }
        }

        // this function builds up the sparse table: lca
        // lca[i][j] denotes the 2^jth parent of node i
        void prepareSparseTable() {

            //first calculate the max power of 2 that needs to be stored
            // if max depth of any node in the tree is 4, then max power will be 2 (4=2^2)
            int maxPower = log2(maxDepth);

            lca = new int[noOfNodes][maxPower + 1];

            //initialise the lca table with -1.
            //except for the immediate parents of each node which we have calculated during dfs
            for (int i = 0; i < noOfNodes; i++) {
                lca[i][0] = parentOf[i];
                for (int j = 1; j < maxPower; j++) {
                    lca[i][j] = -1;
                }
            }

            //now populate other values
            //logic:if you want to fill 16th parent of a node, ask your 8th parent who is it's 8th parent
            for (int j = 1; j < maxPower; j++) {
                for (int i = 0; i < noOfNodes; i++) {
                    if (lca[i][j - 1] != -1) { // check if this parent exists or not
                        int parent = lca[i][j - 1];
                        lca[i][j] = lca[parent][j - 1];
                    }
                }
            }

        }

        int getLCAOf(int a, int b) {
            int maxPower = log2(maxDepth);
            if (depthOf[a] > depthOf[b]) {
                return getLCAOf(b, a);
            } else {
                int diff = depthOf[b] - depthOf[a];
                while (diff > 0) {
                    int i = log2(diff); //this will give you the max jump you can take (in power of 2)
                    b = lca[b][i];
                    diff -= (1 << i);
                }
                if (a == b)
                    return a;

                for (int i = maxPower; i >= 0; i--) {
                    if (lca[a][i] != -1 && (lca[a][i] != lca[b][i])) { //jump untill the 2^ith parents are different
                        a = lca[a][i];
                        b = lca[b][i];
                    }
                }

                //now we are just one step below the lca. So, return current node's parent.
                return parentOf[a];
            }
        }

        public void addEdge(int x, int y) {
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        private void actualDFS(int src, int parent, int depth) {

            depthOf[src] = depth;
            parentOf[src] = parent;
            maxDepth = Math.max(maxDepth, depth);
            ArrayList<Integer> neighbours = adjList.get(src);
            for (Integer neighbour : neighbours) {
                if (neighbour != parent) {
                    actualDFS(neighbour, src, depth + 1);
                }
            }
        }

    }

}