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

class BEG_Lucky_4 {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(out));
	static int count=0;
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			StringBuffer stringBuffer=new StringBuffer();
			while (testCases-->0) {
				count=0;
				char[] chars=fastReader.next().toCharArray();
				for(int i=0;i<chars.length;i++){
					if(chars[i]==52)count++;
				}
				stringBuffer.append(count).append("\n");
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
