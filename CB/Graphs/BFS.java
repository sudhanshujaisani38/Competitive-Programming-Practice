import java.util.ArrayList;
import java.util.HashMap;

//given a source node, print the bfs traversal order of the graph
class Graph{
    int noOfVertices;
    HashMap<String,ArrayList<String>> adjList=new HashMap<>();

    public int getNoOfVertices() {
        return this.noOfVertices;
    }

    public void setNoOfVertices(int noOfVertices) {
        this.noOfVertices = noOfVertices;
    }

    public Graph(int n) {
        this.noOfVertices=n;
    }

    public void bfsTraversal(String src){
        ArrayList<String> queue=new ArrayList<>();
        HashMap<String,Boolean> isVisited=new HashMap<>();
        for(String vertex:adjList.keySet()){
            isVisited.put(vertex,false);
        }
        int verticesVisited=0;
        queue.add(src);
        isVisited.put(src, true);
        while(verticesVisited!=noOfVertices){
            ArrayList<String> neighbors=adjList.get(queue.get(0));
            for(String neighbor:neighbors){
                if(!isVisited.get(neighbor)){
                    queue.add(neighbor);
                    isVisited.put(neighbor, true);
                }
            }
            System.out.print(queue.remove(0)+",");
            verticesVisited++;
        }
        System.out.println();
    }

    public void addEdge(String x, String y){
        ArrayList<String> list1=adjList.getOrDefault(x, new ArrayList<String>());
        list1.add(y);
        adjList.put(x, list1);  

        ArrayList<String> list2=adjList.getOrDefault(y, new ArrayList<String>());
        list2.add(x);
        adjList.put(y, list2);
    }
    public static void main(String[] args) {
        Graph graph=new Graph(6);
        graph.addEdge("0", "1");
        graph.addEdge("1", "2");
        graph.addEdge("0", "3");
        graph.addEdge("3", "1");
        graph.addEdge("3", "4");
        graph.addEdge("4", "5");
        graph.bfsTraversal("0");
        
    }



}