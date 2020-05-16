import java.util.ArrayList;
import java.util.HashMap;

class GraphDFS{
    int noOfVertices;
    HashMap<Integer,ArrayList<Integer>> adjList=new HashMap<>();
    public GraphDFS(int n){
        this.noOfVertices=n;
    }
    public static void main(String[] args) {
        GraphDFS graphDFS=new GraphDFS(15);
        graphDFS.addEdge(0,1);
        graphDFS.addEdge(0,2);
        graphDFS.addEdge(1,3);
        graphDFS.addEdge(1,4);
        graphDFS.addEdge(2,5);
        graphDFS.addEdge(2,6);
        graphDFS.addEdge(3,7);
        graphDFS.addEdge(3,8);
        graphDFS.addEdge(4,9);
        graphDFS.addEdge(4,10);
        graphDFS.addEdge(5,11);
        graphDFS.addEdge(5,12);
        graphDFS.addEdge(6,13);
        graphDFS.addEdge(6,14);
        graphDFS.dfsTraversal(0,15);
    }

    
    private void dfsTraversal(int src,int n) {
        boolean isVisited[]=new boolean[n];
        actualDFS(src,isVisited);
    }

    private void actualDFS(int src,boolean []isVisited) {
        System.out.print(src+",");
        isVisited[src]=true;
        ArrayList<Integer> neighbours=adjList.getOrDefault(src,new ArrayList<>());
        for(Integer neighbour:neighbours){
            if(!isVisited[neighbour]){
                actualDFS(neighbour, isVisited);
            }
        }
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1=adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);  

        ArrayList<Integer> list2=adjList.getOrDefault(y, new ArrayList<Integer>());
        list2.add(x);
        adjList.put(y, list2);
    }
}