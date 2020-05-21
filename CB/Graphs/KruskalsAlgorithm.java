import java.util.Arrays;
import java.util.Scanner;

//find the minimum spanning tree of a graph using Kruskal's Algorithm
class DSU{
    int noOfNodes;
    int parent[];
    public DSU(int n){
        this.noOfNodes=n;
        this.parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int getSuperParentOf(int x){
        if(x==parent[x]){
            return x;
        }else{
            parent[x]=getSuperParentOf(parent[x]);
            return parent[x];
        }
    }
    public void performUnion(int x,int y){
        int px=getSuperParentOf(x);
        int py=getSuperParentOf(y);
        if(px!=py){
            parent[px]=py;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int noOfEdges=sc.nextInt();
        DSU dsu=new DSU(n);
        WeightedEdge edges[]=new WeightedEdge[noOfEdges];
        for(int i=0;i<noOfEdges;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int w=sc.nextInt();
            edges[i]=new WeightedEdge(x, y, w);
        }
        Arrays.sort(edges);
        int finalWeight=0;
        for(int i=0;i<noOfEdges;i++){
            if(dsu.getSuperParentOf(edges[i].src)!=dsu.getSuperParentOf(edges[i].dest)){
                dsu.performUnion(edges[i].src, edges[i].dest);
                System.out.println("adding edge:"+edges[i]);
                finalWeight+=edges[i].weight;
            }
        }
        System.out.println(finalWeight);
        
        
        
    }
    static class WeightedEdge implements Comparable<WeightedEdge>{
        int src,dest,weight;
        public WeightedEdge(int x,int y,int w){
            src=x;
            dest=y;
            weight=w;
        }

        @Override
        public int compareTo(WeightedEdge we) {
            return this.weight-we.weight;
        }
        @Override
        public String toString() {
            return src+"-"+dest+" :"+weight;
        }
    }
}