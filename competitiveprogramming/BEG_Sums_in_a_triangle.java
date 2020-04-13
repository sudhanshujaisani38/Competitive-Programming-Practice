import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class BEG_Sums_in_a_triangle {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	static StringBuffer stringBuffer=new StringBuffer();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			int arr[][]=new int[100][100];
			while (testCases-->0) {
				int noOfRows=fastReader.nextInt();
				for(int i=0;i<noOfRows;i++){
					for(int j=0;j<=i;j++){
						arr[i][j]=fastReader.nextInt();
					}
				}
				for(int i=noOfRows-2;i>-1;i--){
					for(int j=0;j<=noOfRows;j++){
						arr[i][j]+=Math.max(arr[i+1][j],arr[i+1][j+1]);
					}
				}
				stringBuffer.append(arr[0][0]);
			}
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		}catch (Exception e){
			e.printStackTrace();
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
			long nextLong(){
				return parseLong(next());
			}
			double nextDouble(){
				return parseDouble(next());
			}
		}
}
