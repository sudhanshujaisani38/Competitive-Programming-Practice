import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];
    boolean presentInCurrentPath[];


    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        presentInCurrentPath=new boolean[n];
        for(int i=0;i<noOfNodes;i++){
            adjList.put(i,new ArrayList<>());
        }
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1 = adjList.get(x);
        list1.add(y);
        adjList.put(x, list1);
    }

    //calls dfs in every component if there are multiple
    private boolean searchCycle(){
        for(int i=0;i<noOfNodes;i++){
            if(!isVisited[i]){
                boolean cycleMila=actualDFS(i);
                if(cycleMila){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean actualDFS(int src) {
        presentInCurrentPath[src]=true;
        isVisited[src]=true;
        System.out.print(src + ",");
        isVisited[src] = true;
        ArrayList<Integer> neighbours = adjList.get(src);
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                boolean cycleMila=actualDFS(neighbour);
                if(cycleMila)
                return true;
            }else{
                if(presentInCurrentPath[neighbour]){
                    // System.out.println("cycle between "+src+" and "+neighbour);
                    return true;
                    
                }
            }
        }
        presentInCurrentPath[src]=false;
        return false;
    }
    
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 5);
        g.addEdge(5, 6);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        if(g.searchCycle()){
            System.out.println("Found Cycle!");
        }else{
            System.out.println("No cycle!");
        }
        
    }
}