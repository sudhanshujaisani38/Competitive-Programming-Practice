import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Arrays;
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
                long arr[]=new long[n];
                long arr2[]=new long[n];

                Integer idx[]=new Integer[n];
                long maxNum=0l,minNum=Long.MAX_VALUE;
                int minIndex=0,maxIndex=n-1;
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextLong();
                    int pad=30-countBits(arr[i]);
                    // System.out.println("giving:"+pad+" padding to "+arr[i]);
                    arr2[i]=arr[i]<<pad;
                    idx[i]=i;
                    if(arr2[i]==minNum && arr[i]>arr[minIndex]){
                        // System.out.println(3);
                        minNum=arr2[i];
                        minIndex=i;
                    } 
                    if(arr2[i]==maxNum && arr[i]>arr[maxIndex]){
                        // System.out.println(4);
                        maxNum=arr2[i];
                        maxIndex=i;
                    }
                    if(arr2[i]<minNum){
                        // System.out.println(1);
                        minNum=arr2[i];
                        minIndex=i;
                    }
                    if(arr2[i]>maxNum){
                        // System.out.println(2);
                        maxNum=arr2[i];
                        maxIndex=i;
                    }
                    // System.out.println(minIndex+","+maxIndex);
                }
                
                if(minIndex==maxIndex){
                    Arrays.sort(arr);
                    minIndex=0;
                    maxIndex=n-1;
                }
                System.out.println(Math.max(bc(arr[maxIndex],arr[minIndex]), bc(arr[minIndex],arr[maxIndex])));
                
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static long bc(long x, long y) {
        long xy=x,yx=y;
        int bitsInY=countBits(y);
        int bitsInX=countBits(x);
        xy=x<<bitsInY;
        xy=xy|y;
        yx=y<<bitsInX;
        yx=yx|x;
        return xy-yx;
    }
    static int countBits(long number) 
    {  
        return (int)(Math.log(number) /  
                     Math.log(2) + 1); 
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