import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];
    int inDegree[];
    ArrayList<Integer> queue;
    ArrayList<Integer> topologicalOrder;

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        inDegree=new int[n];
        queue=new ArrayList<>();
        topologicalOrder=new ArrayList<>();
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1 = adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);

    }
    private void fillInDegrees(){
        for(Integer src:adjList.keySet()){
            for(Integer nbr:adjList.get(src)){
                inDegree[nbr]++;
            }
        }
        for(int i=0;i<noOfNodes;i++){
            if(inDegree[i]==0 && !isVisited[i]){
                bfsTraversal(i);
            }
        }
    }

    public void bfsTraversal(Integer src) { 
        isVisited[src]=true;
        queue.add(src);
        while (!queue.isEmpty()) {
            ArrayList<Integer> neighbors = adjList.getOrDefault(queue.get(0),new ArrayList<>());
            for (Integer neighbor : neighbors) {
                if (!isVisited[neighbor]) {
                    inDegree[neighbor]--;
                    if(inDegree[neighbor]==0){
                        queue.add(neighbor);
                        isVisited[neighbor]=true;
                    }
                }
            }
            // System.out.println(queue);
            topologicalOrder.add(queue.remove(0));
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(2,5);
        g.addEdge(2,4);
        g.addEdge(5,4);
        g.fillInDegrees();
        System.out.println(g.topologicalOrder);

    }
}