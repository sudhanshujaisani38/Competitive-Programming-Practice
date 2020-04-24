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

class BEG_Reverse_The_Number {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			StringBuffer stringBuffer=new StringBuffer();
			while (testCases-->0) {
				StringBuffer temp=new StringBuffer(fastReader.next());
				temp.reverse();
				stringBuffer.append(Integer.parseInt(temp.toString())).append("\n");
			}
			bufferedWriter.write(stringBuffer.toString());
			bufferedWriter.flush();
		}catch (Exception e){
			out.println("error");
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
			long nextLong(){
				return parseLong(next());
			}
			double nextDouble(){
				return parseDouble(next());
			}
		}
}
