import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class FEBLONG20_4 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            HashMap<Integer,Integer> originalIndex=new HashMap<>();
            nextTestCase:while (testCases-- > 0) {
                boolean isDivisible=true;
                int notDivisibleIndex=-1;
                int n=fastReader.nextInt();
                int ans[]=new int[n];
                Arrays.fill(ans,0);
                int p=fastReader.nextInt();
                int arr[]=new int[n];
                originalIndex.clear();
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextInt();
                    originalIndex.put(arr[i],i);
                    if(p%arr[i]!=0){
                        isDivisible=false;
                        notDivisibleIndex=i;
                    }
                }
                if(!isDivisible){
                    ans[notDivisibleIndex]=(p/arr[notDivisibleIndex])+1;
                    printYes(sb,ans);
                    continue nextTestCase;
                }
                Arrays.sort(arr);
                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        if(arr[j]%arr[i]!=0){
                            ans[originalIndex.get(arr[j])]=(p/arr[j])-1;
                            ans[originalIndex.get(arr[i])]=(arr[j]/arr[i])+1;
                            printYes(sb,ans);
                            continue nextTestCase;
                        }
                    }
                }
                sb.append("NO\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printYes(StringBuffer sb, int[] ans) {
        sb.append("YES ");
        for(int i=0;i<ans.length;i++){
            sb.append(ans[i]+" ");
        }
        sb.append("\n");
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
}
