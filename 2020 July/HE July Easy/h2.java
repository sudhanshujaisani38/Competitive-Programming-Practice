import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    static {
        try {
            System.setOut(new PrintStream(new File("output.txt")));
            new File("input.txt").createNewFile();
            System.setIn(new FileInputStream(new File("input.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        try {
            int testCases = fastReader.nextInt();
            // int testCases=1;
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int m=fastReader.nextInt();
                int mat[][]=new int[n][m];
                int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
                ArrayList<Integer> rows=new ArrayList<>();
                ArrayList<Integer> cols=new ArrayList<>();
                ArrayList<Integer> rows2=new ArrayList<>();
                ArrayList<Integer> cols2=new ArrayList<>();
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        mat[i][j]=fastReader.nextInt();
                        if(mat[i][j]>max){
                            rows=new ArrayList<>();
                            cols=new ArrayList<>();
                            rows.add(i);
                            cols.add(j);
                            max=mat[i][j];
                        }
                        if(mat[i][j]==max){
                            rows.add(i);
                            cols.add(j);
                        }
                        if(mat[i][j]==min){
                            rows2.add(i);
                            cols2.add(j);
                        }
                        if(mat[i][j]<min){
                            rows2=new ArrayList<>();
                            cols2=new ArrayList<>();
                            rows2.add(i);
                            cols2.add(j);
                            min=mat[i][j];                            
                        }
                    }
                }
                HashSet<Integer>rowss=new HashSet<>();
                HashSet<Integer>colss=new HashSet<>();
                for(Integer r:rows)rowss.add(r);
                for(Integer r:rows2)rowss.add(r);
                for(Integer r:cols)colss.add(r);
                for(Integer r:cols2)colss.add(r);
                // System.out.println(rowss);
                // System.out.println(colss);
                int ans=n*m;
                ans-=rowss.size()*m;
                n-=rowss.size();
                // System.out.println("r:"+ans);
                ans-=colss.size()*n;
                System.out.println(ans);

                

                
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
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