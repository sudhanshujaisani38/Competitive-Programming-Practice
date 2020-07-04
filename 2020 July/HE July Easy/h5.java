import java.io.*;
import java.util.*;

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
                long arr[]=new long[n+1];

                Integer idx[]=new Integer[n];
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextLong();
                    idx[i]=i;
                }

                Arrays.sort(idx,(i,j)->(int)(arr[i]-arr[j]));
                int ans[]=new int[n];
                HashSet<Long> set=new HashSet<>();                
                for(int i=0;i<n;i++){
                    if(set.contains(arr[idx[i]])){
                        ans[idx[i]]=1;
                    }else{
                        ans[idx[i]]=0;
                    }
                    add(arr[idx[i]],set);
                    
                }
                for(int i=0;i<n;i++){
                    System.out.print(ans[i]+" ");
                }
                System.out.println();

            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static void add(long sum, HashSet<Long> set) {
        HashSet<Long> newSet=new HashSet<>();
        for(long num:set){
            if(num+sum<=1000)
            newSet.add(num+sum);
        }
        set.add(sum);
        set.addAll(newSet);
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