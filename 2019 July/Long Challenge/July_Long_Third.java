import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

class July_Long_Third {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int noOfPeople,maxDiff;
			BigInteger noOfChocolates;
			while (testCases-->0) {
				noOfPeople=fastReader.nextInt();
				noOfChocolates=new BigInteger(fastReader.next());
				if(noOfChocolates.mod(BigInteger.valueOf(noOfPeople))==BigInteger.ZERO){
					maxDiff=0;
				}else{
					int rem=noOfChocolates.mod(BigInteger.valueOf(noOfPeople)).intValue();
					int diff=Math.min(rem,noOfPeople-rem);
					maxDiff=diff*2;
					if(rem==(noOfPeople-rem))
						maxDiff=2*diff-1;
				}
				stringBuffer.append(maxDiff).append("\n");
			}
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		}catch (Exception e){
			return;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while (st==null||!st.hasMoreElements()){
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		String nextLine(){
			String str="";
			try {
				str=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		long nextLong(){
			return Long.parseLong(next());
		}
		double nextDouble(){
			return Double.parseDouble(next());
		}
	}
}
