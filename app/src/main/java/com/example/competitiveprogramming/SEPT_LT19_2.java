import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class SEPT_LT19_2 {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			while (testCases-->0) {
				int det=-1;
				int n=fastReader.nextInt();
				for(int i=0;i<n;i++){
					//System.out.println("det: "+det);
					int type=fastReader.nextInt();
					int a=fastReader.nextInt();
					int b=fastReader.nextInt();
					if(type==1){
						stringBuffer.append("YES").append("\n");
						det=Math.max(a,b);
						//System.out.println("clear");
					}else {
						if(a==b){
//							System.out.println("both same");
							stringBuffer.append("YES").append("\n");
							det=Math.max(a,b);
						}else{
							if((det>a && det<b)||(det>b && det<a)){
//								System.out.println("det");
								stringBuffer.append("YES").append("\n");
								det=Math.max(a,b);
							}else{
								stringBuffer.append("NO").append("\n");
							}
						}
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
