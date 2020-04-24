import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class JuneLunchTime_First {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int x,y,k,score;
			while (testCases-->0) {
				x=fastReader.nextInt();
				y=fastReader.nextInt();
				k=fastReader.nextInt();
				score=x+y+1;
//				System.out.println("score="+k+"x"+(score/k)+"+"+(score%k));
				if(score==0){
					stringBuffer.append("Chef").append("\n");
					continue;
				}
				if((score/k)%2==0){

					if(score%k==0)
						stringBuffer.append("Paja").append("\n");
					else
						stringBuffer.append("Chef").append("\n");
					continue;
				}else{
					if(score%k==0)
						stringBuffer.append("Chef").append("\n");
					else
						stringBuffer.append("Paja").append("\n");
					continue;
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
