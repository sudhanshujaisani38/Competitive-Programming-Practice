import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class JAN_LT20{

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int adjacency_matrix[][];
                int source = 0, destination = 0;
                int n=fastReader.nextInt();
                int k=fastReader.nextInt();
                Graph graph=new Graph(n);
                adjacency_matrix = new int[n][n];
                for(int i=0;i<n;i++){
                    String s=fastReader.next();
                    int back=Math.max(0,i-k);
                    int front=Math.min(n-1,i+k);
//                    out.println("from"+front+" to "+back);
                    for(int j=1;j<=k;j++){

                        if((i+j)<=front && s.charAt(i+j)=='1'){
                            graph.addEdge(i,i+j);
                            addToMatrix(adjacency_matrix,i,i+j,1);
                        }
                        if((i-j)>=back && s.charAt(i-j)=='1'){
                            graph.addEdge(i,i-j);
                            addToMatrix(adjacency_matrix,i,i-j,1);
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(adjacency_matrix[i][j]==1){
//                            out.print(adjacency_matrix[i][j]+" ");
                            continue;
                        }else{
                            addToMatrix(adjacency_matrix,i,j,0);
//                            out.print(adjacency_matrix[i][j]+" ");
                        }
                    }
//                    out.println();
                }
                source=0;
                destination=n-1;
                Dijkstras_Shortest_Path dijkstrasAlgorithm = new Dijkstras_Shortest_Path(n);
                dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
                if(dijkstrasAlgorithm.distances[destination]== Integer.MAX_VALUE)
                    dijkstrasAlgorithm.distances[destination]=-1;
//                System.out.println("The Shorted Path from " + source + " to " + destination + " is: "+dijkstrasAlgorithm.distances[destination]);
                sb.append(dijkstrasAlgorithm.distances[destination]).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        public int nextInt() {
            return parseInt(next());
        }

        public long nextLong() {
            return parseLong(next());
        }

        public double nextDouble() {
            return parseDouble(next());
        }
    }
    static void addToMatrix(int adjacency_matrix[][],int i,int j,int val){
        adjacency_matrix[i][j] = val;
        if (i == j)
        {
            adjacency_matrix[i][j] = 0;
            return;
        }
        if (adjacency_matrix[i][j] == 0)
        {
            adjacency_matrix[i][j] = Integer.MAX_VALUE;
        }
    }
    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            if(v!=w)
            adj[v].add(w);
//            out.println("adding edge:"+v+" to "+w);
        }
    }
    static class Dijkstras_Shortest_Path
    {
        private int          distances[];
        private Set<Integer> settled;
        private Set<Integer> unsettled;
        private int          number_of_nodes;
        private int          adjacencyMatrix[][];

        public Dijkstras_Shortest_Path(int number_of_nodes)
        {
            this.number_of_nodes = number_of_nodes;
            distances = new int[number_of_nodes ];
            settled = new HashSet<Integer>();
            unsettled = new HashSet<Integer>();
            adjacencyMatrix = new int[number_of_nodes ][number_of_nodes ];
        }

        public void dijkstra_algorithm(int adjacency_matrix[][], int source)
        {
            int evaluationNode;
            for (int i = 0; i < number_of_nodes; i++)
                for (int j = 0; j < number_of_nodes; j++)
                    adjacencyMatrix[i][j] = adjacency_matrix[i][j];

            for (int i = 0; i < number_of_nodes; i++)
            {
                distances[i] = Integer.MAX_VALUE;
            }

            unsettled.add(source);
            distances[source] = 0;
            while (!unsettled.isEmpty())
            {
                evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
                unsettled.remove(evaluationNode);
                settled.add(evaluationNode);
                evaluateNeighbours(evaluationNode);
            }
        }

        private int getNodeWithMinimumDistanceFromUnsettled()
        {
            int min;
            int node = 0;

            Iterator<Integer> iterator = unsettled.iterator();
            node = iterator.next();
            min = distances[node];
            for (int i = 0; i < distances.length; i++)
            {
                if (unsettled.contains(i))
                {
                    if (distances[i] <= min)
                    {
                        min = distances[i];
                        node = i;
                    }
                }
            }
            return node;
        }

        private void evaluateNeighbours(int evaluationNode)
        {
            int edgeDistance = -1;
            int newDistance = -1;

            for (int destinationNode = 0; destinationNode < number_of_nodes; destinationNode++)
            {
                if (!settled.contains(destinationNode))
                {
                    if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                    {
                        edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                        newDistance = distances[evaluationNode] + edgeDistance;
                        if (newDistance < distances[destinationNode])
                        {
                            distances[destinationNode] = newDistance;
                        }
                        unsettled.add(destinationNode);
                    }
                }
            }
        }
    }
}