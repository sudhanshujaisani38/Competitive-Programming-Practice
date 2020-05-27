
//Algo to get shortest from every node to every other node
//can detect negative cycles too
//works in O(v^3)
import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Pair>> adjListWeighted = new HashMap<>();
    int dist[][];

    public Graph(int n) {
        this.noOfNodes = n;
        dist=new int[n][n];
        for (int i = 0; i < n; i++) {
            adjListWeighted.put(i, new ArrayList<Pair>());
        }
    }

    public void addEdge(int x, int y,int cost) {
        adjListWeighted.get(x).add(new Pair(y,cost));
        adjListWeighted.get(y).add(new Pair(x, cost));
    }
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 1);
        g.addEdge(4, 2, 1);
        g.addEdge(4, 3, 2);
        g.floydWarshall();
        for(int i=1;i<g.noOfNodes;i++){
            for(int j=1;j<g.noOfNodes;j++){
                System.out.print(g.dist[i][j]+" ");
            }
            System.out.println();
        }
    }

    //fills up the dist matrix with shortest paths 
    private void floydWarshall() {
        for(int i=0;i<noOfNodes;i++){
            for(int j=0;j<noOfNodes;j++){
                dist[i][j]=1000000;//infinity
            }
        }
        //fill up the directly connected edges first and dist of a vertex to self=0.
        for(int i=1;i<noOfNodes;i++){
            dist[i][i]=0;
            for(Pair weightedEdge:adjListWeighted.get(i)){
                dist[i][weightedEdge.dest]=weightedEdge.cost;
            }
        }
        for(int k=1;k<noOfNodes;k++){
            for(int i=1;i<noOfNodes;i++){
                for(int j=1;j<noOfNodes;j++){
                    dist[i][j]=Math.min(dist[i][j],(dist[i][k]+dist[k][j]));
                }
            }
        }
    }

    static class Pair {
        int dest;
        int cost;

        public Pair(int d, int c) {
            dest = d;
            cost = c;
        }
    }
}