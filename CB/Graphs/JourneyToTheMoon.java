import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//problem- Journey to the moon HackerRank
class ConnectedComponentsGraph {
    int noOfVertices;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    public ConnectedComponentsGraph(int n) {
        this.noOfVertices = n;
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
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int edges=sc.nextInt();
        ConnectedComponentsGraph graph=new ConnectedComponentsGraph(n);
        for(int i=0;i<edges;i++){
            int first=sc.nextInt();
            int sec=sc.nextInt();
            graph.addEdge(first, sec);
        }
        graph.printConnectedComponents();
    }

    private void printConnectedComponents() {
        long ans=solveNC2(noOfVertices);
        boolean isVisited[]=new boolean[noOfVertices];
        int componentCount=0;
        for(int i=0;i<noOfVertices;i++){
            if(!isVisited[i]){
                componentCount++;
                int count=actualDFS(i,isVisited);
                ans-=solveNC2(count);
            }
        }
        System.out.println(ans);
    }

    private long solveNC2(long n){
        return (n*(n-1))/2;
    }

    private int actualDFS(int src, boolean[] isVisited) {
        int count=1;
        isVisited[src]=true;
        ArrayList<Integer> neighbours=adjList.getOrDefault(src, new ArrayList<>());
        for(Integer neighbour:neighbours){
            if(!isVisited[neighbour]){
                count+=actualDFS(neighbour, isVisited);
            }
        }
        return count;
    }

}