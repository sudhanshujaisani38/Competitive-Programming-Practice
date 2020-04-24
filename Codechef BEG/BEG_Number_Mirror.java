import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BEG_Number_Mirror {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		try {
			int n=fastReader.nextInt();
			bufferedWriter.write(n+"");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
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
