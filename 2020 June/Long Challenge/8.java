import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader fastReader = new FastReader();
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer stringBuffer = new StringBuffer();

    static int noOfQueries=120;
    public static void main(String[] args) {
        try {
            int testCases = 1;
            
            while (testCases-- > 0) {
                int n = fastReader.nextInt();
                int[] l = new int[1];
                int h[] = new int[1];
                l[0] = 1;
                h[0] = n;
                while(h[0]>=l[0] && noOfQueries<(h[0]-l[0]+1)){
                    char c=solve(l, h,Integer.MAX_VALUE,'M');
                    if(c=='E')return;
                }
                for(int i=l[0];i<=h[0];i++){
                    System.out.println(i);
                    char ans=fastReader.next().charAt(0);
                    if(ans=='E')return;
                }                
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }


    

    private static char solve(int[] l, int[] h,int prevVal,char prevAns) {
        if(h[0]<l[0])return 'N';
        int high = h[0];
        int low = l[0];
        while (high >= low) {
            int mid = (high + low) / 2;
            char ans1 = 'a';
            char ans2 = 'b';

            System.out.println(mid);
            noOfQueries--;
            ans2 = fastReader.next().charAt(0);
            if (ans2 == 'E')
                return 'E';
            if(ans2==prevAns){
                if(ans2=='L'){
                    h[0]=Math.max(mid, prevVal)-1;
                    return 'L';
                }
                if(ans2=='G'){
                    l[0]=Math.min(mid,prevVal)+1;
                    return 'G';
                }
            }
            System.out.println(mid);
            noOfQueries--;
            ans1 = fastReader.next().charAt(0);
            if (ans1 == 'E') {
                return 'E';
            }
            if (ans1 == ans2){
                if(ans1=='L'){
                    h[0]=mid-1;
                }
                if(ans1=='G'){
                    l[0]=mid+1;
                }
                return ans1;

            }
                
            int l2[]=new int[1];
            int h2[]=new int[1];
            l2[0]=low;
            h2[0]=mid-1;
            char c=solve(l2, h2,mid,ans1);
            if(c!='N'){
                if(c=='L'){
                    h[0]=h2[0];
                }
                if(c=='G'){
                    l[0]=l2[0];
                }
                if(c=='E')return 'E';
                return c;
            }else{
                int l3[]=new int[1];
                int h3[]=new int[1];
                l3[0]=mid+1;
                h3[0]=high;
                char c2=solve(l3, h3,mid,ans1);
                if(c2=='L'){
                    h[0]=h3[0];
                }
                if(c2=='G'){
                    l[0]=l3[0];
                }
                if(c2=='E')return 'E';
                return c2;
            }
            
        }
        return 'N';
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