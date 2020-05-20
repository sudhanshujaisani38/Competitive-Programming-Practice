
//Kosaraju's Algorithm
import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> revAdjList = new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> stronglyConnectedComponents=new HashMap<>();
    ArrayList<Integer> orderVector;
    boolean isVisited[];

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        orderVector=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<Integer>());
            revAdjList.put(i,new ArrayList<Integer>());
        }
    }

    public void addEdge(int x, int y) {
        adjList.get(x).add(y);
        revAdjList.get(y).add(x);
    }

    private void actualDFS(int src) {
        System.out.print(src + ",");
        isVisited[src] = true;
        ArrayList<Integer> neighbours = adjList.get(src);
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                actualDFS(neighbour);
            }
        }
        orderVector.add(src);
    }

    //this function starts dfs on reverse of the graph
    //and before returning, puts source in strongly connected component no
    private void actualDFS2(int src,int componentNo) {
        System.out.print(src + ",");
        isVisited[src] = true;
        ArrayList<Integer> neighbours = revAdjList.get(src);
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                actualDFS2(neighbour,componentNo);
            }
        }
        stronglyConnectedComponents.get(componentNo).add(src);
        
    }

    //this function first performs a normal dfs and fills up the order vector
    //then resets isVisited to not visited for every node
    //then starts dfs on reverse graph starting from end of the order vector
    private void findStronglyConnectedComponents(){
        for(int i=1;i<noOfNodes;i++){
            if(!isVisited[i]){
                actualDFS(i);
            }
        }
        System.out.println();
        for(int i=0;i<noOfNodes;i++){
            isVisited[i]=false;
        }
        int componentNo=1;
        for(int i=orderVector.size()-1;i>=1;i--){
            if(!isVisited[orderVector.get(i)]){
                stronglyConnectedComponents.put(componentNo,new ArrayList<>());
                actualDFS2(orderVector.get(i),componentNo);
                componentNo++;
            }
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.findStronglyConnectedComponents();
        System.out.println(g.stronglyConnectedComponents);
    }

}