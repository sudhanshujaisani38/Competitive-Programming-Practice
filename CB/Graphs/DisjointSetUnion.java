//find cycles in an undirected graph using Disjoint Set Union
import java.util.Scanner;

class DSU {
    int noOfNodes;
    int parent[];

    public DSU(int n) {
        this.noOfNodes = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int getSuperParentOf(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = getSuperParentOf(parent[x]);
            return parent[x];
        }
    }

    private void performUnion(int x, int y) {
        int px = getSuperParentOf(x);
        int py = getSuperParentOf(y);
        if (px != py) {
            // only perform union only when they are not already united
            parent[px] = py;
        }
    }

    private boolean isCyclePresent(int edges[][]){
        for(int i=0;i<edges.length;i++){
            if(getSuperParentOf(edges[i][0])==getSuperParentOf(edges[i][1])){
                return true;
            }else{
                performUnion(edges[i][0], edges[i][1]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int noOfEdges=sc.nextInt();
        int edges[][]=new int[noOfEdges][2];
        DSU dsu=new DSU(n);
        for(int i=0;i<noOfEdges;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        if(dsu.isCyclePresent(edges)){
            System.out.println("Cycle is present!");
        }else{
            System.out.println("No cycles in the graph!");
        }
    }
}