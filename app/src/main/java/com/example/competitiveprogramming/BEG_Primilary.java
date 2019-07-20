import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BEG_Primilary {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			while (testCases-->0) {
				int n=fastReader.nextInt();
				if(n<2){
					stringBuffer.append("no").append("\n");
					continue;
				}
				boolean notPrime=false;
				for(int i=2;i<=n/2;i++){
					if(n%i==0) {
						stringBuffer.append("no").append("\n");
						notPrime=true;
						break;
					}
				}
				if(!notPrime){
					stringBuffer.append("yes").append("\n");
				}
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
