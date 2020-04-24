import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BEG_Packaging_Cupcakes {
	static  FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static int maxRem=0;
	static int ans=0;
	public static void main(String[] args) {
		StringBuffer buffer=new StringBuffer();
		try {
			int testCases=fastReader.nextInt();
			while (testCases-->0){
				ans=0;
				maxRem=0;
				int num=fastReader.nextInt();
//				for(int i=num/2;i<=num;i++){
//					int tempRem=num%i;
//					if(tempRem>=maxRem){
//						maxRem=tempRem;
//						ans=i;
//					}

				ans=num/2+1;
				buffer.append(ans).append("\n");
			}
			bufferedWriter.write(buffer.toString());
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
		}
}
