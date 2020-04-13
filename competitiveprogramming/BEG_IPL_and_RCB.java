import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

class BEG_IPL_and_RCB {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int ans;
			while (testCases-->0) {
				ans=0;
				int pointsRequired=fastReader.nextInt();
				int matchesRemaining=fastReader.nextInt();
				if(pointsRequired<matchesRemaining)
					ans=0;
				else ans=pointsRequired-matchesRemaining;
				stringBuffer.append(ans).append("\n");
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
				br=new BufferedReader(new InputStreamReader(in));
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
				return parseInt(next());
			}
		}
}
