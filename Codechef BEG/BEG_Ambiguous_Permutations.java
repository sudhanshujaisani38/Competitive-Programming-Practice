import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class BEG_Ambiguous_Permutations {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {int n;
			int actual[]=new int[1000000];
			int inverse[]=new int[1000000];
			n=fastReader.nextInt();
			while (n!=0) {
				Arrays.fill(actual,0);
				Arrays.fill(inverse,0);
				for(int i=1;i<=n;i++){
					actual[i]=fastReader.nextInt();
					inverse[actual[i]]=i;
				}
				for(int i=1;i<=n;i++){
					//out.println(actual[i]+" : "+inverse[i]);
				}
				if(Arrays.equals(actual,inverse))
					stringBuffer.append("ambiguous").append("\n");
				else
					stringBuffer.append("not ambiguous").append("\n");
				n=fastReader.nextInt();
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
				return parseInt(next());
			}
		}
}
