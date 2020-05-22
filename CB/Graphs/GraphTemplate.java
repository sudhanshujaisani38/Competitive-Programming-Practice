import java.util.ArrayList;
import java.util.HashMap;

class Graph<T> {
    int noOfNodes;
    HashMap<T, ArrayList<T>> adjList = new HashMap<>();
    HashMap<T,Boolean> isVisited=new HashMap<>();

    public Graph(int n) {
        this.noOfNodes = n;
    }

    public void addEdge(T x, T y) {
        adjList.get(x).add(y);
        adjList.get(y).add(x);
    }

    private void actualDFS(T src) {
        System.out.print(src + ",");
        isVisited.put(src,true);
        ArrayList<T> neighbours = adjList.getOrDefault(src,new ArrayList<>());
        for (T neighbour : neighbours) {
            if (!isVisited.getOrDefault(neighbour, false)) {
                actualDFS(neighbour);
            }
        }
    }

    public void bfsTraversal(T src) {
        ArrayList<T> queue = new ArrayList<>();
        queue.add(src);
        isVisited.put(src, true);
        while (!queue.isEmpty()) {
            ArrayList<T> neighbors = adjList.getOrDefault(queue.get(0),new ArrayList<>());
            for (T neighbor : neighbors) {
                if (!isVisited.get(neighbor)) {
                    queue.add(neighbor);
                    isVisited.put(neighbor, true);
                }
            }
            System.out.print(queue.remove(0) + ",");
        }
        System.out.println();
    }

    HashMap<T, ArrayList<Pair>> adjListWeighted = new HashMap<>();

    public void addWeightedEdge(T x, T y, int cost) {
        ArrayList<Pair> list1 = adjListWeighted.getOrDefault(x, new ArrayList<Pair>());
        list1.add(new Pair(y, cost));
        adjListWeighted.put(x, list1);
        ArrayList<Pair> list2 = adjListWeighted.getOrDefault(y, new ArrayList<Pair>());
        list2.add(new Pair(x, cost));
        adjListWeighted.put(y, list2);
    }

    class Pair implements Comparable<Pair>{
        T dest;
        int cost;

        public Pair(T d, int c) {
            dest = d;
            cost = c;
        }

        @Override
        public int compareTo(Graph<T>.Pair o) {
            return this.cost-o.cost;
        }
        
    }
}