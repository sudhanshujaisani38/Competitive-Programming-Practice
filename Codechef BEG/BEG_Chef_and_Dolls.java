import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class BEG_Chef_and_Dolls {
	static FastReader fastReader=new FastReader();
	static BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer stringBuffer=new StringBuffer();
	static HashSet<Integer> set=new HashSet();
	public static void main(String[] args) {
		try {
			int testCases = fastReader.nextInt();
			while (testCases-->0) {
				set.clear();
				int noOfDolls=fastReader.nextInt();
				for(int i=0;i<noOfDolls;i++){
					int doll=fastReader.nextInt();
					if(set.contains(doll))
						set.remove(doll);
					else
						set.add(doll);
				}
				for (Integer i:set) {
					stringBuffer.append(i).append("\n");
				}
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
