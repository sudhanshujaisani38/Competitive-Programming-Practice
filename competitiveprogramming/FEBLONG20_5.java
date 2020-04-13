import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class FEBLONG20_5{

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringBuffer sb = new StringBuffer();
    static FastReader fastReader = new FastReader();
    public static  boolean isLeapYear(int year) {

        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }
    static boolean isType1(Calendar calendar){
        if(isLeapYear(calendar.get(Calendar.YEAR)) && (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)){
            return true;
        }
        return false;
    }
    static boolean isType2(Calendar calendar){
        if(!isLeapYear(calendar.get(Calendar.YEAR)) && (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)){
            return true;
        }
        return false;
    }
    static boolean isType3(Calendar calendar){
        if(!isLeapYear(calendar.get(Calendar.YEAR)) && (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            int testCases = fastReader.nextInt();
            while (testCases-- > 0) {
                int m1=fastReader.nextInt();
                int y1=fastReader.nextInt();
                int m2=fastReader.nextInt();
                int y2=fastReader.nextInt();
                boolean desired[]=new boolean[400];
                int totalIn400years=0;     //no of desired years in 400-year span
                if(m1>2)y1++;
                if(m2<2)y2--;
                Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.MONTH,Calendar.FEBRUARY);
                calendar.set(Calendar.DATE,1);
               for(int year=y1;year<y1+400;year++){
                   calendar.set(Calendar.YEAR,year);
                   if(isType1(calendar) || isType2((calendar))|| isType3(calendar)){
                       desired[year%400]=true;
                       totalIn400years++;
                   }else{
                       desired[year%400]=false;
                   }
               }
               int diff=y2-y1;
               int repeating400s=diff/400;       //no of times 400-years repeat
//                out.println("repeating 400s: "+repeating400s+"*"+totalIn400years);
               int ans=0;
               ans+=(repeating400s*totalIn400years);
               int start=y1%400;
               int end=diff%400;
//                out.println("from "+start+" to "+(start+end));
               for(int i=start;i<=(start+end);i++){
                   if(desired[i%400]){
                       ans++;
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