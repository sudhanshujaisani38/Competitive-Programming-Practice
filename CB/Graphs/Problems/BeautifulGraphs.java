
//https://codeforces.com/problemset/problem/1093/D#
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];
    int color[];
    public static final int MOD = 998244353;

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        color = new int[n];
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<Integer>());
            color[i] = -1;
        }
    }

    public void addEdge(int x, int y) {
        adjList.get(x).add(y);
        adjList.get(y).add(x);
    }

    // tries to color the graph using dfs & returns if it could color it.
    private boolean colorGraph(int src, int colorOfSrc, long colorCount[],int parentOf[]) {
        // System.out.print(src+"("+colorOfSrc+"),");
        isVisited[src] = true;
        boolean oddCycleDetected=false;
        colorCount[colorOfSrc]++;
        color[src]=colorOfSrc;
        ArrayList<Integer> neighbours = adjList.get(src);
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                parentOf[neighbour]=src;
                boolean couldColor = colorGraph(neighbour, 1 - colorOfSrc, colorCount,parentOf);
                if (!couldColor) {
                    oddCycleDetected=true;
                }
            } else {
                if (neighbour!=parentOf[src] && color[neighbour] == colorOfSrc) {
                    oddCycleDetected=true;
                }
            }
        }
        
        return !oddCycleDetected;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            Graph g = new Graph(v + 1);
            for (int i = 0; i < e; i++) {
                int first = sc.nextInt();
                int sec = sc.nextInt();
                g.addEdge(first, sec);
            }
            g.solve();
        }

    }

    private void solve() {
        long finalAns = 1;
        int parentOf[]=new int[noOfNodes];
        for (int i = 1; i < noOfNodes; i++) {
            if (!isVisited[i]) {
                long colorCount[] = new long[2];
                parentOf[i]=-1;
                // System.out.println("Starting dfs from:" + i);
                if (colorGraph(i, 0, colorCount,parentOf)) {
                    // if colored succesfully
                    // System.out.println("odd:"+colorCount[0] + " even:" + colorCount[1]);
                    long ansForThisComponent = ((1l << colorCount[0]) % MOD) + ((1l << colorCount[1]) % MOD);
                    // System.out.println("ansForThisComponent:"+ansForThisComponent);
                    finalAns = (finalAns*ansForThisComponent) % MOD;
                } else {
                    // if odd cycle was detected somewhere
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(finalAns);
    }

}