import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n=fastReader.nextInt();
                String s1=fastReader.next();
                String s2=fastReader.next();
                HashMap<Character,ArrayList<Integer>> map1=new HashMap<>();
                HashMap<Character,ArrayList<Integer>> map2=new HashMap<>();
                for(int i=0;i<26;i++){
                    char c=(char)('a'+i);
                    map1.put(c,new ArrayList<>());
                    map2.put(c,new ArrayList<>());
                }
                for(int i=0;i<n;i++){
                    char c1=s1.charAt(i);
                    char c2=s2.charAt(i);
                    map1.get(c1).add(i);
                    map2.get(c2).add(i);
                }
                for(int i=0;i<26;i++){
                    char c=(char)('a'+i);
                    if(map2.get(c).size()!=0){
                        if(map1.get(c).size()==0){
                            stringBuffer.append("-1\n");
                        }
                    }
                }
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