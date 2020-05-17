import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    int noOfNodes;
    HashMap<Integer,ArrayList<Integer>> adjList=new HashMap<>();
    boolean isVisited[];

    public Graph(int n){
        this.noOfNodes=n;
        isVisited=new boolean[n];
    }

    public void addEdge(int x, int y) {
        ArrayList<Integer> list1=adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);  

        ArrayList<Integer> list2=adjList.getOrDefault(y, new ArrayList<Integer>());
        list2.add(x);
        adjList.put(y, list2);
    }

    private void actualDFS(int src) {
        System.out.print(src+",");
        isVisited[src]=true;
        ArrayList<Integer> neighbours=adjList.getOrDefault(src,new ArrayList<>());
        for(Integer neighbour:neighbours){
            if(!isVisited[neighbour]){
                actualDFS(neighbour);
            }
        }
    }


    public void bfsTraversal(Integer src){
        ArrayList<Integer> queue=new ArrayList<>();
        HashMap<Integer,Boolean> isVisited=new HashMap<>();
        for(Integer vertex:adjList.keySet()){
            isVisited.put(vertex,false);
        }
        int verticesVisited=0;
        queue.add(src);
        isVisited.put(src, true);
        while(verticesVisited!=noOfNodes){
            ArrayList<Integer> neighbors=adjList.get(queue.get(0));
            for(Integer neighbor:neighbors){
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


    HashMap<Integer, ArrayList<Pair>> adjListWeighted=new HashMap<>();
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
}