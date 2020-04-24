import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BEG_First_and_Last_Digit {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		try {
			int t = fastReader.nextInt();
			StringBuffer stringBuffer = new StringBuffer();
			while (t-- > 0) {
				char[] chArr=fastReader.next().toCharArray();
				int first=Character.getNumericValue(chArr[0]);
				int last=Character.getNumericValue(chArr[chArr.length-1]);
				stringBuffer.append(first+last).append("\n");
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
