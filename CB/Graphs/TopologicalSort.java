// given a directed graph, print the topological sort order
// i.e an order such that, when a node is encountered, all its dependencies have
// already been encountered

import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];
    ArrayList<Integer> topologicalList=new ArrayList<>();

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1 = adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);
    }

    private void actualDFS(int src) {
        System.out.print(src + ",");
        isVisited[src] = true;
        ArrayList<Integer> neighbours = adjList.getOrDefault(src, new ArrayList<>());
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                actualDFS(neighbour);
            }
        }
        topologicalList.add(0, src);
    }
    private void printTopologicalOrder(){
        for(int i=1;i<noOfNodes;i++){
            if(!isVisited[i]){
                // System.out.println("starting dfs from:"+i);
                actualDFS(i);
            }
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(10);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(8, 9);
        g.addEdge(7, 9);
        g.printTopologicalOrder();
        System.out.println(g.topologicalList);
    }
}