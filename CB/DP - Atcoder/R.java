
/**
 * There is a simple directed graph G with N vertices, numbered 1 to N .
 * 
 * For each i and j ( 1 ≤ i , j ≤ N ), you are given an integer a[i][j] that
 * represents whether there is a directed edge from Vertex i to j . If a [i][j]
 * =1 , there is a directed edge from Vertex i to j ; if a[i][j] = 0 , there is
 * not.
 * 
 * Find the number of different directed paths of length K in G , modulo 10^9 +
 * 7 . We will also count a path that traverses the same edge multiple times.
 * 
 * 1 ≤ N ≤ 50 
 * 1 ≤ K ≤ 10^18
 * 
 * TODO: app explanation for the solution
 */
import java.io.*;
import java.util.*;

public class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();
    public static final int MOD = 1000_000_007;

    public static void main(String[] args) throws Exception {
        try {
            int n=fastReader.nextInt();
            long k=fastReader.nextLong();
            long adj[][]=new long[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j] = fastReader.nextInt();
                }
            }
            long ans = solve(n,k,adj);
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long solve(int n, long k, long[][] adj) {
        long [][] ak = power(adj,n,k);
        long ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans = (ans+ak[i][j]%MOD)%MOD;
            }
        }
        return ans;
    }

    private static long[][] power(long[][] mat, int size, long pow) {
        if(pow==1){
            return mat;
        }
        long [][]res = power(mat,size,pow/2);
        long [][]finalres = multiply(res,res);
        if(pow%2==0){
            return finalres;
        }else{
            return multiply(finalres,mat);
        }
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long res[][]=new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int x = 0;x<n;x++){
                    res[i][j] = (res[i][j]%MOD+(a[i][x]*b[x][j])%MOD)%MOD;
                }
            }
        }
        return res;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}