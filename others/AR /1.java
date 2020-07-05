import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
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
                String s = fastReader.next();
                int latest = -1;
                String temp = "";
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    // System.out.print("latest:" + latest + ", c(i):" + c+" ");
                    if (c - 'a' == latest + 1) {
                        // System.out.println("new latest");
                        latest++;
                        temp = temp + c;
                    } else if (c-'a' > (latest + 1)) {
                        System.out.println("discarding:"+c+" at "+i);
                        continue;
                    } else {
                        // System.out.println("adding");
                        temp=temp+c;
                    }
                }
                if(latest!=25){
                    System.out.println("all chars not present!");
                    System.out.println(0);
                    continue;
                }
                System.out.println(temp);
                s=temp;
                temp="";
                
                for (int i = s.length()-1; i >=0 ; i--) {
                    char c = s.charAt(i);
                    // System.out.print("latest:" + latest + ", c(i):" + c+" ");
                    if (c - 'a' == latest - 1) {
                        // System.out.println("new latest");
                        latest = c - 'a';
                        temp = c+temp;
                    } else if (c-'a' < (latest - 1)) {
                        System.out.println("discarding:"+c+" at "+i);
                        continue;
                    } else {
                        // System.out.println("adding");
                        temp=c+temp;
                    }
                }
                System.out.println(temp);
                int frq[]=new int[26];
                for(int i=0;i<temp.length();i++){
                    frq[temp.charAt(i)-'a']++;
                }
                long ans=1l;
                for(int i=0;i<26;i++){                    
                    ans=(ans*frq[i]);
                    System.out.println(frq[i]+" "+((char)('a'+i))+" ans:"+ans);
                }
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