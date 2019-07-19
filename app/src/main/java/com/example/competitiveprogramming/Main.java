import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		FastReader fastReader=new FastReader();
		StringBuffer stringBuffer=new StringBuffer();
		int n=fastReader.nextInt();
		String str=fastReader.next();
		int q=fastReader.nextInt();
		int ans=0;
		for(int i=0;i<q;i++){
			ans=0;
			int p=fastReader.nextInt();
			int startingPt=0;
			while (startingPt<(p-1)){
				int index=str.indexOf(str.charAt(p-1),startingPt);
				if(index==-1||index==(p-1))
					break;
				else{
					ans++;
					startingPt=index+1;
				}
			}
			stringBuffer.append(ans).append("\n");
		}
		bufferedWriter.write(stringBuffer.toString().trim());
		bufferedWriter.flush();
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
		int nextInt(){
			return Integer.parseInt(next());
		}
	}
}