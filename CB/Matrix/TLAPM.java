//https://www.codechef.com/COOK129B/problems/TLAPM
import java.io.*;
import java.util.*;

class Main {
    public static final int MAX_SIZE = 1000;
    static void redirectIO() {
        try {
            final String INPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/input.txt";
            final String OUTPUT_FILE = "C:/Users/sudhanshu.jaisani/Documents/books/Competitive-Programming-Practice/output.txt";
            System.setOut(new PrintStream(new File(OUTPUT_FILE)));
            File inputFile = new File(INPUT_FILE);
            inputFile.createNewFile();
            System.setIn(new FileInputStream(inputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        redirectIO();
        FastReader fastReader = new FastReader();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer stringBuffer = new StringBuffer();
        try {                     
            long mat[][] = new long [MAX_SIZE][MAX_SIZE];
            long rowStart = 0;
            long colStart =1;
            mat[0][0]=1;
            //prepare the matrix
            for(int i =0;i<MAX_SIZE;i++){
                rowStart = colStart;
                if(i!=0)
                mat[i][0] = mat[i-1][0]+colStart;
                for(int j =1;j<MAX_SIZE;j++){                    
                    mat[i][j] = mat[i][j-1]+rowStart;
                    rowStart++;
                }
                colStart++;
            }
                        
            long rowSum[][] = new long[MAX_SIZE][MAX_SIZE]; //this matrix stores the prefix sum along the row for each cell
            long colSum[][] = new long[MAX_SIZE][MAX_SIZE]; //this matrix stores the prefix sum along the column for each cell
            
            //populate rowSum and colSum for first row and column
            for(int i=1;i<MAX_SIZE;i++){               
                colSum[i][0] = colSum[i-1][0]+mat[i][0];
                rowSum[i][0] = mat[i][0];
                rowSum[0][i] = rowSum[0][i-1]+mat[0][i];
                colSum[0][i] = mat[0][i];
            }

            //populate rowSum and colSum for the rest of the cells
            for(int i =1;i<MAX_SIZE;i++){
                for (int j=1;j<MAX_SIZE;j++){
                   rowSum[i][j] = rowSum[i][j-1]+mat[i][j];
                   colSum[i][j] = colSum[i-1][j]+mat[i][j];
                }
            }
            int testCases = fastReader.nextInt();   
            while (testCases-- > 0) {
                int x1 = fastReader.nextInt();
                int y1 = fastReader.nextInt();
                int x2 = fastReader.nextInt();
                int y2 = fastReader.nextInt();
                x1--;y1--;x2--;y2--;
                long ans = (colSum[x2][y1]-colSum[x1][y1])+(rowSum[x2][y2]-rowSum[x2][y1])+mat[x1][y1];
                System.out.println(ans);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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