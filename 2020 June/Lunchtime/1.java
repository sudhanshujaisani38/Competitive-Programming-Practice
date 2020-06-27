import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
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
                int n = fastReader.nextInt();
                int k = fastReader.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = fastReader.nextInt();
                }
                long bitValue[] = new long[32];
                Integer idx[] = new Integer[32];
                for (int i = 0; i < 32; i++) {
                    idx[i] = i;
                }
                for (int i = 0; i < n; i++) {
                    for (int bitPos = 0; bitPos < 32; bitPos++) {
                        int mask = (1 << bitPos) & arr[i];
                        bitValue[bitPos] += (mask);
                    }
                }
                Comparator<Integer> comp=new Comparator<Integer>() {

					@Override
					public int compare(Integer a, Integer b) {
                        if((bitValue[b]-bitValue[a])==0) return a-b;
                        if(bitValue[b]>bitValue[a]) return 1;
                        if(bitValue[a]>bitValue[b])return -1;
						return 0;
					}
                };
                Arrays.sort(idx,comp);
                // for(int i=0;i<idx.length;i++){
                //     System.out.print(idx[i]+"-"+bitValue[idx[i]]+",");
                // }
                // System.out.println();
                int num=0;
                for(int i=0;i<k;i++){
                    // System.out.println("adding:"+idx[i]);
                    num=num|(1<<idx[i]);
                }
                System.out.println(num);
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