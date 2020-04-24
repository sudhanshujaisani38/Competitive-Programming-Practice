import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class APLONG20_7{

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
    static int cost[];
    public static final int MOD=1_000_000_007;

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                ArrayList<Integer> tree[]=new ArrayList[n+1];
                for(int i=1;i<=n;i++){
                    tree[i]=new ArrayList<>();
                }
                ArrayList<Integer> stack=new ArrayList<>();
                for(int i=0;i<(n-1);i++){
                    int first=fastReader.nextInt();
                    int sec=fastReader.nextInt();
                    addEdge(tree,first,sec);
                }
                cost=new int[n+1];
                for(int i=1;i<=n;i++){
                    cost[i]=fastReader.nextInt();
                }
                int q=fastReader.nextInt();
                for(int i=0;i<q;i++){
                    int first=fastReader.nextInt();
                    int sec=fastReader.nextInt();
                    DFSCall(first, sec, tree, n, stack);
                    stack.clear();
                }
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static long noOfFactors(long num){
        long noOfFactors=0;
        double sq=Math.sqrt(num);
        for(long i=1;i<=sq;i++){
            if(num%i==0){
                if(i!=(num/i)){
                    noOfFactors+=2;
                }else{
                    noOfFactors++;
                }
            }
        }
        return noOfFactors;
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
    static void addEdge(ArrayList<Integer> v[],  int x,  int y)
    {

        v[x].add(y);
        v[y].add(x);
    }

    static void  printPath(ArrayList<Integer> stack)
    {
        long prod=1;
        int i;
        for (i = 0; i < stack.size() - 1; i++) {
            prod=prod*cost[stack.get(i)];
//            out.print(stack.get(i)+"->");
        }
//        out.println(stack.get(i));
        prod=prod*stack.get(i);
        sb.append(noOfFactors(prod)+"\n");
    }

    static void DFS(ArrayList<Integer> v[],boolean vis[],int x,int y,ArrayList<Integer> stack)
    {
        stack.add(x);
        if (x == y) {
            printPath(stack);
            return;
        }
        vis[x] = true;
        int flag = 0;
        if (!v[x].isEmpty()) {
            for (int j = 0; j < v[x].size(); j++) {
                if (vis[v[x].get(j)] == false) {
                    DFS(v, vis, v[x].get(j), y, stack);
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            stack.remove(stack.size()-1);
        }
    }
    static void DFSCall(int x, int y, ArrayList<Integer> v[],int n,ArrayList<Integer> stack)
    {
        boolean vis[]=new boolean[n + 1];
        DFS(v, vis, x, y, stack);
    }
}