import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BEG_The_Lead_Game {
	static FastReader fastReader=new FastReader();
//	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static int winner=0;
	static int maxLead=0;
	public static void main(String[] args) {
		try {int lead;
			int n = fastReader.nextInt();
			int a=0,b=0;
			while (n-- > 0) {
				 a+=fastReader.nextInt();
				 b+=fastReader.nextInt();
				System.out.println(a+" "+b);
				lead=Math.abs(a-b);
				if(lead>maxLead){
					System.out.println("--max lead changed:"+lead+"--");
					maxLead=lead;
					winner=a>b?1:2;
				}
			}
//			bufferedWriter.write(winner+" "+maxLead+"\n");
//			bufferedWriter.flush();
			System.out.println(winner+" "+maxLead);
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
		String next() throws IOException {
			while (st==null||!st.hasMoreElements()){

					st=new StringTokenizer(br.readLine());

			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

	}

}
