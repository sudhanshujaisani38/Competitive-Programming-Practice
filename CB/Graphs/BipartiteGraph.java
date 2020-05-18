// given a graph, tell if it is bipartite graph or not
// A bipartite graph is the one that can be represented in the form of 2 sets,
// such that there is no edge between two elements in the same set , i.e
// adjacent vertices are in different set

//Approach: just check if there is a cycle of odd length

import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    boolean isVisited[];
    int color[];

    public Graph(int n) {
        this.noOfNodes = n;
        isVisited = new boolean[n];
        color=new int[n];
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1 = adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);
        ArrayList<Integer> list2 = adjList.getOrDefault(y, new ArrayList<Integer>());
        list2.add(x);
        adjList.put(y, list2);
    }

    private boolean actualDFS(int src,int parent,int c) {
        System.out.print(src + "("+c+"),");
        isVisited[src] = true;
        color[src]=c;
        ArrayList<Integer> neighbours = adjList.getOrDefault(src, new ArrayList<>());
        for (Integer neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                boolean oddCycleMila=actualDFS(neighbour,src,3-c);
                if(oddCycleMila){
                    return true;
                }
            }else{
                if(neighbour!=parent){
                    if(color[src]==color[neighbour]){
                        System.out.println("odd cycle from "+src+" to "+neighbour);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 0);
        if(g.actualDFS(0, -1, 1)){
            System.out.println("Bipartite!");
        }else{
            System.out.println("Not bipartite!");
        }
        

    }
}