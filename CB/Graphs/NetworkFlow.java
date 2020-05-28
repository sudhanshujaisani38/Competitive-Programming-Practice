
// given a network, having some nodes, links between them and the capacity of
// each link, find the maximum amount of data a particular sink can receive at
// any moment from a particular source
import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Pair>> adjListWeighted = new HashMap<>();

    public Graph(int n) {
        this.noOfNodes = n;
        for(int i=0;i<noOfNodes;i++){
            adjListWeighted.put(i,new ArrayList<Pair>());
        }
    }

    public void addWeightedEdge(int x, int y, int cost) {
        adjListWeighted.get(x).add(new Pair(y, cost));
        adjListWeighted.get(y).add(new Pair(x, 0));
    }


    public boolean augmentedPathExists(int src,int sink,int residualCapacity[][],int parentOf[]) {
        ArrayList<Integer> queue = new ArrayList<>();
        boolean isVisited[]=new boolean[noOfNodes];
        queue.add(src);
        isVisited[src]=true;
        while (!queue.isEmpty()) {
            int currentNode=queue.get(0);
            ArrayList<Pair> neighbors = adjListWeighted.get(currentNode);
            for (Pair neighbor : neighbors) {
                if (!isVisited[neighbor.dest] && residualCapacity[currentNode][neighbor.dest]>0) {
                    queue.add(neighbor.dest);
                    isVisited[neighbor.dest]=true;
                    parentOf[neighbor.dest]=currentNode;
                    if(neighbor.dest==sink){
                        return true;
                    }
                }
            }
            queue.remove(0);
        }
        return false;
    }

    public int maxFlow(int src, int sink){
        int maxFlow=0;
        int residualCapacities[][]=new int[noOfNodes][noOfNodes];
        //initialize the residual capacities with max capacities,others will remain zero
        for(Integer node:adjListWeighted.keySet()){
            for(Pair pair:adjListWeighted.get(node)){
                residualCapacities[node][pair.dest]=pair.cost;
            }
        }
        int parentOf[]=new int[noOfNodes];
        int flow;
        while(augmentedPathExists(src, sink, residualCapacities, parentOf)){
            flow=Integer.MAX_VALUE;
            System.out.print("Augmented path:");
            int node=sink;
            while(node!=src){
                System.out.print(node+"<-");
                int prevNode=parentOf[node];
                if(residualCapacities[prevNode][node]<flow){
                    flow=residualCapacities[prevNode][node];
                }
                node=parentOf[node];
            }
            System.out.println(src);
            node=sink;
            while(node!=src){
                int prevNode=parentOf[node];
                residualCapacities[prevNode][node]-=flow;
                residualCapacities[node][prevNode]+=flow;
                node=parentOf[node];
            }
            maxFlow+=flow;
        }
        return maxFlow;
    }
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addWeightedEdge(0, 2, 100);
        g.addWeightedEdge(0, 3, 50);
        g.addWeightedEdge(2, 1, 50);
        g.addWeightedEdge(2, 3, 50);
        g.addWeightedEdge(2, 4, 50);
        g.addWeightedEdge(3, 4, 100);
        g.addWeightedEdge(4, 1, 125);
        System.out.println("max flow:"+g.maxFlow(0, 1));
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