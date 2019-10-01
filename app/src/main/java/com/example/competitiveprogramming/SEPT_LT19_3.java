import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.jar.Manifest;

class SEPT_LT19_3 {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			while (testCases-->0) {
				int n=fastReader.nextInt();
				int queries=fastReader.nextInt();
				int b[]=new int[n-1];
				int diff=0;
				for(int i=0;i<(n-1);i++){
					b[i]=fastReader.nextInt();
				}
				for(int i=0;i<queries;i++){
					int p=fastReader.nextInt();
					int q=fastReader.nextInt();
					if(Math.abs(p-q)==1){
						int ans=b[Math.min(p,q)-1];
						stringBuffer.append(ans).append("\n");
					}else if(Math.abs(p-q)==2){
						stringBuffer.append("UNKNOWN\n");
					}else{
						int min=Math.min(p,q)-1;
						int max= Math.max(p,q)-1;
						for(int j=min;j<max;j++){
							diff+=Math.abs(b[j+1]-b[j]);
						}
						diff--;
						int ans=b[max]-diff;
						stringBuffer.append(diff).append("\n");
					}
				}
			}
			bufferedWriter.write(stringBuffer.toString().trim());
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
