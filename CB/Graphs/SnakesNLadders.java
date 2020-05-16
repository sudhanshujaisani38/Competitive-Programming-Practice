import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class SnakesNLadders {
    static HashMap<Integer,ArrayList<Integer>> adjList=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int noOfJumps=sc.nextInt();
            int jump[]=new int[31];
            for(int i=0;i<noOfJumps;i++){
                int first=sc.nextInt();
                int sec=sc.nextInt();
                jump[first]=sec-first;
            }
            for(int i=1;i<=30;i++){
                for(int j=1;j<=6;j++){
                    if(i+j<=30)
                    addEdge(i, i+j+jump[i+j]);
                }
            }
            if(jump[1]==29){
                System.out.println(0);
                continue;
            }
            singleSrcShortestPath(1,30);
        }
    }
    
    private static void singleSrcShortestPath(int src, int dest) {
        boolean isVisited[]=new boolean[31];
        ArrayList<Integer>queue=new ArrayList<>();
        int dist[]=new int[31];
        int parent[]=new int[31];
        queue.add(src);
        dist[src]=0;
        parent[src]=src;
        while(queue.size()>0){
            ArrayList<Integer> neighbors=adjList.getOrDefault(queue.get(0), new ArrayList<Integer>());
            for(Integer neighbor:neighbors){
                if(!isVisited[neighbor]){
                    dist[neighbor]=dist[queue.get(0)]+1;
                    parent[neighbor]=queue.get(0);
                    isVisited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
            queue.remove(0);
        }
        System.out.println(dist[dest]);
        int tempDest=dest;
    }

    public static void addEdge(int x, int y) {
        ArrayList<Integer> list1=adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);  
    }
}