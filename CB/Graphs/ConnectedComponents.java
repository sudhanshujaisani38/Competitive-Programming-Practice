import java.util.ArrayList;
import java.util.HashMap;

//given a graph, you have to print all the connected components of the graph
class ConnectedComponentsGraph {
    int noOfVertices;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    public ConnectedComponentsGraph(int n) {
        this.noOfVertices = n;
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1 = adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);

        ArrayList<Integer> list2 = adjList.getOrDefault(y, new ArrayList<Integer>());
        list2.add(x);
        adjList.put(y, list2);
    }

    public static void main(String[] args) {
        ConnectedComponentsGraph graph=new ConnectedComponentsGraph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        // graph.addEdge(3, 0);
        graph.addEdge(0, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.printConnectedComponents();
    }

    private void printConnectedComponents() {
        boolean isVisited[]=new boolean[noOfVertices];
        int componentCount=0;
        for(int i=0;i<noOfVertices;i++){
            if(!isVisited[i]){
                componentCount++;
                System.out.print("Component no:"+componentCount+"-->");
                actualDFS(i,isVisited);
                System.out.println();
            }
        }
    }

    private void actualDFS(int src, boolean[] isVisited) {
        isVisited[src]=true;
        System.out.print(src+",");
        ArrayList<Integer> neighbours=adjList.getOrDefault(src, new ArrayList<>());
        for(Integer neighbour:neighbours){
            if(!isVisited[neighbour]){
                actualDFS(neighbour, isVisited);
            }
        }
    }

}