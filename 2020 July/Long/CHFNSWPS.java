import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
                long a[]=new long[n];
                long b[]=new long[n];
                HashSet<Long> set=new HashSet<>();
                HashMap<Long,Long> map1=new HashMap<>();
                HashMap<Long,Long> map2=new HashMap<>();
                long xor=fastReader.nextLong();
                map1.put(xor, 1l);
                a[0]=xor;
                for(int i=1;i<n;i++){                    
                    a[i]=fastReader.nextLong();
                    long currFreq=map1.getOrDefault(a[i], 0l);
                    map1.put(a[i], currFreq+1);
                    xor=xor^a[i];
                    set.add(a[i]);
                }
                for(int i=0;i<n;i++){
                    b[i]=fastReader.nextLong();
                    long currFreq=map2.getOrDefault(b[i], 0l);
                    map2.put(b[i], currFreq+1);
                    xor=xor^b[i];
                    set.add(b[i]);
                }
                if(xor!=0){
                    System.out.println(-1);
                    continue;
                }
                long swaps=0;
                HashMap<Long,Long> map3=new HashMap<>();
                ArrayList<Long> list=new ArrayList<>();
                for(Long num:set){
                    long freqA=map1.getOrDefault(num, 0l);
                    long freqB=map2.getOrDefault(num, 0l);
                    long curr=(Math.abs(freqA-freqB)/2);
                    map3.put(num, curr);
                    list.add(num);
                    swaps+=curr;
                }
                Collections.sort(list);
                long minCost=list.get(0);
                long ans=0l;
                int index=0;
                long totalSwaps=swaps/2;
                for(int swapsTaken=0;swapsTaken<totalSwaps;){
                    long cost=list.get(index);
                    long freq=map3.get(cost);
                    long remainingSwaps=totalSwaps-swapsTaken;
                    freq=Math.min(remainingSwaps,freq);
                    long currAns=(Math.min(cost*freq,2*minCost*freq));
                    ans+=currAns;
                    swapsTaken+=freq;
                    index++;
                }
                System.out.println(ans);               
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
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