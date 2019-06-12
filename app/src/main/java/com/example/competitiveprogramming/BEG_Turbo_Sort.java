import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class BEG_Turbo_Sort {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		try {
			int n = fastReader.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=fastReader.nextInt();
			}
			Arrays.sort(arr);
			StringBuffer stringBuffer=new StringBuffer();
			for(int i=0;i<n;i++){
				stringBuffer.append(arr[i]).append("\n");
			}
			bw.write(stringBuffer.toString());
			bw.flush();
		}catch (Exception e){
			return;
		}
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while (st==null ||!st.hasMoreElements()){
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
		long nextLong(){
			return Long.parseLong(next());
		}
		double nextDouble(){
			return Double.parseDouble(next());
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
	}
}
