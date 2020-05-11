import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);\
        FastReader sc=new FastReader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String s1=sc.next();
            String s2=sc.next();
            int n=sc.nextInt();
            int beauty[]=new int[n];
            String bStr[]=new String[n];
            for(int i=0;i<n;i++){
                bStr[i]=sc.next();
                beauty[i]=sc.nextInt();
            }
            String subStr1[]=new String[s1.length()];
            String subStr2[]=new String[s2.length()];
            int index=0;
            for(int end1=s1.length();end1>0;end1--){
                subStr1[index++]=s1.substring(0,end1);
            }

            index=0;
            for(int beg2=0;beg2<s2.length();beg2++){
                subStr2[index++]=s2.substring(beg2);
            }
            int maxBauty=0;
            for(int i=0;i<subStr1.length;i++){
                for(int j=0;j<subStr2.length;j++){
                    String temp=subStr1[i]+subStr2[j];
                    int b=calcBeauty(temp,beauty,bStr,n);
                    if(b>maxBauty){
                        maxBauty=b;
                    }
                }
            }
            System.out.println(maxBauty);
        }
    }

    private static int calcBeauty(String temp,int beauty[],String bStr[],int n) {
        // System.out.println("calculating for:"+temp);
        int ans=0;
        for(int i=0;i<temp.length();i++){
            String temp2=temp.substring(i);
            for(int j=0;j<n;j++){
                if(temp2.startsWith(bStr[j])){
                    ans+=(beauty[j]);
                }
            }
            
        }
        // System.out.println("ans for:"+temp+"="+ans);
        return ans;
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