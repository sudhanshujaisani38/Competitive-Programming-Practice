import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                String s1 = fastReader.next();
                String s2 = fastReader.next();
                solve(n, s1, s2);
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static void solve(int n, String s1, String s2) {
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println(-1);
                return;
            }
        }
        boolean isPresent[] = new boolean[26]; // stores if a character is present in s1 or not
        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            isPresent[c - 'a'] = true;
        }
        for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            if (!isPresent[c - 'a']) {
                System.out.println(-1);
                return ;
            }
        }
        ArrayList<ArrayList<Integer>> operations=new ArrayList<>();
        for (char c = 'z'; c >= 'a'; c--) {
            ArrayList<Integer> set = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (s2.charAt(i) == c && s1.charAt(i) != c) {
                    set.add(i);
                }
            }
            if (set.size() > 0) {
                for (int i = 0; i < n; i++) {
                    if(s1.charAt(i)==c){
                        set.add(i);
                    }
                }
                operations.add(set);
            }
            for(int i=0;i<set.size();i++){
                int index=set.get(i);
                s1=s1.substring(0, index)+c+s1.substring(index+1);
            }
        }
        System.out.println(operations.size());
        for(int i=0;i<operations.size();i++){
            ArrayList<Integer> operation=operations.get(i);
            System.out.print(operation.size());
            for(int j=0;j<operation.size();j++){
                System.out.print(" "+operation.get(j));
            }
            System.out.println();
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