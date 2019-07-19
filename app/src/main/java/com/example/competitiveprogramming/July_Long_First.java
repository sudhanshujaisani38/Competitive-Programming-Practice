import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class July_Long_First {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int n;
			double avg;
			double sum;
			long arr[]=new long[100000];
			testcases: while (testCases-->0) {
				sum=0;
				n=fastReader.nextInt();
				for(int i=0;i<n;i++){
					arr[i]=fastReader.nextLong();
					sum+=arr[i];
				}
				avg=sum/n;
				//System.out.println("Average:"+avg);
				if(avg!=(int)avg){
					//System.out.println("avg:"+avg+" (int)avg:"+(int)avg);
					stringBuffer.append("Impossible").append("\n");
					continue;
				}
				for(int i=0;i<n;i++){
					if(arr[i]==avg){
						stringBuffer.append(i+1).append("\n");
						continue testcases;
					}
				}
				stringBuffer.append("Impossible\n");

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
