import java.util.ArrayList;
import java.util.HashMap;

//given a graph, print all the articulation points in the graph.
class APGraph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];
    int minTime[];
    int discoveryTime[];
    int time = 0;

    public APGraph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        minTime = new int[n];
        discoveryTime = new int[n];
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
        APGraph graph = new APGraph(9); // giving no of nodes one extra because everything is in 1 based indexing
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        graph.addEdge(4, 8);
        graph.printAP(1, 0);
        graph.discoveryTime[0] = 0;
    }

    private void printAP(int src, int parent) {
        isVisited[src] = true;
        discoveryTime[src] = ++time;
        minTime[src] = discoveryTime[src];
        
        int noOfChild = 0;                      //no of unvisited child for this node: to handle special case of root
        
        int childMinTime = discoveryTime[src]; // this stores the minimum time any of the child of this node can get
        
        boolean flag = false;                   // this flag represents if childMinTime was actually contributed by one of the
                                                // child of current node or not


        System.out.println("on Vertex:" + src + " discovery time:" + discoveryTime[src]);
        ArrayList<Integer> neighbors = adjList.get(src);
        for (Integer n : neighbors) {
            if (!isVisited[n]) {
                noOfChild++;
                printAP(n, src);
                childMinTime = Math.min(minTime[n], childMinTime);
                flag = true;
                
                if (minTime[n] > discoveryTime[src]) {
                    System.out.println("Path between " + src + " & " + n + " is a bridge");
                }
            } else {
                // if n is already visited
                if (n != parent) {
                    childMinTime = Math.min(minTime[n], childMinTime);
                    flag = true;
                    // System.out.println("found a backedge to:"+n+" which can reach max to:"+minTime[n]);
                }
            }
        }
        minTime[src] = Math.min(discoveryTime[src], childMinTime);
        // System.out.println(src+" can reach max to "+minTime[src]);
        
        if (parent == 0) {
            // we have to handle a special case for the source of dfs
            // it will be an articulation point iff it has two unvisited child nodes
            if (noOfChild > 1) {
                System.out.println(src + " is an articulation point!(root)");
            }

        } else if (childMinTime >= discoveryTime[src] && flag) { // i.e no child of this node can reach above this node
            System.out.println(src + " is an articulation point!");
        }
    }
}