import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1 = adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);
        ArrayList<Integer> list2 = adjList.getOrDefault(y, new ArrayList<Integer>());
        list2.add(x);
        adjList.put(y, list2);
    }

    private boolean actualDFS(int src,int parent) {
        System.out.print(src +",");
        isVisited[src] = true;
        ArrayList<Integer> neighbours = adjList.getOrDefault(src, new ArrayList<>());
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                boolean cycleFound=actualDFS(neighbour,src);
                if(cycleFound){
                    return true;
                }
            }else{
                if(neighbour!=parent){
                    System.out.println();
                    System.out.println("cycle found between:"+src+" to "+neighbour);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(9); // giving no of nodes one extra because everything is in 1 based indexing
        graph.addEdge(1, 2);
        // graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        graph.addEdge(4, 8);
        graph.actualDFS(1, 0);
    }

}