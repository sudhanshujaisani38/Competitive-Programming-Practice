
//find the minimum spanning tree of a graph using Prim's algorithm
import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    boolean isVisited[];
    int weightOfEdgeToReachVertex[];
    int parent[];
    HashMap<Integer, ArrayList<Pair>> adjListWeighted = new HashMap<>();

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        weightOfEdgeToReachVertex=new int[n];
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            adjListWeighted.put(i, new ArrayList<Pair>());
            weightOfEdgeToReachVertex[i]=Integer.MAX_VALUE;
        }
    }

    public void addWeightedEdge(int x, int y, int cost) {
        ArrayList<Pair> list1 = adjListWeighted.getOrDefault(x, new ArrayList<Pair>());
        list1.add(new Pair(y, cost));
        adjListWeighted.put(x, list1);
        ArrayList<Pair> list2 = adjListWeighted.getOrDefault(y, new ArrayList<Pair>());
        list2.add(new Pair(x, cost));
        adjListWeighted.put(y, list2);
    }

    static class Pair {
        int dest;
        int cost;

        public Pair(int d, int c) {
            dest = d;
            cost = c;
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addWeightedEdge(0, 1, 2);
        g.addWeightedEdge(1, 2, 8);
        g.addWeightedEdge(2, 3, 4);
        g.addWeightedEdge(3, 0, 6);
        g.addWeightedEdge(1, 4, 3);
        g.addWeightedEdge(4, 5, 1);
        g.addWeightedEdge(5, 6, 2);
        g.addWeightedEdge(4, 6, 4);
        g.prims();
    }

    private void prims() {
        weightOfEdgeToReachVertex[0]=0;
        parent[0]=-1;
        for(int i=0; i<noOfNodes;i++){
            int vertex=findMinVertex();
            ArrayList<Pair> neighbours=adjListWeighted.get(vertex);
            for(Pair p:neighbours){
                if(!isVisited[p.dest]){
                    if(weightOfEdgeToReachVertex[p.dest]>p.cost){
                        weightOfEdgeToReachVertex[p.dest]=p.cost;
                        parent[p.dest]=vertex;
                    }
                }
            }
            isVisited[vertex]=true;
        }
        //now print the edges of minimum spanning tree formed.
        //skip the starting point (here,0)
        for(int i=1;i<noOfNodes;i++){
            System.out.println(i+"--"+parent[i]+" weight:"+weightOfEdgeToReachVertex[i]);
        }
    }

    private int findMinVertex() {
        int minWeight=Integer.MAX_VALUE;
        int minVertex=-1;
        for(int i=0;i<noOfNodes;i++){
            if(!isVisited[i] && weightOfEdgeToReachVertex[i]<minWeight){
                minWeight=weightOfEdgeToReachVertex[i];
                minVertex=i;
            }
        }
        return minVertex;
    }
}