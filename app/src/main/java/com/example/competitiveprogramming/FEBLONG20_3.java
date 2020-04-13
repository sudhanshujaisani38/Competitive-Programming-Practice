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

class FEBLONG20_3 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
    static int a[]=new int[4];
    static int b[]=new int[4];
    static int c[]=new int[4];
    static int d[]=new int[4];
    static int[] getMovieName(String movieName){
        if(movieName.equals("A"))return a;
        if(movieName.equals("B"))return b;
        if(movieName.equals("C"))return c;
        else return d;
    }
    static int getTimeIndex(int time){
        if(time==12)return 0;
        if(time==3)return 1;
        if(time==6)return 2;
        else return 3;
    }
    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            long totalAns=0;

            while (testCases-- > 0) {
                Arrays.fill(a,0);
                Arrays.fill(b   ,0);
                Arrays.fill(c,0);
                Arrays.fill(d,0);
                long profitOfThisTestCase=Integer.MIN_VALUE;
                int n=fastReader.nextInt();
                for(int i=0;i<n;i++){
                    String movie=fastReader.next();
                    int time=fastReader.nextInt();
                    getMovieName(movie)[getTimeIndex(time)]++;
                }
//                out.println("--------------------");
//                for(int i=0;i<4;i++){
//                    out.print(a[i]+" ");
//                }
//                out.println();
//                for(int i=0;i<4;i++){
//                    out.print(b[i]+" ");
//                }
//                out.println();
//
//                for(int i=0;i<4;i++){
//                    out.print(c[i]+" ");
//                }
//                out.println();
//                for(int i=0;i<4;i++){
//                    out.print(d[i]+" ");
//                }
//                out.println();
//                out.println("--------------------");
                int temp[]=new int[4];
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        if(i==j)continue;
                        for(int k=0;k<4;k++){
                            if(k==i || j==k)continue;
                            for(int l=0;l<4;l++){
                                if(l==i || l==j || l==k) continue;
                                temp[i]=a[i];
                                temp[j]=b[j];
                                temp[k]=c[k];
                                temp[l]=d[l];
//                                out.println("calculating profit for ");
//
//                                out.print(temp[i]+":"+i+" "+temp[j]+":"+j+" "+temp[k]+":"+k+" "+temp[l]+":"+l+" ");
//                                out.println();
                                Arrays.sort(temp);
                                long profit=getProfit(temp);
//                                out.println("profit:"+profit);
                                if(profit>profitOfThisTestCase){
//                                    out.println("profit updated");
                                    profitOfThisTestCase=profit;
                                }
                            }
                        }
                    }
                }
                sb.append(profitOfThisTestCase).append("\n");
                totalAns+=profitOfThisTestCase;
            }
            sb.append(totalAns).append("\n");
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long getProfit(int[] temp) {
        long profit=0;
        int price=25;
        for(int i=0;i<4;i++){
            if(temp[i]==0){
                profit-=100;
                price+=25;
                continue;
            }
            profit+=(price*temp[i]);
            price+=25;
        }
        return profit;
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
