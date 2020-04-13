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

class FEBLONG20_6 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
    static long ans=0;
    static boolean zeroEncountered=false;

    static int search(long arr[],long key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    static void check(double pt,double dist,long arr[]){
        out.println("m.p: "+pt+" dist:"+dist);
        double diff=dist*dist-pt*pt;
        if(diff<0){
            out.println("imaginary no");
            return;
        }
        double pt1=Math.sqrt(diff);
        out.println("pt1:"+pt1);
        if(pt1!=(long)pt1)return ;
        ;
        double pt2=-1*pt1;
        out.println("required:"+pt1+" or "+pt2);
        if(search(arr,(long)pt1)!=-1 ){
            out.println("found:"+pt1);
            ans++;
        }
        if(search(arr,(long)pt2)!=-1 ){
            out.println("found:"+pt2);
            ans++;
        }
    }
    static double getDist(long x,long y){
        return Math.sqrt(x*x+y*y);
    }
    static double getMP(double x,double y){
        return (x+y)/2;
    }
    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                zeroEncountered=false;
                ans=0;
                int n=fastReader.nextInt();
                int m=fastReader.nextInt();
                long x[]=new long[n];
                long y[]=new long[m];
                for(int i=0;i<n;i++){
                    x[i]=fastReader.nextLong();
                    if(!zeroEncountered&&x[i]==0){
                        ans+=((m-1)*(n-1));
                        zeroEncountered=true;
                    }
                }
                for(int i=0;i<m;i++){
                    y[i]=fastReader.nextLong();
                    if(!zeroEncountered&&y[i]==0){
                        ans+=((n-1)*(m-1));
                        zeroEncountered=true;
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        if(i!=j && x[i]!=0 && x[j]!=0){
                            if(x[i]*x[j]>=0)continue;
                            out.println("checking for:"+x[i]+","+x[j]);
                            check(getMP(x[i],x[j]),Math.abs(x[i]-x[j])/2,y);
                        }
                    }
                }
                out.println("======================");
                for(int i=0;i<m;i++){
                    for(int j=i+1;j<m;j++){
                        if(i!=j && y[i]!=0 && y[j]!=0){
                            if(y[i]*y[j]>=0)continue;
                            out.println("checking for:"+y[i]+","+y[j]);
                            check(getMP(y[i],y[j]),Math.abs(y[i]-y[j])/2,x);
                        }
                    }
                }

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
