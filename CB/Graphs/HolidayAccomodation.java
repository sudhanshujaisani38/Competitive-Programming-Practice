import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    static HashMap<Integer, ArrayList<Pair>> adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            adjList = new HashMap<>();
            for (int i = 0; i < (n - 1); i++) {
                int first = sc.nextInt();
                int sec = sc.nextInt();
                int cost = sc.nextInt();
                addEdge(first, sec, cost);
            }
            long ans[]=new long[1];
            dfsHelper(n,ans);
            System.out.println(ans[0]);
        }
    }

    private static void dfsHelper(int n,long ans[]) {
        boolean isVisited[]=new boolean[n+1];
        actualDFS(1,isVisited,ans);
    }

    private static int actualDFS(int src, boolean[] isVisited,long ans[]) {
        int count=1;
        isVisited[src]=true;
        ArrayList<Pair>neighbours=adjList.get(src);
        for(Pair n:neighbours){
            if(!isVisited[n.dest]){
                // System.out.println("evaluating edge between:"+src+" and "+n.dest);
                int side1=actualDFS(n.dest, isVisited,ans);
                int side2=isVisited.length-1-side1;
                int contribution=2*Math.min(side1,side2)*n.cost;
                // System.out.println("Contribution of edge between "+src+" and "+n.dest+":"+contribution);
                ans[0]+=contribution;
                count+=side1;
            }
        }
        return count;
    }

    public static void addEdge(int x, int y, int cost) {
        ArrayList<Pair> list1 = adjList.getOrDefault(x, new ArrayList<Pair>());
        list1.add(new Pair(y, cost));
        adjList.put(x, list1);

        ArrayList<Pair> list2 = adjList.getOrDefault(y, new ArrayList<Pair>());
        list2.add(new Pair(x, cost));
        adjList.put(y, list2);
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