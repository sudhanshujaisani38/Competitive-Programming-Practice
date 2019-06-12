import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class BEG__Sum_of_Digits {
	static FastReader fastReader=new FastReader();
	static int sum=0;
	public static void main(String[] args) {
		int n=fastReader.nextInt();
		for(int i=0;i<n;i++) {
			sum=0;
			char[] bytes = fastReader.next().toCharArray();
			for (char c : bytes) {
				sum+=Character.getNumericValue(c);
			}
			System.out.println(sum);
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
