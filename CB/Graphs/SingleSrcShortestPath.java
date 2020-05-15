import java.util.ArrayList;
import java.util.HashMap;

class SingleSrcShortestPath{
    int noOfVertices;
    HashMap<Integer,ArrayList<Integer>> adjList=new HashMap<>();
    public SingleSrcShortestPath(int n){
        this.noOfVertices=n;
    }

    public void printShortestPathsFrom(int src){
        System.out.println(adjList);
        boolean isVisited[]=new boolean[noOfVertices];
        ArrayList<Integer> queue=new ArrayList<>();
        int dist[]=new int[noOfVertices];
        dist[src]=0;
        queue.add(src);
        int noOfVerticesVisited=1;
        while(noOfVerticesVisited!=noOfVertices){
            ArrayList<Integer>neighbours=adjList.get(queue.get(0));
            for(Integer neighbour:neighbours){
                if(!isVisited[neighbour]){
                    queue.add(neighbour);
                    isVisited[neighbour]=true;
                    dist[neighbour]=dist[queue.get(0)]+1;
                    noOfVerticesVisited++;
                }
            }
            isVisited[queue.get(0)]=true;
            queue.remove(0);
        }

        for(int i=0;i<dist.length;i++){
            System.out.println("Dist to:"+i+"="+dist[i]);
        }
        

    }
    public void addEdge(int x, int y){
        ArrayList<Integer> list1=adjList.getOrDefault(x, new ArrayList<Integer>());
        list1.add(y);
        adjList.put(x, list1);  

        ArrayList<Integer> list2=adjList.getOrDefault(y, new ArrayList<Integer>());
        list2.add(x);
        adjList.put(y, list2);
    }

    public static void main(String[] args) {
        SingleSrcShortestPath graph=new SingleSrcShortestPath(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.printShortestPathsFrom(0);
        
    }
}