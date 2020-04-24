import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class July_Cookoff {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int n,s1,r1;
			String s,r;
			while (testCases-->0) {
				s1=0;
				r1=0;
				n=fastReader.nextInt();
				s=fastReader.next();
				r=fastReader.next();
				for(int i=0;i<n;i++){
					if(s.charAt(i)=='1')
						s1++;
					if(r.charAt(i)=='1')
						r1++;
				}
				if(s1==r1)
					stringBuffer.append("YES\n");
				else
					stringBuffer.append("NO\n");
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
			int nextInt(){
				return Integer.parseInt(next());
			}
		}
}
