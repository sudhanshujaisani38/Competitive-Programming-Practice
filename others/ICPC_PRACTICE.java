import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class ICPC_PRACTICE {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                int k=fastReader.nextInt();
                int arr[]=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=fastReader.nextInt();
                }
                Arrays.sort(arr);
                int elementsGreaterThanK=n;
                for(int i=0;i<n;i++){
                    if(k<arr[i])
                        break;
                    elementsGreaterThanK--;
                }
                int prev=0;
                while(elementsGreaterThanK>2) {
                    if(prev==elementsGreaterThanK){
                        arr[n-1]--;
                        arr[n-2]--;
                        if(arr[n-2]==k){
                            elementsGreaterThanK--;
                        }
                    }
                    prev=elementsGreaterThanK;
                    Arrays.sort(arr);
//                    for(int j=0;j<n;j++){
//                        out.print(arr[j]+" ");
//                    }
//                    out.println();
                    for (int i = n-elementsGreaterThanK; i < n-2; i++) {
//                        out.println(arr[i]+" and "+arr[i+1]);
//                        if (arr[i] == arr[i + 1]){
//                            out.println("Found Equal, Skipping for now");
//                            continue;
//                        }
//                        else{
//                            out.println("Eliminating "+arr[i]+", reducing"+arr[i+1]);
                            int diff=arr[i]-k;
                            arr[i]=k;
                            arr[i+1]-=diff;
                            elementsGreaterThanK--;
//                        }
//                        for(int j=0;j<n;j++){
//                            out.print(arr[j]+" ");
//                        }
//                        out.println();
                    }
                }
                if(elementsGreaterThanK>=2){
//                    if(arr[n-2]!=arr[n-1]){
                        int diff2=arr[n-2]-k;
                        arr[n-2]=k;
                        arr[n-1]-=diff2;
//                        for(int j=0;j<n;j++){
//                            out.print(arr[j]+" ");
//                        }
//                        out.println();
//                    }
                }
//                out.println("Final:");
                int ans=0;
                for(int j=0;j<n;j++){
//                    out.print(arr[j]+" ");
                    ans+=arr[j];
                }
//                out.println();
                sb.append(ans).append("\n");
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
}
