import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

class Graph<T> {
    int noOfNodes;
    HashMap<T, Boolean> isVisited = new HashMap<>();

    public Graph(int n) {
        this.noOfNodes = n;
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

    class Pair implements Comparable<Pair> {
        T dest;
        int cost;

        public Pair(T d, int c) {
            dest = d;
            cost = c;
        }

        @Override
        public int compareTo(Graph<T>.Pair o) {

            int ans;
            int costDiff = this.cost - o.cost;
            if (costDiff == 0) {
                if (this.dest.equals(o.dest)) {
                    ans = 0;
                } else {
                    ans = 1;
                }
            } else {
                ans = costDiff;
            }
            // System.out.println("compare to check for "+this+" and "+o+" ans:"+ans);
            return ans;
        }

        @Override
        public String toString() {
            return "(" + dest + "," + cost + ")";
        }

        public boolean equals(Pair obj) {
            return (obj.cost == this.cost && this.dest.equals(obj.dest));
        }
    }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(6);
        g.addWeightedEdge("Amritsar", "Jaipur", 4);
        g.addWeightedEdge("Amritsar", "Delhi", 1);
        g.addWeightedEdge("Jaipur", "Delhi", 2);
        g.addWeightedEdge("Jaipur", "Mumbai", 8);
        g.addWeightedEdge("Delhi", "Agra", 1);
        g.addWeightedEdge("Agra", "Bhopal", 2);
        g.addWeightedEdge("Bhopal", "Mumbai", 3);
        // System.out.println(g.adjListWeighted);
        g.dijkstras("Amritsar");
    }

    // prints the minimum distance of all the nodes from src using dijkstra's
    // algorithm
    private void dijkstras(T src) {
        TreeSet<Pair> queue = new TreeSet<>();
        HashMap<T, Integer> nodeCost = new HashMap<>();

        // set node cost of all nodes to infinity
        for (T node : adjListWeighted.keySet()) {
            nodeCost.put(node, Integer.MAX_VALUE);
            if (!node.equals(src)) {
                queue.add(new Pair(node, Integer.MAX_VALUE));
            }

        }
        queue.add(new Pair(src, 0));
        nodeCost.put(src, 0);
        while (!queue.isEmpty()) {
            for (Pair p : adjListWeighted.get(queue.first().dest)) {
                if (queue.first().cost + p.cost < nodeCost.get(p.dest)) {
                    // System.out.println("searching "+p.dest +" in "+queue);
                    for (Pair nc : queue) {
                        if (nc.dest.equals(p.dest)) {
                            int newCost = queue.first().cost + p.cost;
                            queue.remove(nc);
                            queue.add(new Pair(nc.dest, newCost));
                            nodeCost.put(nc.dest, newCost);
                            break;
                        }
                    }
                }
            }
            queue.pollFirst();
        }

        // print the distances
        System.out.println(nodeCost);

    }
}