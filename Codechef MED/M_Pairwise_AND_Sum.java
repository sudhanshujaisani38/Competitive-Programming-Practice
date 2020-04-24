import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class M_Pairwise_AND_Sum {
	static FastReader fastReader=new FastReader();
	public static void main(String[] args) {
		try {
			int n=fastReader.nextInt();
			long arr[]=new long[n];
			long sum=0;
			for(int i=0;i<n;i++){
				arr[i]=fastReader.nextLong();
				for(int j=0;j<i;j++){
					sum+=(arr[i]&arr[j]);
				}
			}
			System.out.println(sum);
		}catch (Exception e){
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
