import java.io.*;
import java.util.*;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    int parentOf[];
    int depthOf[];

    public Graph(int n) {
        this.noOfNodes = n;
        parentOf = new int[n];
        depthOf = new int[n];
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
    }

    public void addEdge(int x, int y) {
        adjList.get(x).add(y);
        adjList.get(y).add(x);
    }

    private void actualDFS(int src, int parent, int depth) {
        parentOf[src] = parent;
        depthOf[src] = depth;
        ArrayList<Integer> neighbours = adjList.get(src);
        for (Integer neighbour : neighbours) {
            if (neighbour != parent)
                actualDFS(neighbour, src, depth + 1);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 5);
        g.addEdge(5, 4);
        g.addEdge(4, 8);
        g.addEdge(2, 6);
        g.addEdge(6, 7);
        g.actualDFS(1, 0, 0);

        System.out.println(g.getLCAOf(5, 8));
        System.out.println(g.getLCAOf(1, 3));
        System.out.println(g.getLCAOf(2, 3));
        System.out.println(g.getLCAOf(5, 7));
        System.out.println(g.getLCAOf(4, 6));
        System.out.println(g.getLCAOf(4, 3));
    }

    int getLCAOf(int a, int b) {
        if (depthOf[a] > depthOf[b]) {
            return getLCAOf(b, a);
        } else {
            int diff = depthOf[b] - depthOf[a];
            while (diff > 0) {
                b = parentOf[b];
                diff--;
            }

            if (a == b)
                return a;

            while (parentOf[a] != parentOf[b]) {
                a = parentOf[a];
                b = parentOf[b];
            }

            return parentOf[a];
        }
    }

}